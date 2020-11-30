package com.kryvenkosergii.GLTA_BaseCamp2020_REST.tests;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleRestRestassuredTest extends TestRunner {

    @Test
    public void simpleGetRequest() {
        logger.debug("start simpleGetRequest()");
        logger.trace("create a simple GET request and take response");
        logger.info(this.getClass().getSimpleName() + ": create a simple GET request and take response");
        //
        RestAssured.baseURI = "https://reqres.in";
        String uriPath = "/api/users";
        String uriParameters = "?page=2";

        // Request object
        RequestSpecification requestSpec = RestAssured.given();

        // Response object
        Response response = requestSpec.request(Method.GET, uriPath + uriParameters);

        // print response in CLI
        String responseBody = response.getBody().asString();
        System.out.println("GET: responseBody = " + responseBody);

        // status code validation
        int statusCode = response.getStatusCode();
        System.out.println("GET: statusCode = " + statusCode);
        Assert.assertEquals(statusCode, 200);

        // status line verification
        String statusLine = response.getStatusLine();
        System.out.println("GET: statusLine = " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }

    @SuppressWarnings("unchecked")
    @Test
    public void simplePostRequest() {
        logger.debug("start simplePostRequest()");
        logger.trace("create a simple POST request and take response");
        logger.info(this.getClass().getSimpleName() + ": create a simple POST request and take response");
        //
        RestAssured.baseURI = "https://reqres.in";
        String uriPath = "/api/users";
        String uriParameters = "";

        // Request object
        RequestSpecification requestSpec = RestAssured.given();

        // prepare body
        JSONObject requestPaarams = new JSONObject();
        requestPaarams.put("name", "morpheus");
        requestPaarams.put("job", "leader");

        requestSpec.contentType(ContentType.JSON);// .accept(ContentType.JSON);
        requestSpec.body(requestPaarams.toJSONString()); // attache data to the request

        // Response object
        Response response = requestSpec.request(Method.POST, uriPath + uriParameters);

        // print response in CLI
        String responseBody = response.getBody().asString();
        System.out.println("POST: responseBody = " + responseBody);

        // status code validation
        int statusCode = response.getStatusCode();
        System.out.println("POST: statusCode = " + statusCode);
        Assert.assertEquals(statusCode, 201);

        // success text validation
        String successName = response.jsonPath().get("name");
        String successID = response.jsonPath().get("id");
        String successCreationData = response.jsonPath().get("createdAt");
        System.out.println("POST: successName = " + successName + "; successID = " + successID + "; successCreationData = "
                + successCreationData);
        Assert.assertEquals(successName, requestPaarams.get("name"));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void simplePatchRequest() {
        logger.debug("start simplePatchRequest()");
        logger.trace("create a simple PATCH request and take response");
        logger.info(this.getClass().getSimpleName() + ": create a simple PATCH request and take response");
        //
        RestAssured.baseURI = "https://reqres.in";
        String uriPath = "/api/users/2";
        String uriParameters = "";

        // Request object
        RequestSpecification requestSpec = RestAssured.given();

        // prepare body
        JSONObject requestPaarams = new JSONObject();
        requestPaarams.put("name", "morpheus");
        requestPaarams.put("job", "zion resident");

        requestSpec.contentType(ContentType.JSON);// .accept(ContentType.JSON);
        requestSpec.body(requestPaarams.toJSONString()); // attache data to the request

        // Response object
        Response response = requestSpec.request(Method.PATCH, uriPath + uriParameters);

        // print response in CLI
        String responseBody = response.getBody().asString();
        System.out.println("PATCH: responseBody = " + responseBody);

        // status code validation
        int statusCode = response.getStatusCode();
        System.out.println("PATCH: statusCode = " + statusCode);
        Assert.assertEquals(statusCode, 200);

        // success text validation
        String successName = response.jsonPath().get("name");
        String successJob = response.jsonPath().get("job");
        String successUpdateData = response.jsonPath().get("updatedAt");
        System.out.println("PATCH: successName = " + successName + "; successJob = " + successJob + "; successUpdateData = "
                + successUpdateData);
        Assert.assertEquals(successJob, requestPaarams.get("job"));
    }

    @Test
    public void simpleDeleteRequest() {
        logger.debug("start simpleDeleteRequest()");
        logger.trace("create a simple DELETE request and take response");
        logger.info(this.getClass().getSimpleName() + ": create a simple DELETE request and take response");
        //
        RestAssured.baseURI = "https://reqres.in";
        String uriPath = "/api/users/2";
        String uriParameters = "";

        // Request object
        RequestSpecification requestSpec = RestAssured.given();

        // Response object
        Response response = requestSpec.request(Method.DELETE, uriPath + uriParameters);

        // status code validation
        int statusCode = response.getStatusCode();
        System.out.println("DELETE: statusCode = " + statusCode);
        Assert.assertEquals(statusCode, 204);
    }
}
