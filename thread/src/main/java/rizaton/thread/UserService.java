package rizaton.thread;

public class UserService {

    final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    // final String user;

    public void setUser(String user){
        threadLocal.set(user);
        // this.user = user;
    }

    public void doAction(){
        String user = threadLocal.get();
        // String user = this.user;
        System.out.println(user + " do action");
    }
}
