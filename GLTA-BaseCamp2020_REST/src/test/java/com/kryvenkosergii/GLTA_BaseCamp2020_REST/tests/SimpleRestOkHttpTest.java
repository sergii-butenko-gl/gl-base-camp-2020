package com.kryvenkosergii.GLTA_BaseCamp2020_REST.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SimpleRestOkHttpTest extends TestRunner {

    @Test
    public void simpleGetRequest() throws Exception {
        String baseURL = "https://reqres.in";
        String pathURI = "/api/users";
        String uriParameters = "?page=2";
        //
        logger.debug("start simpleRestTest() using OkHttp");
        logger.trace("create a simple OkHttp request and take response");
        logger.info(this.getClass().getSimpleName() + " create a simple OkHttp request and take response");
        OkHttpClient client = new OkHttpClient();
        Request request;
        Response response;
        //
        // Reset Application
        request = new Request.Builder().url(baseURL + pathURI + uriParameters).get().build();
        response = client.newCall(request).execute();
        //

        // print response in CLI
        String responseBody = response.body().string();
        System.out.println("GET: responseBody = " + responseBody);

        // status code validation
        int statusCode = response.code();
        System.out.println("GET: statusCode = " + statusCode);
        Assert.assertEquals(statusCode, 200);

        // status line verification
        String getHTTPProtocol = response.protocol().toString().toUpperCase();
        String getMessage = response.message();
        String statusLine = getHTTPProtocol + " " + statusCode + " " + getMessage;
        System.out.println("GET: statusLine = " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }

    @Test
    public void simplePostRequest() throws Exception {
        logger.debug("start simplePostRequest()");
        logger.trace("create a simple POST request and take response");
        logger.info(this.getClass().getSimpleName() + ": create a simple POST request and take response");
        //
        String baseURL = "https://reqres.in";
        String pathURI = "/api/users";
        String uriParameters = "";
        //
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody;
        Request request;
        Response response;
        //
        Gson gson = new Gson();
        SimpleEntity simpleEntity;
        //
        // create body
        formBody = new FormBody.Builder().add("name", "morpheus2").add("job", "slave").build();
        // Reset Application
        request = new Request.Builder().url(baseURL + pathURI + uriParameters).post(formBody).build();
        response = client.newCall(request).execute();
        //

        // print response in CLI
        String responseBody = response.body().string();
        System.out.println("POST: responseBody = " + responseBody);

        // status code validation
        int statusCode = response.code();
        System.out.println("POST: statusCode = " + statusCode);
        Assert.assertEquals(statusCode, 201);

        // success text validation
        simpleEntity = gson.fromJson(responseBody, SimpleEntity.class);
        System.out.println("POST: simpleEntity = " + simpleEntity);
        Assert.assertEquals(simpleEntity.getName(), "morpheus2");
    }

    @Test
    public void simplePatchRequest() throws Exception {
        logger.debug("start simplePatchRequest()");
        logger.trace("create a simple PATCH request and take response");
        logger.info(this.getClass().getSimpleName() + ": create a simple PATCH request and take response");
        //
        String baseURL = "https://reqres.in";
        String pathURI = "/api/users/2";
        String uriParameters = "";
        //
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody;
        Request request;
        Response response;
        //
        Gson gson = new Gson();
        SimpleEntity simpleEntity;
        //
        // create body
        formBody = new FormBody.Builder().add("name", "morpheus2").add("job", "master").build();
        // Reset Application
        request = new Request.Builder().url(baseURL + pathURI + uriParameters).patch(formBody).build();
        response = client.newCall(request).execute();
        //
        // print response in CLI
        String responseBody = response.body().string();
        System.out.println("PATCH: responseBody = " + responseBody);

        // status code validation
        int statusCode = response.code();
        System.out.println("PATCH: statusCode = " + statusCode);
        Assert.assertEquals(statusCode, 200);

        // success text validation
        simpleEntity = gson.fromJson(responseBody, SimpleEntity.class);
        System.out.println("PATCH: simpleEntity = " + simpleEntity);
        Assert.assertEquals(simpleEntity.getJob(), "master");
    }
}

class SimpleEntity {

    private int id;
    private String name;
    private String job;
    private String createdAt;
    //
    private String updatedAt;

    public SimpleEntity(int id, String name, String job, String createdAt) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.createdAt = createdAt;
        this.updatedAt = "";
    }

    public SimpleEntity(String name, String job, String updatedAt) {
        this.name = name;
        this.job = job;
        this.updatedAt = updatedAt;
        this.id = 0;
        this.createdAt = "";
    }

    @Override
    public String toString() {
        return "SimpleEntity [id=" + id + ", name=" + name + ", job=" + job + "]";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

}
