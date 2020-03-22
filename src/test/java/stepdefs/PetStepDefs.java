package stepdefs;

import endpoints.PetEndPoint;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;

public class PetStepDefs {
	
    private World world = new World();
    private PetEndPoint petEndpoint = new PetEndPoint();

    @When("I add a Pet to the system")
    public void i_add_a_Pet_to_the_system() {
        petEndpoint.addPet(world);
    }

    @Then("the pet request response has a {int} response code")
    public void the_pet_request_response_has_a_response_code(int code) {
        petEndpoint.verifyResponseStatusValue(world.getResponse(), code);
    }
    
    @When("I update a pet")
    public void iUpdateAPet() {
        petEndpoint.updatePet(world.getRequest());
    }    

    @Given("a pet exists")
    public void aPetExists() {
        petEndpoint.addPet(world);
        petEndpoint.getPetById(world.getRequest());
    }

    @When("I delete a pet")
    public void iDeleteAPet() {
        petEndpoint.deletePet(world.getRequest());
    }

    @And("getting same pet request response has a {int} response code")
    public void gettingSamePetRequestResponseHasAResponseCode(int arg0) {
        petEndpoint.getPetById(world.getRequest());
    }

    @Attachment()
    private byte[] createAttachment(String att) {
        String content = att;
        return content.getBytes();
    }
	

}
