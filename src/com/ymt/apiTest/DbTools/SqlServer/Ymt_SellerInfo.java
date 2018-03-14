package com.ymt.apiTest.DbTools.SqlServer;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Ymt_SellerInfo {
    //修改买手入住时间,超过30天为True，不超过30天为False
    @Update("update Ymt_sellerinfo set ApproveTime=GETDATE()-#{day} where  iUserId=#{SellerID}")
    @Options(flushCache = true)
    public int update_ApproveTime_BySellerId(@Param("SellerID")int SellerID, @Param("day")int day);

    ////获取买手入驻时间
    @Select("select  ApproveTime  from Ymt_sellerinfo where iUserId=#{SellerID}")
    @Options(flushCache = true)
    public String select_ApproveTime_BySellerId(@Param("SellerID")int SellerID);

}
