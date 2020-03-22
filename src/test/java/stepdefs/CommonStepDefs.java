package stepdefs;

import endpoints.BaseEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Story;

public class CommonStepDefs {
	
	
    private World world;
    private BaseEndPoints be = new BaseEndPoints();

    @Story("the Swagger PetStore API is available")
    @Given("the Swagger PetStore API is available")
    public void theSwaggerPetStoreAPIIsAvailable() {
        String url = be.getBaseUrl() + "swagger.json";
        be.sendRequest(null, BaseEndPoints.GET_REQUEST, url, null).then().statusCode(200);
    }

    @Then("^the requests response will contain the value '(.*?)' for the '(.*?)' field$")
    public void i_will_be_able_to_run_connected_step_definitions(String val, String key) {
        be.verifyResponseKeyValues(key, val, world.getResponse());
    }	

}
