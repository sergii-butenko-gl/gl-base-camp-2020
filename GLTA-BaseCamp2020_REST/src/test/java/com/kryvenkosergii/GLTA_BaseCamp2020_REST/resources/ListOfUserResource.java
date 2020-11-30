package com.kryvenkosergii.GLTA_BaseCamp2020_REST.resources;

import java.util.List;

import com.kryvenkosergii.GLTA_BaseCamp2020_REST.dto.RestHttpMethods;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.dto.RestUrlRepository;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.engine.RestQueries;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.entity.ResponseCodeEntity;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.entity.UserEntity;
import com.kryvenkosergii.GLTA_BaseCamp2020_REST.tools.GenericConverter;

public class ListOfUserResource
        extends RestQueries<UserEntity, ResponseCodeEntity, ResponseCodeEntity, ResponseCodeEntity, ResponseCodeEntity> {

    public ListOfUserResource() {
        super(RestUrlRepository.getListUsers());
        initParameters();
    }

    private void initParameters() {
        addEntityParameters(RestHttpMethods.GET, UserEntity.class);
        addEntityParameters(RestHttpMethods.POST, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.PUT, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.PATCH, ResponseCodeEntity.class);
//
        addListEntityParameters(RestHttpMethods.GET, new GenericConverter<List<UserEntity>>() {
        }.getGenericType());
        addListEntityParameters(RestHttpMethods.POST, new GenericConverter<List<ResponseCodeEntity>>() {
        }.getGenericType());
        addListEntityParameters(RestHttpMethods.PUT, new GenericConverter<List<ResponseCodeEntity>>() {
        }.getGenericType());
        addListEntityParameters(RestHttpMethods.DELETE, new GenericConverter<List<ResponseCodeEntity>>() {
        }.getGenericType());
        addListEntityParameters(RestHttpMethods.PATCH, new GenericConverter<List<ResponseCodeEntity>>() {
        }.getGenericType());
    }
}