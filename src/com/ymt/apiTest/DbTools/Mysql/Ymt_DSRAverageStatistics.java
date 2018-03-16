package com.ymt.apiTest.DbTools.Mysql;

import org.apache.ibatis.annotations.*;

public interface Ymt_DSRAverageStatistics {
    //修改买手所在大洲地区的DSR7分位
    @Update("update ymt_DSRAverageStatistics set Per_DSR=#{Per_DSR} where ContinentID=#{ContinentID}")
    @Options(flushCache = true)
    public int update_PerDSR_ByContinentID(@Param("ContinentID")int ContinentID, @Param("Per_DSR") double Per_DSR);

    //根据大洲ID获取DSR7分位
    @Select("select max(Per_DSR) from ymt_DSRAverageStatistics where ContinentID=#{ContinentID}")
    @Options(flushCache = true)
    public double select_PerDSR_ByContinentID(@Param("ContinentID")int ContinentID);

    //查询表中Ddate的最大值，开发代码逻辑就是，时间为最大的，才是有效的数据
    @Select("select max(ddate) from ymt_DSRAverageStatistics")
    @Options(flushCache = true)
    public String select_MaxDdate();

    //根据大洲ID和最新日期查询大洲DSR记录是否存在
    @Select("select count(1)   from ymt_DSRAverageStatistics  where ContinentID=#{ContinentID}  and Ddate =(select max(ddate) from ymt_DSRAverageStatistics)")
    @Options(flushCache = true)
    public int select_countNum_ByContinentID(@Param("ContinentID")int ContinentID);

    //插入根据时间和大洲插入新记录
    @Insert("insert into ymt_DSRAverageStatistics values(#{Ddate},#{ContinentID},'美洲',1.11,2.22,3.33,4.44,5.55,6.66,7.77,8.88,now(),1)")
    @Options(flushCache = true)
    public int insert_item_ByContinentID(@Param("ContinentID")int ContinentID,@Param("Ddate") String Ddate);

}
