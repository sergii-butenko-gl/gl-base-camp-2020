package com.kryvenkosergii.GLTA_BaseCamp2020_REST.data;

/**
 * DataRepository class which holds different sets of data.
 * @author SergiiK
 */
public final class UserRepository {
    private static volatile UserRepository instance = null;

    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }
    
    public User getDefault() {
        return getSingleUser();
    }

    public User getSingleUser() {
        return new User(2);
    }
    
    public User postCreateUser() {
        return new User("morpheus", "leader");
    }

    public User putUpdateUser() {
        return new User("morpheus", "zion resident");
    }
    
    public User deleteleUser() {
        return new User(2);
    }
}