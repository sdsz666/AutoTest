package com.ymt.apiTest.business.com.ymatou.iapi.sellergsp.synUpdateStandardGet;

import com.ymt.apiTest.DbTools.Mysql.MySql;
import com.ymt.apiTest.DbTools.Mysql.Seller_dsr;
import com.ymt.apiTest.DbTools.Mysql.Seller_level;
import com.ymt.apiTest.DbTools.Mysql.Ymt_DSRAverageStatistics;
import com.ymt.apiTest.DbTools.SqlServer.SqlServer;
import com.ymt.apiTest.DbTools.SqlServer.Ymt_SellerBasicInfo;
import com.ymt.apiTest.DbTools.SqlServer.Ymt_SellerInfo;
import com.ymt.apiTest.DbTools.SqlServer.Ymt_SellerManagingAbilityDTO;
import com.sun.media.jfxmedia.logging.Logger;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class dbUpdateService {
    public Seller_level seller_level;
    public Seller_dsr seller_dsr;
    public Ymt_SellerBasicInfo ymt_sellerBasicInfo;
    public Ymt_SellerInfo ymt_sellerInfo;
    public Ymt_DSRAverageStatistics ymt_dsrAverageStatistics;
    public Ymt_SellerManagingAbilityDTO ymt_sellerManagingAbilityDTO;

    public dbUpdateService() {
        seller_level = MySql.Seller_levelMapper();
        seller_dsr = MySql.Seller_dsrMapper();
        ymt_sellerBasicInfo = SqlServer.Ymt_SellerBasicInfoMapper();
        ymt_sellerInfo = SqlServer.Ymt_SellerInfoMapper();
        ymt_dsrAverageStatistics = MySql.Ymt_DSRAverageStatisticsMapper();
        ymt_sellerManagingAbilityDTO = SqlServer.Ymt_SellerManagingAbilityDTOMapper();
    }


    public void updateTool(Seller_level seller_level,Seller_dsr seller_dsr,Ymt_SellerBasicInfo ymt_sellerBasicInfo,
                           Ymt_SellerInfo ymt_sellerInfo,Ymt_DSRAverageStatistics ymt_dsrAverageStatistics,Ymt_SellerManagingAbilityDTO ymt_sellerManagingAbilityDTO,
                            int sellerId, boolean EnterCase, String sellerLevel, boolean dsrCase,
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
            ymt_dsrAverageStatistics.update_PerDSR_ByContinentID(continentId,dsr - 0.01,Ddate);
        } else {
            ymt_dsrAverageStatistics.update_PerDSR_ByContinentID(continentId, dsr,Ddate);
        }

        //更新买手经营能力
        ymt_sellerManagingAbilityDTO.insert_item_ByParameters(sellerId,
                OrderCancelRate, OrderCheatingRate, OrderLapTimeRate, OrderComplainRate);
    }
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


    public Map<String,Integer> getSellerContinentID(int sellerId) {
        Map<String,Integer> res=new HashMap<String,Integer>();

        Map<String, Object> temp = ymt_sellerBasicInfo.select_ContinentIdAndCountryId_BySellerId(sellerId);
        Integer countryId = (Integer) temp.get("CountryId");
        Integer continentId = (Integer) temp.get("ContinentID");

        Integer[] continentConf = {1, 2, 3, 5};
        Integer[] countryConf = {0, 1, 2, 3, 4, 5, 6, 7, 8, 48};
        List<Integer> continentConfList = Arrays.asList(continentConf);
        List<Integer> countryConfList = Arrays.asList(countryConf);

        if (countryConfList.contains(countryId)) {
            continentId = continentId + 10000;
        } else if (continentConfList.contains(continentId)) {
            continentId = continentId * 10000;
        } else if (continentId == 1 || continentId == 7) {
            continentId = 7 * 10000;
        }
        res.put("CountryId",countryId);
        res.put("ContinentID",continentId);
        return res;
    }


    public static void main(String args[]) {
        System.out.println(11);

    }
}


