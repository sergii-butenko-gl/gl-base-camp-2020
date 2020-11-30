package com.kryvenkosergii.GLTA_BaseCamp2020_REST.services;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kryvenkosergii.GLTA_BaseCamp2020_REST.data.User;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.dto.ContentTypes;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.dto.KeyParameters;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.dto.MethodParameters;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.dto.RestParameters;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.entity.UserEntity;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.resources.UserResource;

public class UserService {
    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    //
    private WebDriver driver;
    private UserEntity userEntity;
    private UserResource userResource;
    //
    public UserService() {
        this.userResource = new UserResource();
    }
    
    
    public UserEntity successfulGetListOfUsersByPage(int page) {
        logger.debug("start successfulGetListOfUsers");
        logger.trace("preparing REST GET request for successfully getting list of users");
        MethodParameters methodParameters = new MethodParameters();
        RestParameters urlParameters = new RestParameters()
                .addParameter(KeyParameters.PAGE, String.valueOf(page));
        logger.trace("send REST GET request for successfully getting list of users");
        UserEntity userEntity = userResource.httpGetAsEntity(methodParameters.addUrlParameters(urlParameters));
        logger.trace("got REST GET response: " + userEntity);
        logger.info("successful getting list of users");
        return userEntity;
    }
    
    public UserEntity successfulPostCreateUser(User user) {
        logger.debug("start successfulPostCreateUser with parameters: user = " + user);
        logger.trace("preparing REST POST request for successfully user creation");
        MethodParameters methodParameters = new MethodParameters().addContentType(ContentTypes.APPLICATION_JSON);
        logger.trace("forming REST POST request for successfully user creation");
        RestParameters mediaTypeParameters = new RestParameters().addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.JOB, user.getJob());
        logger.trace("send REST POST request for successfully user creation");
        UserEntity userEntity = userResource.httpPostAsEntity(methodParameters.addMediaTypeParameters(mediaTypeParameters));
        logger.trace("got REST POST response: " + userEntity);
        logger.info("successful creation");
        return userEntity;
    }
    
    public UserEntity successfulPutUpdateUser(User user) {
        logger.debug("start successfulPutUpdateUser with parameters: user = " + user);
        logger.trace("preparing REST PUT request for successfully updating a user");
        MethodParameters methodParameters = new MethodParameters().addContentType(ContentTypes.APPLICATION_JSON);
        logger.trace("forming REST POST request for successfully user creation");
        RestParameters mediaTypeParameters = new RestParameters().addParameter(KeyParameters.NAME, user.getName())
                .addParameter(KeyParameters.JOB, user.getJob());
        logger.trace("send REST PUT request for successfully updating a user");
        UserEntity userEntity = userResource.httpPutAsEntity(methodParameters.addMediaTypeParameters(mediaTypeParameters));
        logger.trace("got REST PUT response: " + userEntity);
        logger.info("successful update");
        return userEntity;
    }
}
