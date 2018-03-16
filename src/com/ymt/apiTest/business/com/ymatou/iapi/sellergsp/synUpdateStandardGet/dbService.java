package com.ymt.apiTest.business.com.ymatou.iapi.sellergsp.synUpdateStandardGet;

import com.ymt.apiTest.DbTools.Mysql.*;
import com.ymt.apiTest.DbTools.SqlServer.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class dbService {
    public static Seller_level seller_level=MySql.Seller_levelMapper();
    public static Seller_dsr seller_dsr=MySql.Seller_dsrMapper();
    public static Ymt_DSRAverageStatistics ymt_dsrAverageStatistics=MySql.Ymt_DSRAverageStatisticsMapper();
    public static Ymt_sellerbasicinfo MySql_Ymt_sellerbasicinfo=MySql.Ymt_sellerbasicinfoMapper();

    public static Ymt_SellerInfo ymt_sellerInfo=SqlServer.Ymt_SellerInfoMapper();
    public static Ymt_SellerBasicInfo Sql_ymt_sellerBasicInfo=SqlServer.Ymt_SellerBasicInfoMapper();
    public static Ymt_SellerManagingAbilityDTO ymt_sellerManagingAbilityDTO=SqlServer.Ymt_SellerManagingAbilityDTOMapper();
    public static Ymt_ProdLiveVideoStandard ymt_prodLiveVideoStandard=SqlServer.Ymt_ProdLiveVideoStandardMapper();

    static final Integer[] continentConf = {1, 2, 3, 5};
    static final Integer[] countryConf = {0, 1, 2, 3, 4, 5, 6, 7, 8, 48};

    //根据sellerID清理表里的数据
    public static void clearResult(int sellerId){
        ymt_prodLiveVideoStandard.delete_BySellerId(sellerId);
    }

    //修改买手入驻时间
    public static void updateApproveTime(int sellerId,int day){
        ymt_sellerInfo.update_ApproveTime_BySellerId(sellerId,day);
    }

    //修改买手等级    Inactive   Active   Warning List  Semi-Pro    Pro   Top  Newbie
    public static void updateSellerLevel(int sellerId,String sellerLevel){
        seller_level.update_sellerLevel_BySellerId(sellerId,sellerLevel);
    }

    //修改买手所在国家和大洲
    public static void updateCountryContinent(int sellerId,int CountryId,int continentid){
        Sql_ymt_sellerBasicInfo.update_ContinentId_BySellerIdAndContinentId(sellerId,CountryId,continentid);
        MySql_Ymt_sellerbasicinfo.update_ContinentIdandCountryId(sellerId,CountryId,continentid);
    }

    //修改买手Dsr
    public static void updateSellerDsr(int sellerId,double dsrScore){
        seller_dsr.update_sellerDsr_BySellerId(sellerId,dsrScore);
    }

    //修改买手所在大洲Dsr
    public static void updateContinentDsr(int sellerId,double dsrScore){
        //查询买手所比对的大洲
        Integer ContinentID= getSellerContinentID(sellerId).get("ContinentID");

        //如果最新日期有记录，则直接更新DSR分数
        if(ymt_dsrAverageStatistics.select_countNum_ByContinentID(ContinentID)>0){
            ymt_dsrAverageStatistics.update_PerDSR_ByContinentID(ContinentID,dsrScore);
        }else {
            String Ddate=ymt_dsrAverageStatistics.select_MaxDdate();
            ymt_dsrAverageStatistics.insert_item_ByContinentID(ContinentID,Ddate);
            ymt_dsrAverageStatistics.update_PerDSR_ByContinentID(ContinentID,dsrScore);
        };
    }

    //修改买手经营能力
    public static void insertAbility(int sellerId,double orderCancelRate,double orderCheatingRate,double orderLapTimeRate,double orderComplainRate){
        //更新买手经营能力
        ymt_sellerManagingAbilityDTO.insert_item_ByParameters(sellerId, orderCancelRate, orderCheatingRate, orderLapTimeRate, orderComplainRate);
    }


    //根据买手ID获取买手应该比对的大洲ID
    public static Map<String,Integer> getSellerContinentID(int sellerId) {

        Map<String, Integer> temp = MySql_Ymt_sellerbasicinfo.select_CCID_BySellerId(sellerId);
        Integer countryId = temp.get("CountryId");
        Integer continentId = temp.get("ContinentID");

        //获取配置，当前配置是写死的
        List<Integer> continentConfList = Arrays.asList(continentConf);
        List<Integer> countryConfList = Arrays.asList(countryConf);

        if (countryConfList.contains(countryId)) {
            continentId = continentId + 10000;
        } else if (continentConfList.contains(continentId)) {
            continentId = continentId * 10000;
        } else if (continentId == 1 || continentId == 7) {
            continentId = 7 * 10000;
        }
        Map<String,Integer> res = new HashMap<>();
        res.put("CountryId",countryId);
        res.put("ContinentID",continentId);
        return res;
    }

    //获取程序需要判断的所有数据
    public static void getData(int sellerId){
        String approveTime;
        String sellerLevel;
        double sellerDsr;
        double continentDsr;
        int sellerContinentId;
        int sellerCountryId;
        double OrderComplainRate;
        double OrderLapTimeRate;
        double OrderCheatingRate;
        double OrderCancelRate;

        //获取买手入驻时间
        approveTime=ymt_sellerInfo.select_ApproveTime_BySellerId(sellerId);

        //获取买手等级
        sellerLevel=seller_level.select_sellerLevel_BySellerId(sellerId);

        //获取买手DSR
        sellerDsr=seller_dsr.select_sellerDsr_BySellerId(sellerId);

        // 和他所处大洲DSR
        //买手数据所属大洲
        Map<String,Integer> res=getSellerContinentID(sellerId);
        sellerContinentId=res.get("ContinentID").intValue();
        sellerCountryId=res.get("CountryId").intValue();
        //大洲的PerDsr
        continentDsr=ymt_dsrAverageStatistics.select_PerDSR_ByContinentID(sellerContinentId);

        //买手所在大洲的经营能力情况
        Map<String,BigDecimal> res2=ymt_sellerManagingAbilityDTO.select_4Rate_BySellerId(sellerId);
        OrderComplainRate=res2.get("OrderComplainRate").doubleValue();
        OrderLapTimeRate=res2.get("OrderLapTimeRate").doubleValue();
        OrderCheatingRate=res2.get("OrderCheatingRate").doubleValue();
        OrderCancelRate=res2.get("OrderCancelRate").doubleValue();

        String ret="买手ID："+sellerId+" 国家ID："+sellerCountryId+" 判定大洲ID："+sellerContinentId+" 买手入驻时间："+
        approveTime+" 买手等级是："+sellerLevel+" 买手DSR"+sellerDsr+" 买手所在大洲的DSR7分位"+continentDsr+" 投诉率"+
                OrderComplainRate+" 揽件超时率"+OrderLapTimeRate+" 物流异常率"+OrderCheatingRate+" 订单取消率"+OrderCancelRate;
        System.out.println(ret);

    }

    //修改测试数据
    public static  void  setDate(int sellerId,int CountryId,int ContinentId,int approveDay,String sellerLevel,double sellerDsr,double continentDsr,
                                 double orderCancelRate,double orderCheatingRate,double orderLapTimeRate,double orderComplainRate){
        clearResult(sellerId);
        updateCountryContinent(sellerId,CountryId,ContinentId);
        updateApproveTime(sellerId,approveDay);
        updateSellerLevel(sellerId,sellerLevel);
        updateSellerDsr(sellerId,sellerDsr);
        updateContinentDsr(sellerId,continentDsr);
        insertAbility(sellerId,orderCancelRate,orderCheatingRate,orderLapTimeRate,orderComplainRate);
    }


    public static void main(String args[]) {


    }
}


