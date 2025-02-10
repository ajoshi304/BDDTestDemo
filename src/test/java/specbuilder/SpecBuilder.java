package specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import propertyutils.PropertyLoader;

public class SpecBuilder {

      static  RequestSpecification requestSpecification;
      static  ResponseSpecification responseSpecification;

    public static RequestSpecification myReqSpec(){
        RequestSpecBuilder requestSpecBuilder= new RequestSpecBuilder().
                //  setBaseUri("https://reqres.in/")
                        setBaseUri(PropertyLoader.getPropertyLoader().getBaseurl())
                .setBasePath(PropertyLoader.getPropertyLoader().getBasepath()).
                log(LogDetail.ALL);
        requestSpecification= requestSpecBuilder.build();

        return requestSpecification;
    }

    public static ResponseSpecification myResponseSpec(){

        ResponseSpecBuilder responseSpecBuilder= new ResponseSpecBuilder().
                log(LogDetail.ALL);

        responseSpecification= responseSpecBuilder.build();

        return responseSpecification;
    }
}
