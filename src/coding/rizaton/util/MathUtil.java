package coding.rizaton.util;

public class MathUtil {
    public static int sum(int... values){
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
}
