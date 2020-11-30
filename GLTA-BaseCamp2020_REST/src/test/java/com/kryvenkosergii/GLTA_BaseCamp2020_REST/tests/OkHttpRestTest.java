package com.kryvenkosergii.GLTA_BaseCamp2020_REST.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.kryvenkosergii.GLTA_BaseCamp2020_REST.data.User;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.data.UserRepository;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.entity.UserEntity;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.services.UserService;

import io.qameta.allure.Description;

public class OkHttpRestTest extends TestRunner {

    @DataProvider
    public Object[][] createUser() {
        return new Object[][] { { UserRepository.get().postCreateUser() }, };
    }
    
    @DataProvider
    public Object[][] updateUser() {
        return new Object[][] { { UserRepository.get().putUpdateUser() }, };
    }

    @Description("Positive test of creationa a user.")
//  @Issue("---")
//  @Story("---")
//  @Step("---")
    @Parameters({ "User credentials" })
    @Test(dataProvider = "createUser")
    public void postHttpRequestUserCreation(User userData) {
        logger.info("start test postHttpRequestUserCreation with user = " + userData.toString());
        //
        logger.info("REST POST: create user");
        UserEntity userEntity = new UserService().successfulPostCreateUser(userData);
        System.out.println(userEntity);
        Assert.assertEquals(userEntity.getName(), userData.getName(), "actual name doesn't match with expected");
    }
    
    @Description("Positive test of updating a user.")
//  @Issue("---")
//  @Story("---")
//  @Step("---")
    @Parameters({ "User credentials" })
    @Test(dataProvider = "updateUser")
    public void putHttpRequestUserUpdating(User userData) {
        logger.info("start test putHttpRequestUserUpdating with user = " + userData.toString());
        //
        logger.info("REST PUT: update user");
        UserEntity userEntity = new UserService().successfulPutUpdateUser(userData);
        System.out.println(userEntity);
        Assert.assertEquals(userEntity.getName(), userData.getName(), "actual name doesn't match with expected");
    }
    
    @Description("Positive test of getting list of users")
//  @Issue("---")
//  @Story("---")
//  @Step("---")
    @Parameters({ "" })
    //@Test()
    public void getHttpRequestListOfUsers() {
        logger.info("start test getHttpRequestListOfUsers");
        //
        logger.info("REST GET: list of users");
        UserEntity userEntity = new UserService().successfulGetListOfUsersByPage(2);
        System.out.println(userEntity);
//        Assert.assertEquals(userEntity.getName(), userData.getName(), "actual name doesn't match with expected");
    }

}
