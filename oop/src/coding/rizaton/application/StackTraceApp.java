package coding.rizaton.application;

public class StackTraceApp {
    public static void main(String[] args) {
        try {
            sampleError();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
    public static void sampleError(){
        try {
            String[] names = {
                    "Iza", "Tony"
            };
            System.out.println(names[100]);
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
}
