package apiTest.business.com.ymatou.iapi.sellergsp.synUpdateStandardGet.testcase;


import apiTest.base.HttpClientUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Tscase {

    HttpClientUtil postReq=new HttpClientUtil();

    final  String url="http://:sellergspjob.iapi.ymatou.com/" +
            "synUpdateStandardGet";


    @Test
    public void testcase1() throws Exception {
        Map<String, String> aa =new HashMap<String, String>();
        aa.put("SellerId","425340");
        String res1=postReq.requestPost(url,aa);
        System.out.println("这是用Map");
        System.out.println(res1);
    }
    @Test
    public void testcase2(){
        Assert.assertTrue(true);
        System.out.println("testcase1");
    }


}
