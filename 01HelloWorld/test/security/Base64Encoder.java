package security;

import org.junit.jupiter.api.Test;

import java.util.Base64;

public class Base64Encoder {
    @Test
    void encodePasswords(){
        Base64.Encoder encoder = Base64.getEncoder();
        String userPass = "user:user";
        System.out.println(encoder.encodeToString(userPass.getBytes()));
        String adminPass = "super:super";
        System.out.println(encoder.encodeToString(adminPass.getBytes()));
    }

}
