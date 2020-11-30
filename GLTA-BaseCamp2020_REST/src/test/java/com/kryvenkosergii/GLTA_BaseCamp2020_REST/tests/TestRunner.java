package com.kryvenkosergii.GLTA_BaseCamp2020_REST.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class TestRunner {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeSuite
    public void beforeSuite() {
    }

    @BeforeClass
    public void setUpBeforeClass() {
    }

    @AfterClass(alwaysRun = true)
    public void tearDownAfterClass() throws Exception {
        // TODO Logout
    }

    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        if (!result.isSuccess()) {
            logger.warn("Error Test " + result.getName());
            // TODO Logout
        }
        logger.info("Done Test " + result.getName());
        // logout, delete cookie, delete cache
    }

}