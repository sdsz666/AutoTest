package com.ymt.apiTest.DbTools.SqlServer;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

public interface Ymt_SellerBasicInfo {
    //修改买手所在的洲，欧洲3，澳洲5，亚洲2，非洲6，北美洲1，南美洲7
    @Update("update  ymt_SellerBasicInfo  set ContinentID=#{ContinentID} where SellerID=#{SellerID}")
    @Options(flushCache = true)
    public int  update_ContinentId_BySellerIdAndContinentId(@Param("SellerID") int SellerID, @Param("ContinentID")int ContinentID);

    //获取买手所在的洲和国家
    @Select("select ContinentID,CountryId from ymt_SellerBasicInfo where SellerID=#{SellerId}")
    @Options(flushCache = true)
    public Map<String,Object> select_ContinentIdAndCountryId_BySellerId(@Param("SellerId")int SellerId);


}
