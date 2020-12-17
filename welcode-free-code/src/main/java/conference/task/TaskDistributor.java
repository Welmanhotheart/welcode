package conference.task;


import conference.Session;
import conference.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * task distributor
 * function: distribute the tasks into one or many tracks
 */
public class TaskDistributor {

    /**
     * tasks waiting to be distributed
     */
    private List<Task> waitedTasks;

    private List<Track> tracks;

    private boolean[] distributed;

    public TaskDistributor(List<Task> tasks) {
        this.waitedTasks = tasks;
        distributed = new boolean[this.waitedTasks.size()];
        for(int i = 0, len = distributed.length; i < len; i++) {
            distributed[i] = false;
        }
        tracks = new ArrayList<Track>();
    }

    public List<Track> doDistribute() {
        int index = 0;
        Track track = new Track();
        tracks.add(track);
        track.addTomorningSession(waitedTasks.get(index));
        distributed[index] = true;
        doDistribute(index, track);
        checkUndistributed();
        return tracks;
    }

    /**
     * check the left task,and add them to the afternoonsession of the last track if allowed
     */
    private void checkUndistributed() {
        Track track = tracks.get(tracks.size() - 1);
        for(int i = 0, len = distributed.length; i < len; i++) {
            if (!distributed[i]) {
                Task task = waitedTasks.get(i);
                if (track.morningSessionAllowed(task)) {
                    track.addTomorningSession(task);
                } else if(track.afternoonSessionAllowed(task)){
                    track.addToafternoonSession(task);
                }
            }
        }

    }

    private void doDistribute(int index, Track track) {
        if (allDistributed()) {
            return;
        }
        boolean flag = track.morningSessionFull();
        // if the time of morning session is not fully used
        if (!flag) {
            for(int i = index, len = waitedTasks.size(); i < len; i++) {
                if (i != index && !distributed[i]) {
                    Task task = waitedTasks.get(i);
                    if (track.morningSessionAllowed(task)) {
                        track.addTomorningSession(task);
                        distributed[i] = true;
                        doDistribute(i, track);
                    } else {
                        flag = track.morningSessionFull();
                        if (!flag) {
                            Task tTask = track.removeLastFromMorningSession();
                            int tindex = tTask.getIndex();
                            distributed[tindex] = false;
                            doDistribute(tindex, track);
                        }
                    }
                }
            }
        } else {
            flag = track.afternoonSessionFull();
            if (!flag) {
                for(int i = index, len = waitedTasks.size(); i < len; i++) {
                    if (i != index && !distributed[i]) {
                        Task task = waitedTasks.get(i);
                        if (track.afternoonSessionAllowed(task)) {
                            track.addToafternoonSession(task);
                            distributed[i] = true;
                            doDistribute(i, track);
                        } else {
                            flag = track.afternoonSessionFull();
                            if (!flag) {
                                Task tTask = track.removeLastFromAfternoonSession();
                                int tindex = tTask.getIndex();
                                distributed[tindex] = false;
                                doDistribute(tindex, track);
                            }
                        }
                    }
                }
            } else {
                //if both morning and afternoon session are full
                Track track1 = new Track();
                tracks.add(track1);
                doDistribute(0, track1);
            }
        }
    }

    private boolean allDistributed() {
        for(int i = 0, len = distributed.length; i < len; i++) {
            boolean b = distributed[i];
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
