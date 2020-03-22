package endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaseEndPoints {
	
    public static final int SUCCESS_STATUS_CODE = 200;

    public static final int GET_REQUEST = 0;
    public static final int POST_REQUEST = 1;
    public static final int DELETE_REQUEST = 2;
    public static final int PUT_REQUEST = 3;

    protected final String BASE_URL = "https://petstore.swagger.io/v2/";

    public void verifyTrue(boolean val) {
        Assert.assertTrue(val);
    }

    public void verifyFalse(boolean val) {
        Assert.assertFalse(val);
    }

    public String getBaseUrl() {
        return this.BASE_URL;
    }

    public void verifyResponseKeyValues(String key, String val, Response r) {
        String keyValue = r.jsonPath().getString(key);
        assertThat(keyValue, is(val));
    }

    public void verifyResponseStatusValue(Response response, int expectedCode) {
        assertThat(response.getStatusCode(), is(expectedCode));
    }

    public RequestSpecification getRequestWithJSONHeaders() {
        RequestSpecification r = RestAssured.given();
        r.header("Content-Type", "application/json");
        return r;
    }

    public RequestSpecification getRequestWithXMLHeaders() {
        RequestSpecification r = RestAssured.given();
        r.header("Content-Type", "application/xml");
        return r;
    }

    protected JSONObject createJSONPayload(Object pojo) {
        return new JSONObject(pojo);
    }

    public Response sendRequest(RequestSpecification request, int requestType, String url, Object pojo) {
        Response response = null;

        // Add the Json to the body of the request
        if (pojo != null) {
            String payload = createJSONPayload(pojo).toString();
            request.body(payload);
        }

        // need to add a switch based on request type
        switch (requestType) {
            case BaseEndPoints.GET_REQUEST:
                if (request == null) {
                    response = RestAssured.when().get(url);
                } else {
                    response = request.get(url);
                }
                break;
            case BaseEndPoints.POST_REQUEST:
                if (request == null) {
                    response = RestAssured.when().post(url);
                } else {
                    response = request.post(url);
                }
                break;
            case BaseEndPoints.DELETE_REQUEST:
                if (request == null) {
                    response = RestAssured.when().delete(url);
                } else {
                    response = request.delete(url);
                }
                break;
            case BaseEndPoints.PUT_REQUEST:
                if (request == null) {
                    response = RestAssured.when().put(url);
                } else {
                    response = request.put(url);
                }
                break;
            default:
                if (request == null) {
                    response = RestAssured.when().post(url);
                } else {
                    response = request.post(url);
                }
                response = request.post(url);
                break;
        }
        return response;
    }	

}
