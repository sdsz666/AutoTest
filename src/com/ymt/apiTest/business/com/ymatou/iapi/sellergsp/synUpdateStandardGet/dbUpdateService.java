package com.ymt.apiTest.business.com.ymatou.iapi.sellergsp.synUpdateStandardGet;

import com.ymt.apiTest.DbTools.Mysql.*;
import com.ymt.apiTest.DbTools.SqlServer.*;
import com.sun.media.jfxmedia.logging.Logger;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class dbUpdateService {



    public Seller_level seller_level;
    public Seller_dsr seller_dsr;
    public Ymt_SellerBasicInfo Sql_ymt_sellerBasicInfo;
    public Ymt_sellerbasicinfo MySql_Ymt_sellerbasicinfo;
    public Ymt_SellerInfo ymt_sellerInfo;
    public Ymt_DSRAverageStatistics ymt_dsrAverageStatistics;
    public Ymt_SellerManagingAbilityDTO ymt_sellerManagingAbilityDTO;
    public Ymt_ProdLiveVideoStandard ymt_prodLiveVideoStandard;

    final Integer[] continentConf = {1, 2, 3, 5};
    final Integer[] countryConf = {0, 1, 2, 3, 4, 5, 6, 7, 8, 48};


    public dbUpdateService() {
        seller_level = MySql.Seller_levelMapper();
        seller_dsr = MySql.Seller_dsrMapper();
        Sql_ymt_sellerBasicInfo = SqlServer.Ymt_SellerBasicInfoMapper();
        MySql_Ymt_sellerbasicinfo= MySql.Ymt_sellerbasicinfoMapper();
        ymt_sellerInfo = SqlServer.Ymt_SellerInfoMapper();
        ymt_dsrAverageStatistics = MySql.Ymt_DSRAverageStatisticsMapper();
        ymt_sellerManagingAbilityDTO = SqlServer.Ymt_SellerManagingAbilityDTOMapper();
        ymt_prodLiveVideoStandard=SqlServer.Ymt_ProdLiveVideoStandardMapper();
    }

    //根据sellerID清理表里的数据
    public void clearResult(int SellerId){
        ymt_prodLiveVideoStandard.delete_BySellerId(SellerId);
    }

    //修改买手入驻时间
    public void updateApproveTime(int SellerId,int day){
        ymt_sellerInfo.update_ApproveTime_BySellerId(SellerId,day);
    }

    //修改买手等级    Inactive   Active   Warning List  Semi-Pro    Pro   Top  Newbie
    public void updateSellerLevel(int SellerId,String sellerLevel){
        seller_level.update_sellerLevel_BySellerId(SellerId,sellerLevel);
    }

    //修改买手所在国家和大洲
    public void updateCountryContinent(int sellerId,int CountryId,int ContinentID){
        Sql_ymt_sellerBasicInfo.update_ContinentId_BySellerIdAndContinentId(sellerId,CountryId,ContinentID);
        MySql_Ymt_sellerbasicinfo.update_ContinentIdandCountryId(sellerId,CountryId,ContinentID);
    }

    //修改买手Dsr
    public void updateSellerDsr(int SellerId,double dsrScore){
        seller_dsr.update_sellerDsr_BySellerId(SellerId,dsrScore);
    }

    //修改买手所在大洲Dsr
    public void updateContinentDsr(int SellerId,double dsrScore){
        //查询买手所比对的大洲
        Integer ContinentID= getSellerContinentID(SellerId).get("ContinentID");

        String Ddate=ymt_dsrAverageStatistics.select_MaxDdate();




    }

    //根据买手ID获取买手应该比对的大洲ID
    public Map<String,Integer> getSellerContinentID(int sellerId) {

        Map<String, Integer> temp = MySql_Ymt_sellerbasicinfo.select_CCID_BySellerId(sellerId);
        Integer countryId = temp.get("CountryId");
        Integer continentId = temp.get("ContinentID");

        List<Integer> continentConfList = Arrays.asList(continentConf);
        List<Integer> countryConfList = Arrays.asList(countryConf);

        if (countryConfList.contains(countryId)) {
            continentId = continentId + 10000;
        } else if (continentConfList.contains(continentId)) {
            continentId = continentId * 10000;
        } else if (continentId == 1 || continentId == 7) {
            continentId = 7 * 10000;
        }
        Map<String,Integer> res = null;
        res.put("CountryId",countryId);
        res.put("ContinentID",continentId);
        return res;
    }










    public void updateTool(int sellerId, boolean EnterCase, String sellerLevel, boolean dsrCase,
                           double OrderCancelRate, double OrderCheatingRate, double OrderLapTimeRate, double OrderComplainRate) {


        //更新买手入驻天数
        if (EnterCase) {
            ymt_sellerInfo.update_ApproveTime_BySellerId(sellerId, 61);
        } else {
            ymt_sellerInfo.update_ApproveTime_BySellerId(sellerId, 60);
        }

        //更新买手等级
        seller_level.update_sellerLevel_BySellerId(sellerId, sellerLevel);

        //更新买手DSR
        seller_dsr.update_sellerDsr_BySellerId(sellerId,5.55);

        //更新买手所在大洲DSR
        double dsr = seller_dsr.select_sellerDsr_BySellerId(sellerId);
        int continentId = getSellerContinentID(sellerId).get("ContinentID").intValue();
        String Ddate=ymt_dsrAverageStatistics.select_MaxDdate();
        if (dsrCase) {
            ymt_dsrAverageStatistics.update_PerDSR_ByContinentID(continentId,dsr - 0.01);
        } else {
            ymt_dsrAverageStatistics.update_PerDSR_ByContinentID(continentId, dsr);
        }

        //更新买手经营能力
        ymt_sellerManagingAbilityDTO.insert_item_ByParameters(sellerId,
                OrderCancelRate, OrderCheatingRate, OrderLapTimeRate, OrderComplainRate);
    }

    //获取程序需要判断的所有数据
    public String getDataTool(int sellerId){
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
                OrderCancelRate+" 揽件超时率"+OrderLapTimeRate+" 物流异常率"+OrderCheatingRate+" 订单取消率"+OrderCancelRate;
        return  ret;

/*        Logger.logMsg(Logger.INFO,"买手ID："+sellerId+" 国家ID："+sellerCountryId+" 判定大洲ID："+sellerContinentId+" 买手入驻时间："+
                approveTime+" 买手等级是："+sellerLevel+" 买手DSR"+sellerDsr+" 买手所在大洲的DSR7分位"+continentDsr+" 投诉率"+
                OrderCancelRate+" 揽件超时率"+OrderLapTimeRate+" 物流异常率"+OrderCheatingRate+" 订单取消率"+OrderCancelRate);*/
    }



    public static void main(String args[]) {
        System.out.println(11);

    }
}


