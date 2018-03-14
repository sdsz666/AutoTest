package com.ymt.apiTest.DbTools.Mysql;

import com.ymt.apiTest.base.database.SqlSessionFactoryBuild;

public class MySql {
    public static Seller_dsr Seller_dsrMapper(){
        return SqlSessionFactoryBuild.getMapperSession("biinputdb", Seller_dsr.class);
    }
    public static Seller_level Seller_levelMapper(){
        return SqlSessionFactoryBuild.getMapperSession("biinputdb", Seller_level.class);
    }
    public static Ymt_DSRAverageStatistics Ymt_DSRAverageStatisticsMapper(){
        return SqlSessionFactoryBuild.getMapperSession("biinputdb", Ymt_DSRAverageStatistics.class);
    }
    public static Ymt_sellerbasicinfo Ymt_sellerbasicinfoMapper(){
        return SqlSessionFactoryBuild.getMapperSession("biinputdb",Ymt_sellerbasicinfo.class);
    }
}

