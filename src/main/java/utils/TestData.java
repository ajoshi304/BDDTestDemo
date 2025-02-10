package utils;

import pojos.User;

public class TestData {

    public static User dataforCreateNewUser(){
        User user=new User();
        user.setName("morpheus");
        user.setJob("leader");

        return user;
    }
}
