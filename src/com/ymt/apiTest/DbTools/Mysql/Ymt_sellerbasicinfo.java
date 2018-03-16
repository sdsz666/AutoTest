package com.ymt.apiTest.DbTools.Mysql;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

public interface Ymt_sellerbasicinfo {
    @Update("update  ymt_sellerbasicinfo  set ContinentID=#{ContinentID},CountryId=#{CountryId} where SellerID=#{SellerID}")
    @Options(flushCache = true)
    public int update_ContinentIdandCountryId(@Param("SellerID")int SellerID,@Param("CountryId")int CountryId,@Param("ContinentID")int ContinentID);

    @Select("select ContinentID,CountryId from ymt_sellerbasicinfo where SellerID=425340 ")
    @Options(flushCache = true)
    public Map<String,Integer>select_CCID_BySellerId(@Param("SellerID")int SellerID);

}
