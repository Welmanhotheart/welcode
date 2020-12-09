package conference;

import conference.task.Task;

/**
 * Track bean, containing morning session and a afternoon session
 */
public class Track {

    /**
     * session for task to be hold in the morning
     */
    private Session morningSession = Session.createMorningSession();


    /**
     * session for task to be hold in the  afternoon
     */
    private Session afternoonSession = Session.createAfternoonSession();


    public Session getMorningSession() {
        return morningSession;
    }

    public void setMorningSession(Session morningSession) {
        this.morningSession = morningSession;
    }

    public Session getAfternoonSession() {
        return afternoonSession;
    }

    public void setAfternoonSession(Session afternoonSession) {
        this.afternoonSession = afternoonSession;
    }

    public void addTomorningSession(Task task) {
        morningSession.addTask(task);
    }

    public boolean morningSessionAllowed(Task task) {
       return morningSession.allowAdd(task);
    }

    public boolean morningSessionFull() {
        return morningSession.isFull();
    }

    public boolean afternoonSessionAllowed(Task task) {
        return afternoonSession.allowAdd(task);
    }

    public void addToafternoonSession(Task task) {
        afternoonSession.addTask(task);
    }

    public boolean afternoonSessionFull() {
        return afternoonSession.isFull();
    }

    public Task removeLastFromMorningSession() {
        return morningSession.removeLast();
    }

    public Task removeLastFromAfternoonSession() {
        return afternoonSession.removeLast();
    }
}
