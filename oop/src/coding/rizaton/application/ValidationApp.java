package coding.rizaton.application;

import coding.rizaton.data.LoginRequest;
import coding.rizaton.error.ValidationException;
import coding.rizaton.util.ValidationUtil;

public class ValidationApp {
    public static void main(String[] args) {

        LoginRequest loginRequest = new LoginRequest("Iza", "Secret");

        try {
            ValidationUtil.validate(loginRequest);
            System.out.println("Login successful");
        } catch (ValidationException | NullPointerException | IllegalArgumentException exception) {
            System.out.println("Data is not valid: " + exception.getMessage());
        } finally {
            System.out.println("Always successful");
        }

        LoginRequest loginRequest1 = new LoginRequest("Iza", null);
        ValidationUtil.validateRuntime(loginRequest1);
        System.out.println("Successfully validated");
    }
}
