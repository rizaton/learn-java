public class ToDoListApp {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Show to do list
     */
    public static void showTodoList(){
        System.out.println("Todo List: ");
        for (var i = 0; i < model.length; i++) {
            String todo = model[i];
            var listNumber = i + 1;

            if (todo != null){
                System.out.println(listNumber + ". " + todo);
            }
        }
    }

    public static void testShowTodoList(){
        model[0] = "Learn Basic Java";
        model[1] = "Study Case Java Basic : Todo App";
        showTodoList();
    }

    /**
     * Add to do list
     */
    public static void addTodoList(String todo){
        // Check if the model full
        var isFull = true;
        for (String s : model) {
            if (s == null) {
                // there's still empty in model
                isFull = false;
                break;
            }
        }
        // If full, model get resized two times
        if (isFull){
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // Add to a position that the array data is null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for (int i = 0; i < 25; i++) {
            addTodoList("Todo Test no." + i);
        }
        showTodoList();
    }

    /**
     * Remove to do list
     */
    public static boolean removeTodoList(Integer number){
        if ((number - 1) >= model.length) { return false; }
        else if (model[number - 1] == null) { return false; }
        else {
            for (int i = (number - 1); i < model.length; i++) {
                if(i == (model.length - 1)){
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        addTodoList("One");
        addTodoList("Two");
        addTodoList("Three");
        addTodoList("Four");
        addTodoList("Five");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        return scanner.nextLine();
    }

    public static void testInput() {
        var data = input("Name");
        System.out.println("Hi " + data + "!");

        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * View show to do list
     */
    public static void viewShowTodoList(){
        while (true) {
            showTodoList();

            System.out.println("Menu : ");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("x. Exit");

            var input = input("Enter choice");

            if (input.equals("1")){
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
              break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("One");
        addTodoList("Two");
        addTodoList("Three");
        addTodoList("Four");
        addTodoList("Five");
        viewShowTodoList();
    }

    /**
     * View add to do menu
     */
    public static void viewAddTodoList(){
        System.out.println("Add Todo List");

        var todo = input("Todo (x for cancel)");

        if (todo.equals("x")){
            // cancel
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("One");
        addTodoList("Two");
        viewAddTodoList();
        showTodoList();
    }

    /**
     * View remove to do menu
     */
    public static void viewRemoveTodoList(){
        System.out.println("Remove Todo List");

        var number = input("Number (x for cancel)");

        if (number.equals("x")){
            // cancel
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Failed to delete todo list : " + number);
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("One");
        addTodoList("Two");
        addTodoList("Three");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
