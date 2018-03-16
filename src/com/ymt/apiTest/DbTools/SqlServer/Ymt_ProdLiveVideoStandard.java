package com.ymt.apiTest.DbTools.SqlServer;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface Ymt_ProdLiveVideoStandard {
    @Select("select  * from Ymt_ProdLiveVideoStandard where SellerID= #{SellerID}")
    @Options(flushCache = true)
    public Map<String,Object> select_item_BySellerId(@Param("SellerID")Integer SellerID);

    @Delete("delete  from Ymt_ProdLiveVideoStandard where SellerID= #{SellerID}")
    @Options(flushCache = true)
    public int delete_BySellerId(@Param("SellerID")int SellerID);

    @Insert("insert into Ymt_ProdLiveVideoStandard values (#{SellerID},#{Status},'LggAutoTest','厉高歌',getdate(),getdate())")
    @Options(flushCache = true)
    public int insert_BySellerIdAndStatus(@Param("SellerID")int SellerID, @Param("Status")int Status);


    @Select("select * from Ymt_ProdLiveVideoStandard  where status=1")
    @Options(flushCache = true)
    public List<Map<String,Object>> test();

    @Select("select * from Ymt_ProdLiveVideoStandard  where sellerID=8888801")
    @Options(flushCache = true)
    public List<Map<String,Object>> test2();

    @Select("select * from ymt_SellerBasicInfo where CountryId=50")
    @Options(flushCache = true)
    public List<Map<String,Object>> test3();

}
