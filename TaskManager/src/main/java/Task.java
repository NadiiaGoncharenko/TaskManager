import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Task {
    private Date date;
    private String name;
    private boolean priority;

    public Task(String name, boolean priority,int days) {
       this.date = new Date();
       new Date(System.currentTimeMillis());
        //LocalDate date = LocalDate.now().plusDays(dayPlus);
        this.name = name;
        this.priority = priority;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        date = cal.getTime();
    }

    public Task(Task task) {
        Task t = new Task(task);
    }

    public boolean isPriority() {
        return priority;
    }

    public String getPriority() {
        if (priority == true) {
            return "prioritised";
        } else {
            return "not prioritised";
        }
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public Date getDate(Task this) {
        return this.date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "Task name = '" + name + '\'' +
                ", priority status = "
                + getPriority() +
                ", DueDate = " + date +
                '}';
    }
}

























