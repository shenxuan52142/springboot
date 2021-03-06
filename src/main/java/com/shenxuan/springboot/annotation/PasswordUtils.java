package com.shenxuan.springboot.annotation;

import java.util.List;

public class PasswordUtils {
    @UseCase(id=47,description = "Password must contain at least one numeric")
    public static boolean vailidatePassword(String password){
        return (password.matches("\\w*\\d\\w*"));
    }
    @UseCase(id=48)
    public String encryptPassword(String password){
        return new StringBuffer(password).reverse().toString();
    }
    @UseCase(id=49,description = "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords,String password){
        return !prevPasswords.contains(password);
    }

//    public static void main(String[] args) {
//        vailidatePassword("sssss");
//    }
}
