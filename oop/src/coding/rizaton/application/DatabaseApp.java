package coding.rizaton.application;

import coding.rizaton.error.DatabaseError;

public class DatabaseApp {
    public static void main(String[] args) {
        connectDatabase("Iza", "Secret");
        System.out.println("Successfully connected;");
    }
    public static void connectDatabase(String username, String password) {
        if (username == null || password == null) {
            throw new DatabaseError("Can't connect to Database");
        }
    }
}
