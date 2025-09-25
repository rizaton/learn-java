package coding.rizaton.application;

import coding.rizaton.data.LoginRequest;

public class RecordApp {
    public static void main(String[] args) {
        LoginRequest loginRequest = new LoginRequest("Iza", "secret");

        System.out.println(loginRequest.username());
        System.out.println(loginRequest.password());
        System.out.println(loginRequest);

        System.out.println(new LoginRequest());
        System.out.println(new LoginRequest("Iza"));
        System.out.println(new LoginRequest("Iza", "secret"));
    }
}
