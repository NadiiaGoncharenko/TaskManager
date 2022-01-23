import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class TaskManager implements ITaskManager {

   private Task[] taskBase = new Task[1];

    @Override
    public  void insertTask_and_setPriority() {
        Task[] nDb = new Task[taskBase.length + 1];

        Task task = readInput();
        if (taskBase[0] == null) {
            taskBase[0] = task;
            return;
        }
        System.arraycopy(taskBase, 0, nDb, 0, taskBase.length);
        nDb[taskBase.length] = task;
        taskBase = nDb;
    }

    @Override
    public  void byDueDate() {
        System.out.println("Filtered by Due Date (now)");
        int i = 0;
        long currentTime = System.currentTimeMillis();
        for(Task t : taskBase){
            if(t.getDate().getTime()<currentTime)
                System.out.println(i++ + " -" + t.toString());
        }
    }
    @Override
    public  void updateTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter index of task: " +
                "\n(back to menu: 'x')");
        printList();
        String q = sc.nextLine();
        if( q.equals("x")) {
            return ;
        }
        int d;
        if (!q.matches("\\d+")) {
            System.out.println("Invalid input. Only decimal numbers.");
            return ;
        }
        d = Integer.parseInt(q);
        if(d > cntDB(taskBase)){
            System.out.println("Invalid input.");
            return ;
        }
        taskBase = update(taskBase, d);
    }

    @Override
    public  void deleteTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("'d': setting delete \n");
        printList();

        for (int i = 0; i < taskBase.length; i++) {
            if (taskBase[i] == null) {
                return;
            }
        }
        System.out.println("Enter index of task: " +
                "\n(back to menu: 'x')");
        String q = sc.nextLine();
        if( q.equals("x")) {
            return;
        }

        int d;
        if (!q.matches("\\d+")) {
            System.out.println("Invalid input. Only decimal numbers.");
            return;
        }
        d = Integer.parseInt(q);
        if(d > cntDB(taskBase)){
            System.out.println("Invalid input.");
            return;
        }
        taskBase = deleteTask(taskBase, d);//reference for deleted Publication are not deleted, as books may have references even if original book is not in this particular library
    }

    @Override
    public  void printList() {
        int i = 0;
        for(Task t : taskBase){
            if(t==null) {
                System.out.println("not found");
            }
            System.out.println(i++ + " -" + t.toString());
        }
    }


    private static Task[] update(Task[] taskBase, int idx) {

        Task[] newPapers = new Task[taskBase.length];
        for (int i = 0, j = 0; j < newPapers.length; i++) {
            if (i == idx)
                taskBase[i]=readInput();
            newPapers[j] = taskBase[i];
            j++;
        }
        for (Task task : taskBase = newPapers) {
        }
        if (taskBase.length == 0) {
            Task[] newP = new Task[1];
            return newP;
        }
        return newPapers;
    }

    private static Task readInput() {
        System.out.println("Please enter the Task name");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        while ((name == null || name.isEmpty())) {
            System.out.println("Invalid input ... ");
        }
        System.out.println("Is this a priority task? than enter 'p'. If not - any other letter");
        String prio = input.next();
        boolean priority;
        priority = prio.equals("p");

        System.out.println("Enter number of days till dueDate (count from now). No other symbols are allowed. Thank you");
        String d = input.next();

        while (!d.matches("\\d+")) {
            System.out.println("Invalid input.");
            d = input.next();
        }
        // int days = input.nextInt();
        int days = Integer.valueOf(d);
        return new Task(name, priority, days);
    }

    public Task[] deleteTask(Task[] list, int idx) {

        Task[] newPapers = new Task[list.length - 1];
        System.out.printf("\n%s ist deleted", list[idx].getName());
        for (int i = 0, j = 0; j < newPapers.length; i++) {
            if (i == idx)
                continue;
            newPapers[j] = taskBase[i];
            j++;
        }
        for (Task paper : taskBase = newPapers) {
        }
        if (list.length == 0) {
            Task[] newP = new Task[1];
            return newP;
        }
        return newPapers;
    }

    public static int cntDB(Task[] list) {
        int counter = list.length - 1;
        return counter;
    }

}


