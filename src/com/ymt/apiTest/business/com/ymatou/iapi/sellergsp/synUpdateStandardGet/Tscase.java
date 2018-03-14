package com.ymt.apiTest.business.com.ymatou.iapi.sellergsp.synUpdateStandardGet;


import com.ymt.apiTest.DbTools.Mysql.MySql;
import com.ymt.apiTest.DbTools.Mysql.Seller_dsr;
import com.ymt.apiTest.DbTools.Mysql.Seller_level;
import com.ymt.apiTest.DbTools.Mysql.Ymt_DSRAverageStatistics;
import com.ymt.apiTest.DbTools.SqlServer.*;
import com.ymt.apiTest.base.HttpClientUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tscase {
    int SellerId=425340;
    int status;
    HttpClientUtil req=new HttpClientUtil();

    final  String url="http://sellergspjob.iapi.ymatou.com/" +
            "synUpdateStandardGet";



    dbUpdateService db=new dbUpdateService();

/*    DSR,买手等级，入住时间均达标
    买手经营能力（投诉率，揽件超时率，物流信息异常均达标）
    买手经营能力（付款订单取消率，亚洲，达标）*/
     /*@Test
   public void testcase1() throws Exception {
        //初始化数据
        ymt_prodLiveVideoStandard.delete_BySellerId(SellerId);

        //初始化测试数据
        db.updateTool(seller_level, seller_dsr, ymt_sellerBasicInfo,
                 ymt_sellerInfo, ymt_dsrAverageStatistics, ymt_sellerManagingAbilityDTO,
                SellerId,true,"Top",true,
                0.0000,0.0000,0.0000,0.0000);

        //展示初始化后的数据
        System.out.println(db.getDataTool(SellerId));

        *//*System.out.println("买手ID："+sellerId+" 国家ID："+sellerCountryId+" 判定大洲ID："+sellerContinentId+" 买手入驻时间："+
                approveTime+" 买手等级是："+sellerLevel+" 买手DSR"+sellerDsr+" 买手所在大洲的DSR7分位"+continentDsr+" 投诉率"+
                OrderCancelRate+" 揽件超时率"+OrderLapTimeRate+" 物流异常率"+OrderCheatingRate+" 订单取消率"+OrderCancelRate);*//*

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");

        //测试数据落地
        status=(int)ymt_prodLiveVideoStandard.select_item_BySellerId(SellerId).get(0).get("Status");
        Assert.assertEquals(status,1,"数据落地为1");

    }*/

    @Test
    public void testcase2() throws Exception {



        Assert.assertEquals(22,"ok");

        //测试数据落地
        Assert.assertEquals(status,1,"数据落地为1");


        Assert.assertTrue(true);
        System.out.println("testcase1");
    }


}
