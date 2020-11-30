package com.kryvenkosergii.GLTA_BaseCamp2020_REST.resources;

import java.util.List;

import com.kryvenkosergii.GLTA_BaseCamp2020_REST.dto.RestHttpMethods;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.dto.RestUrlRepository;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.engine.RestQueries;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.entity.UserEntity;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.tools.GenericConverter;


/**
 * UserDtoResource class for getting User dto by principal (email) from access token. Includes only a GET method.
 */
public class UserResource
        extends RestQueries<UserEntity, UserEntity, UserEntity, UserEntity, UserEntity> {

    public UserResource() {
        super(RestUrlRepository.getUser());
        initParameters();
    }

    private void initParameters() {
        addEntityParameters(RestHttpMethods.GET, UserEntity.class);
        addEntityParameters(RestHttpMethods.POST, UserEntity.class);
        addEntityParameters(RestHttpMethods.PUT, UserEntity.class);
        addEntityParameters(RestHttpMethods.DELETE, UserEntity.class);
        addEntityParameters(RestHttpMethods.PATCH, UserEntity.class);
//
        addListEntityParameters(RestHttpMethods.GET, new GenericConverter<List<UserEntity>>() {
        }.getGenericType());
        addListEntityParameters(RestHttpMethods.POST, new GenericConverter<List<UserEntity>>() {
        }.getGenericType());
        addListEntityParameters(RestHttpMethods.PUT, new GenericConverter<List<UserEntity>>() {
        }.getGenericType());
        addListEntityParameters(RestHttpMethods.DELETE, new GenericConverter<List<UserEntity>>() {
        }.getGenericType());
        addListEntityParameters(RestHttpMethods.PATCH, new GenericConverter<List<UserEntity>>() {
        }.getGenericType());
    }
}
