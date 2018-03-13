package apiTest.DbTools.Mysql;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Ymt_DSRAverageStatistics {
    //修改买手所在大洲地区的DSR7分位
    @Update("update ymt_DSRAverageStatistics set Per_DSR=#{Per_DSR},Ddate=#{Ddate} where ContinentID=#{ContinentID}")
    @Options(flushCache = true)
    public int update_PerDSR_ByContinentID(@Param("ContinentID")int ContinentID, @Param("Per_DSR") double Per_DSR,@Param("Ddate")String Ddate);

    //根据大洲ID获取DSR7分位
    @Select("select max(Per_DSR) from ymt_DSRAverageStatistics where ContinentID=#{ContinentID}")
    @Options(flushCache = true)
    public double select_PerDSR_ByContinentID(@Param("ContinentID")int ContinentID);

    //查询表中Ddate的最大值，开发代码逻辑就是，时间为最大的，才是有效的数据
    @Select("select max(ddate) from ymt_DSRAverageStatistics")
    @Options(flushCache = true)
    public String select_MaxDdate();

}
