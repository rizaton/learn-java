package rizaton.generic.application;

public class ConstraintApp {
    public static void main(String[] args) {

        NumberData<Integer> integerNumberData = new NumberData<>(1);
        NumberData<Long> longNumberData = new NumberData<>(1L);

//        NumberData<String> stringNumberData = new NumberData<String>("Hello"); // Error

    }
    public static class NumberData<T extends Number>{
        // Second extends is Interface, Parent only 1, more than one is interface

        private T data;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public NumberData(T data) {
            this.data = data;
        }
    }
}
