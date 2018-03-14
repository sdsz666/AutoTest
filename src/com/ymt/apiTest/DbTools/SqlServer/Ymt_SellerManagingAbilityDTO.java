package com.ymt.apiTest.DbTools.SqlServer;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface Ymt_SellerManagingAbilityDTO {
    //插入买手经营能力
    @Insert("INSERT INTO ymt_SellerManagingAbilityDTO\n" +
            "     VALUES(GETDATE(),#{SellerID},1 ,#{OrderCancelRate},0.1800,1,#{OrderCheatingRate},0.1800,1,#{OrderLapTimeRate},0.1800,1\n" +
            "           ,#{OrderComplainRate},0.1800,1,GETDATE(),GETDATE(),0.0000,0.0000,0.0000,0.0000,0,0,0,0,0)")
    @Options(flushCache = true)
    public int insert_item_ByParameters(@Param("SellerID")int SellerID, @Param("OrderCancelRate")double OrderCancelRate,
                                                                       @Param("OrderCheatingRate")double OrderCheatingRate, @Param("OrderLapTimeRate")double OrderLapTimeRate,
                                                                       @Param("OrderComplainRate")double OrderComplainRate);

    //查询买手经营能力
    @Select("select top 1 OrderComplainRate,OrderLapTimeRate,OrderCheatingRate,OrderCancelRate from ymt_SellerManagingAbilityDTO where SellerID=#{SellerID} order by Ddate desc")
    @Options(flushCache = true)
    public Map<String,BigDecimal> select_4Rate_BySellerId(@Param("SellerID") int SellerID);

}
