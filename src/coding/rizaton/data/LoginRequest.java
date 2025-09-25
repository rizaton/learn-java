package coding.rizaton.data;

public record LoginRequest(String username, String password) {

    public LoginRequest {
        System.out.println("Creating object LoginRequest");
    }

    public LoginRequest(String username) {
        this(username, "");
    }

    public LoginRequest() {
        this("", "");
    }

//    public void setUsername(String username) {
//        this.username = username;
//    }
}
