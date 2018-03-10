package apiTest.base.database;

import apiTest.business.com.ymatou.iapi.sellergsp.ProdLiveVideoStandard.service.ProdLiveVideoStandardMapper;

public class SqlMapperFactory {
    public static ProdLiveVideoStandardMapper getProdLiveVideoStandardMapper(){
        return SqlSessionFactoryBuild.getMapperSession("YmtRelease", ProdLiveVideoStandardMapper.class);
    }
}
