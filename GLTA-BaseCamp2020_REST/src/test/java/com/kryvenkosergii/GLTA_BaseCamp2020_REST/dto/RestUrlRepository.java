package com.kryvenkosergii.GLTA_BaseCamp2020_REST.dto;

public final class RestUrlRepository {
	// TODO Send as Parameter
    private static String remoteServer = "https://reqres.in";

    private RestUrlRepository() {
    }

    public static RestUrl getDefault() {
    	return getUser();
    }
    
    public static RestUrl getListUsers() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/api/users")
                .addPostUrl("")
                .addPutUrl("")
                .addDeleteUrl("")
                .addPatchUrl("");
    }

    public static RestUrl getUser() {
        return new RestUrl()
                .addBaseUrl(remoteServer)
                .addGetUrl("/api/users")
                .addPostUrl("/api/users")
                .addPutUrl("/api/users")
                .addDeleteUrl("/api/users")
                .addPatchUrl("/api/users");
    }
}
