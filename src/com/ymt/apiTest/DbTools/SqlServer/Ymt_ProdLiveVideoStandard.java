package com.ymt.apiTest.DbTools.SqlServer;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface Ymt_ProdLiveVideoStandard {
    @Select("select  * from Ymt_ProdLiveVideoStandard where SellerID= #{SellerID}")
    @Options(flushCache = true)
    public List<Map<String,Object>> select_item_BySellerId(@Param("SellerID")int SellerID);

    @Delete("delete  from Ymt_ProdLiveVideoStandard where SellerID= #{SellerID}")
    @Options(flushCache = true)
    public int delete_BySellerId(@Param("SellerID")int SellerID);

    @Insert("insert into Ymt_ProdLiveVideoStandard values (#{SellerID},#{Status},'LggAutoTest','厉高歌',getdate(),getdate())")
    @Options(flushCache = true)
    public int insert_BySellerIdAndStatus(@Param("SellerID")int SellerID, @Param("Status")int Status);


 /*   @Select("select top 1 * from ymt_orderInfo where scatalogid='ef6f28e2-fc8c-4da5-84e2-21dc34bbd9fa'")
    @Options(flushCache = true)
    public Map<String,Object> selectSqlServer_Ymt_ProdLiveVideoStandard_BySellerId111();*/


}
