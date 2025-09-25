package coding.rizaton.application;

import coding.rizaton.data.CreateUserRequest;
import coding.rizaton.util.ValidationUtil;

public class ReflectionApp {
    public static void main(String[] args) {
        CreateUserRequest request = new CreateUserRequest();
        request.setUsername("admin");
        request.setPassword("admin");
        request.setName("admin");
        request.setAge(19);

        ValidationUtil.validationReflection(request);

    }
}
