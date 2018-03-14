package com.ymt.apiTest.business.com.ymatou.iapi.sellergsp.ProdLiveVideoStandard;


import com.ymt.apiTest.DbTools.Mysql.MySql;
import com.ymt.apiTest.DbTools.SqlServer.SqlServer;
import com.ymt.apiTest.base.HttpClientUtil;
import com.ymt.apiTest.DbTools.SqlServer.Ymt_ProdLiveVideoStandard;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Tscase {
    private static final Logger Logger= LoggerFactory.getLogger(Tscase.class);
    final  String url="http://sellergsp.iapi.ymatou.com/" +
            "api/SellerManagingAbilityModel/ProdLiveVideoStandard";

    HttpClientUtil Req =new HttpClientUtil();

    Ymt_ProdLiveVideoStandard dbTool= SqlServer.Ymt_ProdLiveVideoStandardMapper();


    //买手ID过长
    @Test
    private void testcase1() throws Exception {
        String testId="88888888888";
        Map<String, String> ReqParameter =new HashMap<String, String>();
        ReqParameter.put("SellerId",testId);
        String res= Req.requestPost(url,ReqParameter);
        System.out.println(res);
        Assert.assertTrue(res.contains("买手ID无效"));
        Logger.info("这是日志");
    }

    //记录不存在，返回false
    @Test
    private void testcase2() throws Exception {
        int testId=88888;

        if(!dbTool.select_item_BySellerId(testId).isEmpty()){
            dbTool.delete_BySellerId(testId);
            return;
        }
        Map<String, String> ReqParameter =new HashMap<String, String>();
        ReqParameter.put("SellerId",String.valueOf(testId));
        JSONObject responseJson= (JSONObject) JSON.parse(Req.requestPost(url,ReqParameter));
        String code=responseJson.getString("Code");
        String HasStandard=responseJson.getJSONObject("Data").getString("HasStandard");
        Assert.assertEquals(code,"200","返回200");
        Assert.assertEquals(HasStandard,"false","记录不存在，权限应为false");
    }

    //记录存在，status为0，返回false
    @Test
    private void testcase3() throws Exception {
        int testId=8888800;
        int testStatus=0;

        if(dbTool.select_item_BySellerId(testId).isEmpty()){
            dbTool.insert_BySellerIdAndStatus(testId,testStatus);
            return;
        }
        Map<String, String> ReqParameter =new HashMap<String, String>();
        ReqParameter.put("SellerId",String.valueOf(testId));
        JSONObject json= (JSONObject) JSON.parse(Req.requestPost(url,ReqParameter));
        String code=json.getString("Code");
        String HasStandard=json.getJSONObject("Data").getString("HasStandard");
        Assert.assertEquals(code,"200","返回200");
        Assert.assertEquals(HasStandard,"false","状态Status为0，权限应为false");
    }

    //记录存在，status为1，返回True
    @Test
    private void testcase4() throws Exception {
        int testId=8888801;
        int testStatus=1;

        if(dbTool.select_item_BySellerId(testId).isEmpty()){
            dbTool.insert_BySellerIdAndStatus(testId,testStatus);
            return;
        }
        Map<String, String> ReqParameter =new HashMap<String, String>();
        ReqParameter.put("SellerId",String.valueOf(testId));
        JSONObject json= (JSONObject) JSON.parse(Req.requestPost(url,ReqParameter));
        String code=json.getString("Code");
        String HasStandard=json.getJSONObject("Data").getString("HasStandard");
        Assert.assertEquals(code,"200","返回200");
        Assert.assertEquals(HasStandard,"true","状态Status为1，权限应为true");
    }

    //记录存在，status为2，返回False
    @Test
    private void testcase5() throws Exception {
        int testId=8888802;
        int testStatus=2;

        if(dbTool.select_item_BySellerId(testId).isEmpty()){
            dbTool.insert_BySellerIdAndStatus(testId,testStatus);
            return;
        }
        Map<String, String> ReqParameter =new HashMap<String, String>();
        ReqParameter.put("SellerId",String.valueOf(testId));
        JSONObject json= (JSONObject) JSON.parse(Req.requestPost(url,ReqParameter));
        String code=json.getString("Code");
        String HasStandard=json.getJSONObject("Data").getString("HasStandard");
        Assert.assertEquals(code,"200","返回200");
        Assert.assertEquals(HasStandard,"false","状态Status为2，权限应为false");
    }

    //记录存在，status为3，返回False
    @Test
    private void testcase6() throws Exception {
        int testId=8888803;
        int testStatus=3;

        if(dbTool.select_item_BySellerId(testId).isEmpty()){
            dbTool.insert_BySellerIdAndStatus(testId,testStatus);
            return;
        }
        Map<String, String> ReqParameter =new HashMap<String, String>();
        ReqParameter.put("SellerId",String.valueOf(testId));
        JSONObject json= (JSONObject) JSON.parse(Req.requestPost(url,ReqParameter));
        String code=json.getString("Code");
        String HasStandard=json.getJSONObject("Data").getString("HasStandard");
        Assert.assertEquals(code,"200","返回200");
        Assert.assertEquals(HasStandard,"false","状态Status为3，权限应为false");
    }

    //记录存在，status为4，返回True
    @Test
    private void testcase7() throws Exception {
        int testId=8888804;
        int testStatus=4;

        if(dbTool.select_item_BySellerId(testId).isEmpty()){
            dbTool.insert_BySellerIdAndStatus(testId,testStatus);
            return;
        }
        Map<String, String> ReqParameter =new HashMap<String, String>();
        ReqParameter.put("SellerId",String.valueOf(testId));
        JSONObject json= (JSONObject) JSON.parse(Req.requestPost(url,ReqParameter));
        String code=json.getString("Code");
        String HasStandard=json.getJSONObject("Data").getString("HasStandard");
        Assert.assertEquals(code,"200","返回200");
        Assert.assertEquals(HasStandard,"true","状态Status为4，权限应为true");
    }

    //记录存在，status为5，返回True
    @Test
    private void testcase8() throws Exception {
        int testId=8888805;
        int testStatus=5;

        if(dbTool.select_item_BySellerId(testId).isEmpty()){
            dbTool.insert_BySellerIdAndStatus(testId,testStatus);
            return;
        }
        Map<String, String> ReqParameter =new HashMap<String, String>();
        ReqParameter.put("SellerId",String.valueOf(testId));
        JSONObject json= (JSONObject) JSON.parse(Req.requestPost(url,ReqParameter));
        String code=json.getString("Code");
        String HasStandard=json.getJSONObject("Data").getString("HasStandard");
        Assert.assertEquals(code,"200","返回200");
        Assert.assertEquals(HasStandard,"true","状态Status为5，权限应为true");
    }

    //记录存在，status为6，返回True
    @Test
    private void testcase9() throws Exception {
        int testId=8888806;
        int testStatus=6;

        if(dbTool.select_item_BySellerId(testId).isEmpty()){
            dbTool.insert_BySellerIdAndStatus(testId,testStatus);
            return;
        }
        Map<String, String> ReqParameter =new HashMap<String, String>();
        ReqParameter.put("SellerId",String.valueOf(testId));
        JSONObject json= (JSONObject) JSON.parse(Req.requestPost(url,ReqParameter));
        String code=json.getString("Code");
        String HasStandard=json.getJSONObject("Data").getString("HasStandard");
        Assert.assertEquals(code,"200","返回200");
        Assert.assertEquals(HasStandard,"true","状态Status为6，权限应为true");
    }

    //记录存在，status为7，返回True
    @Test
    private void testcase10() throws Exception {
        int testId=8888807;
        int testStatus=7;

        if(dbTool.select_item_BySellerId(testId).isEmpty()){
            dbTool.insert_BySellerIdAndStatus(testId,testStatus);
            return;
        }
        Map<String, String> ReqParameter =new HashMap<String, String>();
        ReqParameter.put("SellerId",String.valueOf(testId));
        JSONObject json= (JSONObject) JSON.parse(Req.requestPost(url,ReqParameter));
        String code=json.getString("Code");
        String HasStandard=json.getJSONObject("Data").getString("HasStandard");
        Assert.assertEquals(code,"200","返回200");
        Assert.assertEquals(HasStandard,"true","状态Status为7，权限应为true");
    }




}
