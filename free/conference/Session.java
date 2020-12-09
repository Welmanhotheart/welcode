package conference;

import conference.task.Task;

import java.util.List;
import java.util.Stack;


/**
 * Session bean, containing a set of tasks
 */
public class Session {

    /**
     * decide whether it's morning or afternoon session
     */

    private final String signature;

    /**
     * the total time capacity
     */
    private final int  timeCapacity;

    private final int hourStart;

    private int usedTime;

    private Stack<Task> tasks = new Stack<Task>();

    private Session(String signature, int timeCapacity, int hourStart) {
        this.signature = signature;
        this.timeCapacity = timeCapacity;
        this.hourStart = hourStart;
    }

    public String getSignature() {
        return signature;
    }


    public int getTimeCapacity() {
        return timeCapacity;
    }

    public int getHourStart() {
        return hourStart;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Stack<Task> tasks) {
        this.tasks = tasks;
    }

    public static Session createMorningSession() {
        return new Session("AM",180, 9);
    }

    public static Session createAfternoonSession() {
        return new Session("PM",240, 1);
    }

    public void addTask(Task task) {
        tasks.add(task);
        usedTime += task.getDuration();

    }

    public boolean allowAdd(Task task) {
        return timeCapacity >= task.getDuration() + usedTime;
    }

    public boolean isFull() {
        return timeCapacity == usedTime;
    }

    public Task removeLast() {
        Task last = tasks.pop();
        usedTime -= last.getDuration();
        return last;
    }
}
