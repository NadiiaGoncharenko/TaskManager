import java.util.Scanner;

public class UserView extends TaskManager {

    public void app() {
        System.out.println("Welcome to the task manager");
        Scanner sc = new Scanner(System.in);

        // menu
        while (true) {

            System.out.println();
            System.out.println("""

                    Enter option:
                    'a': add/insert Task\s
                    'b': update Task
                    'c': delete Task
                    'd': filter by due date
                    'e': view list
                    'x': exit
                    """);

            String y = sc.nextLine();
            switch (y) {
                case "a":
                    insertTask_and_setPriority();
                    break;
                case "b":
                    updateTask();
                    break;
                case "c":
                    deleteTask();
                    break;
                case "d":
                    byDueDate();
                    break;
                case "e":
                    printList();
                    break;
                case "x":
                    System.out.println("Thank you for your visit! Good bye!\n");
                    System.exit(0);
                    break;
            }
            sc.reset();
        }
    }
}
