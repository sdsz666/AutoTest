package apiTest.base.database;

import java.util.List;
import java.util.Map;

public class TestFunction {

    public static void main(String args[]){
		/*Map<String,Object> ret = SqlSessionFactoryBuild.getMapperSession("intpro", UtilSqlInterface.class)
														.selectProductByProdId("ed1470f6-ff77-40f9-bb8f-1f8e5d4928ca");*/

        //List a = SqlMapperFactory.getIntergratedProductMapper().selectCatalogProAndValByCatalogId("78e92e88-32c1-4fb1-a146-df9bf6154733");

        List a = SqlMapperFactory.getProdLiveVideoStandardMapper().selectSqlServer_Ymt_ProdLiveVideoStandard_BySellerId(88888);
        int aa=SqlMapperFactory.getProdLiveVideoStandardMapper().deleteSqlServer_Ymt_ProdLiveVideoStandard_BySellerId(888888);
        System.out.println(a);



    }
}
