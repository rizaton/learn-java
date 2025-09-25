package rizaton.generic.application;

public class MultipleConstraintApp {
    public static void main(String[] args) {
//        Data<Manager> managerData = new Data<>(new Manager());
//        Error Manager not implements CanSayHi
        Data<VicePresident> vicePresidentData = new Data<>(new VicePresident());

    }
    public static interface CanSayHi {
        void sayHi(String name);
    }
    public static abstract class Employee{

    }
    public static class Manager extends Employee{

    }
    public static class VicePresident extends Employee implements CanSayHi {
        @Override
        public void sayHi(String name) {
            System.out.println("Hello " + name);
        }
    }
    public static class Data <T extends Employee & CanSayHi>{
        private T data;
        public Data(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
            this.data.sayHi("Hello");
        }
    }
}
