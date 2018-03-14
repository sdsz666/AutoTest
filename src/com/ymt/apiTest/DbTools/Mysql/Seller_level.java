package com.ymt.apiTest.DbTools.Mysql;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Seller_level {
    //修改买手等级
    @Update("update seller_level  set seller_level=#{seller_level} where sellerid=#{SellerID}")
    @Options(flushCache = true)
    public int update_sellerLevel_BySellerId(@Param("SellerID")int SellerID, @Param("seller_level")String seller_level);

    //获取买手等级
    @Select("select seller_level from  seller_level where sellerid=#{SellerID}")
    @Options(flushCache = true)
    public String select_sellerLevel_BySellerId(@Param("SellerID")int SellerID);

}
