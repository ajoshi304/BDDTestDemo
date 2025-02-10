package stepDefinitions;

import endpoints.Endpoints;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import pojos.User;
import specbuilder.SpecBuilder;
import utils.TestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ReqRes {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;

    @Given("user sets the specification")
    public void user_sets_the_specification() {

        System.out.println("");
      requestSpecification=given().
              log().all().
              baseUri("https://reqres.in/").
              basePath("/api");
        RequestSpecBuilder  requestSpecBuilder= new RequestSpecBuilder().
                setBaseUri("https://reqres.in/")
                .setBasePath("/api").
                log(LogDetail.ALL);
        requestSpecification= requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder= new ResponseSpecBuilder().
                log(LogDetail.ALL);

     responseSpecification= responseSpecBuilder.build();



    }
        @When("user hits the getsingleuser endpoint for the http get method")
        public void hits_the_singleuser_endpoint_for_the_http_get_method() {
         response= given(SpecBuilder.myReqSpec()).
                 when().
                 get("/users/2").
                 then().spec(SpecBuilder.myResponseSpec()).
                 extract().response();

//             log().all().
//             extract().response();
    }
    @Then("user receives the response from the server")
    public void user_receives_the_response_from_the_server() {
        System.out.println("The response is " + response.prettyPrint());
    }
    @Then("user validates the status code is matching {int}")
    public void user_validates_the_status_code_is_matching(Integer expectedValue) {

         int actualStatusCode=  response.statusCode();

        Assert.assertEquals(actualStatusCode,expectedValue);


    }

    @When("user hits the getallusers endpoint for the http get method")
    public void userHitsTheGetallusersEndpointForTheHttpGetMethod() {
        response= given(SpecBuilder.myReqSpec()).
                when().
                get("/users?page=2").
                then().spec(SpecBuilder.myResponseSpec()).extract().response();

    }

    @And("check whether the {string} is matching the value {string}")
    public void checkWhetherTheIsMatchingTheValue(String fieldName, String expectedValue) {
        JsonPath jsonPath= new JsonPath(response.asString());
      String actualValue=   jsonPath.get(fieldName);

        System.out.println("The field Name's value is " + actualValue);

        Assert.assertEquals(actualValue,expectedValue);
    }

//    @When("user hits the createnewuser endpoint for the http post method")
//    public void userHitsTheCreatenewuserEndpointForTheHttpPostMethod() {
//        User user=new User();
//        user.setName("morpheus");
//        user.setJob("leader");

//     response=  given(SpecBuilder.myReqSpec()).when().
//                body(TestData.dataforCreateNewUser()).
//                post("/users").
//                then().
//                spec(SpecBuilder.myResponseSpec()).
//                extract().response();





//    }

    @When("user hits the {string} endpoint for the http {string} method")
    public void userHitsTheEndpointForTheHttpMethod(String endPoint,String httpMethod) {


        if (httpMethod.equalsIgnoreCase("get")){
            response= given(SpecBuilder.myReqSpec()).
                    when().
                    get(Endpoints.valueOf(endPoint).getEndPoint()).
                    then().spec(SpecBuilder.myResponseSpec()).
                    extract().response();
        }
        else if (httpMethod.equalsIgnoreCase("post")){
            response= requestSpecification.
                    when().post(Endpoints.valueOf(endPoint).getEndPoint()).
                    then().
                    spec(SpecBuilder.myResponseSpec()).
                    extract().response();
        }

    }

    @DataTableType
    public User entryUser(Map<String,String> userentry){

        return new User(userentry.get("name"),userentry.get("job"));
    }



    @And("user sends the payload for the post in the below format")
    public void userSendsThePayloadForThePostInTheBelowFormat(User user) {
    requestSpecification=    given(SpecBuilder.myReqSpec()).when().
                body(user);

    }
}
