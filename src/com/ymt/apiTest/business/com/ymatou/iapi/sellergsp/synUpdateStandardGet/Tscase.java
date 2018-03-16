package com.ymt.apiTest.business.com.ymatou.iapi.sellergsp.synUpdateStandardGet;


import com.ymt.apiTest.base.HttpClientUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

@Test
public class Tscase {
    static int sellerId=425340;
    static int status;
    static HttpClientUtil req=null;
    static final  String url="http://sellergspjob.iapi.ymatou.com/" +
            "synUpdateStandardGet";



    //其他条件均满足，测试订单取消率，(北美洲1)达标
   public void testcase1() throws Exception {

        dbService.setDate(sellerId,0,1,60,"Top",5.55,5,
                0.0999,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");

        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
        int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;
        Assert.assertEquals(status,1,"数据落地为1");
    }

    //其他条件均满足，测试订单取消率，(北美洲1)不达标
    public void testcase2() throws Exception {

        dbService.setDate(sellerId,0,1,60,"Top",5.55,5,
                0.1,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
        int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }

    //其他条件均满足，测试订单取消率，(亚洲2)不达标
    public void testcase3() throws Exception {

        dbService.setDate(sellerId,0,2,60,"Top",5.55,5,
                0.06,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }

    //其他条件均满足，测试订单取消率，(亚洲2)达标
    public void testcase4() throws Exception {

        dbService.setDate(sellerId,0,2,60,"Top",5.55,5,
                0.0599,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试订单取消率，(澳洲5)达标
    public void testcase5() throws Exception {

        dbService.setDate(sellerId,0,5,60,"Top",5.55,5,
                0.0799,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试订单取消率，(澳洲5)不达标
    public void testcase6() throws Exception {

        dbService.setDate(sellerId,0,5,60,"Top",5.55,5,
                0.08,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }

    //其他条件均满足，测试订单取消率，(欧洲3）不达标
    public void testcase7() throws Exception {

        dbService.setDate(sellerId,0,3,60,"Top",5.55,5,
                0.15,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }

    //其他条件均满足，测试订单取消率，(欧洲3）达标
    public void testcase8() throws Exception {

        dbService.setDate(sellerId,0,3,60,"Top",5.55,5,
                0.1499,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试物流异常率，(欧洲3）达标
    public void testcase9() throws Exception {

        dbService.setDate(sellerId,0,3,60,"Top",5.55,5,
                0,0.0999,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试物流异常率，(欧洲3）不达标
    public void testcase10() throws Exception {

        dbService.setDate(sellerId,0,3,60,"Top",5.55,5,
                0,0.1,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }

    //其他条件均满足，测试揽件超时率，(欧洲3）不达标
    public void testcase11() throws Exception {

        dbService.setDate(sellerId,0,3,60,"Top",5.55,5,
                0,0,0.1,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }

    //其他条件均满足，测试揽件超时率，(欧洲3）达标
    public void testcase12() throws Exception {

        dbService.setDate(sellerId,0,3,60,"Top",5.55,5,
                0,0,0.9999,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试投诉率，(欧洲3）达标
    public void testcase13() throws Exception {

        dbService.setDate(sellerId,0,3,60,"Top",5.55,5,
                0,0,0,0.0099);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试投诉率，(欧洲3）不达标
    public void testcase14() throws Exception {

        dbService.setDate(sellerId,0,3,60,"Top",5.55,5,
                0,0,0,0.01);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }

    //其他条件均满足，测试买手DSR，（国家0，大洲1）买手高于大洲*0.98，达标（0,1,2,3,4,5,6,7,8,48 这些国家的买手continentId=continentId+10000;）
    public void testcase15() throws Exception {

        dbService.setDate(sellerId,0,1,60,"Top",5.55,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试买手DSR，（国家0，大洲1）买手等于大洲*0.98，达标（0,1,2,3,4,5,6,7,8,48 这些国家的买手continentId=continentId+10000;）
    public void testcase16() throws Exception {

        dbService.setDate(sellerId,0,1,60,"Top",5.439,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试买手DSR，（国家0，大洲1）买手小于大洲*0.98，不达标（0,1,2,3,4,5,6,7,8,48 这些国家的买手continentId=continentId+10000;）
    public void testcase17() throws Exception {

        dbService.setDate(sellerId,0,1,60,"Top",5.42,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }

    //其他条件均满足，测试买手DSR，（国家48，大洲1）买手小于大洲*0.98，不达标（0,1,2,3,4,5,6,7,8,48 这些国家的买手continentId=continentId+10000;）
    public void testcase18() throws Exception {

        dbService.setDate(sellerId,48,1,60,"Top",5.438,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }

    //其他条件均满足，测试买手DSR，（国家48，大洲1）买手小于大洲*0.98，不达标（0,1,2,3,4,5,6,7,8,48 这些国家的买手continentId=continentId+10000;）
    public void testcase19() throws Exception {

        dbService.setDate(sellerId,48,1,60,"Top",5.44,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试买手DSR，（国家50，大洲2）买手等于大洲*0.98，达标（0,1,2,3,4,5,6,7,8,48 这些国家的买手continentId=continentId+10000;）
    public void testcase20() throws Exception {

        dbService.setDate(sellerId,50,2,60,"Top",5.44,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试买手DSR，（国家50，大洲2）买手小于大洲*0.98，不达标（0,1,2,3,4,5,6,7,8,48 这些国家的买手continentId=continentId+10000;）
    public void testcase21() throws Exception {

        dbService.setDate(sellerId,50,2,60,"Top",5.43,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }

    //其他条件均满足，测试买手DSR，（国家43，大洲7）买手小于大洲*0.98，不达标（0,1,2,3,4,5,6,7,8,48 这些国家的买手continentId=continentId+10000;）
    public void testcase22() throws Exception {

        dbService.setDate(sellerId,43,7,60,"Top",5.43,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }

    //其他条件均满足，测试买手DSR，（国家43，大洲7）买手等于大洲*0.98，不达标（0,1,2,3,4,5,6,7,8,48 这些国家的买手continentId=continentId+10000;）
    public void testcase23() throws Exception {

        dbService.setDate(sellerId,43,7,60,"Top",5.44,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试买手DSR，（国家43，大洲7）买手等于大洲*0.98，达标（0,1,2,3,4,5,6,7,8,48 这些国家的买手continentId=continentId+10000;）
    public void testcase24() throws Exception {

        dbService.setDate(sellerId,43,7,60,"Top",5.44,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试买手DSR，（国家44，大洲8）买手等于大洲*0.98，达标（0,1,2,3,4,5,6,7,8,48 这些国家的买手continentId=continentId+10000;）
    public void testcase25() throws Exception {

        dbService.setDate(sellerId,44,8,60,"Top",5.44,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试买手DSR，（国家44，大洲8）买手小于大洲*0.98，达标（0,1,2,3,4,5,6,7,8,48 这些国家的买手continentId=continentId+10000;）
    public void testcase26() throws Exception {

        dbService.setDate(sellerId,44,8,60,"Top",5.43,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }

    //其他条件均满足，测试买手等级，（国家44，大洲8）买手Inactive，不达标
    public void testcase27() throws Exception {

        dbService.setDate(sellerId,44,8,60,"Inactive",5.55,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }

    //其他条件均满足，测试买手等级，（国家44，大洲8）买手Warning List，不达标
    public void testcase28() throws Exception {

        dbService.setDate(sellerId,44,8,60,"Warning List",5.55,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }

    //其他条件均满足，测试买手等级，（国家44，大洲8）买手Newbie，不达标
    public void testcase29() throws Exception {

        dbService.setDate(sellerId,44,8,60,"Newbie",5.55,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }

    //其他条件均满足，测试买手等级，（国家44，大洲8）买手Active，不达标
    public void testcase30() throws Exception {

        dbService.setDate(sellerId,44,8,60,"Active",5.55,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试买手等级，（国家44，大洲8）买手Semi-Pro，不达标
    public void testcase31() throws Exception {

        dbService.setDate(sellerId,44,8,60,"Semi-Pro",5.55,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试买手等级，（国家44，大洲8）买手Pro，不达标
    public void testcase32() throws Exception {

        dbService.setDate(sellerId,44,8,60,"Pro",5.55,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");


        Thread.sleep(5000);

        //测试数据落地
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
       int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,1,"数据落地为2");
    }

    //其他条件均满足，测试买手入驻时间，（国家44，大洲8）入驻59天，不达标
    public void testcase33() throws Exception {

        dbService.setDate(sellerId,44,8,59,"Pro",5.55,5.55,
                0,0,0,0);

        dbService.getData(sellerId);

        //调用接口，预期返回Ok
        String res= req.requestGet(url,null);
        Assert.assertEquals(res,"ok");

        Thread.sleep(5000);

        //测试数据落地
        Map<String,Object> ret=dbService.ymt_prodLiveVideoStandard.select_item_BySellerId(sellerId);
        int status = ret!=null&& !ret.isEmpty()?(int)ret.get("Status"):0;

        Assert.assertEquals(status,2,"数据落地为2");
    }
}
