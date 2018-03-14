package com.ymt.apiTest.DbTools.Mysql;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Seller_dsr {
    //获取买手Dsr分数
    @Select("select Total_Score from seller_dsr where sellerid=#{SellerId}")
    @Options(flushCache = true)
    public double select_sellerDsr_BySellerId(@Param("SellerId")int SellerId);


    //更新买手DSR
    @Update("update  seller_dsr  set Total_Score=#{TotalScore} where sellerid=#{SellerId}")
    @Options(flushCache = true)
    public int update_sellerDsr_BySellerId(@Param("SellerId")int SellerId,@Param("TotalScore")double TotalScore);





}


