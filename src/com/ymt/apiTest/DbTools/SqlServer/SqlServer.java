package com.ymt.apiTest.DbTools.SqlServer;

import com.ymt.apiTest.base.database.SqlSessionFactoryBuild;

public class SqlServer {
    public static Ymt_ProdLiveVideoStandard Ymt_ProdLiveVideoStandardMapper(){
        return SqlSessionFactoryBuild.getMapperSession("YmtSellerReport", Ymt_ProdLiveVideoStandard.class);
    }
    public static Ymt_SellerBasicInfo Ymt_SellerBasicInfoMapper(){
        return SqlSessionFactoryBuild.getMapperSession("YmtSellerReport", Ymt_SellerBasicInfo.class);
    }
    public static Ymt_SellerInfo Ymt_SellerInfoMapper(){
        return SqlSessionFactoryBuild.getMapperSession("YmtRelease", Ymt_SellerInfo.class);
    }
    public static Ymt_SellerManagingAbilityDTO Ymt_SellerManagingAbilityDTOMapper(){
        return SqlSessionFactoryBuild.getMapperSession("YmtSellerReport", Ymt_SellerManagingAbilityDTO.class);
    }

}