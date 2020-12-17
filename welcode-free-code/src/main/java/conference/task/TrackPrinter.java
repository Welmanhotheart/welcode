package conference.task;


import conference.Session;
import conference.Track;

import java.io.*;
import java.util.List;

/**
 * Track Printer
 * Function：print the analyzed tracks into  file "track_output_file.txt"
 */
public class TrackPrinter {
    private String filePath;

    public TrackPrinter(String filePath) {
        this.filePath = filePath;
    }


    /**
     * 打印track
     * @param tracks
     * @throws IOException
     */
    public void print(List<Track> tracks) throws IOException {
        if (tracks == null) {
            return;
        }

        if (filePath == null) {
            return;
        }

        try {
            OutputStream os = new FileOutputStream(filePath);
            try {
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
                try {
                    for(int i = 0, len = tracks.size(); i < len; i++) {
                        Track track = tracks.get(i);
                        printSingleTrack(i + 1,track, writer);
                        writer.newLine();
                        writer.newLine();
                    }
                } finally {
                    writer.close();
                }
            } finally {
                os.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //print single track
    private void printSingleTrack(int index, Track track, BufferedWriter writer) throws IOException {
        writer.write(new StringBuilder("Track ").append(index).append(":").toString());
        writer.newLine();
        printSession(track.getMorningSession(), writer);
        printLunchEvent(writer);
        writer.newLine();
        printSession(track.getAfternoonSession(), writer);
        printNetworkingEvent(writer);
    }

    private void printLunchEvent(BufferedWriter writer) throws IOException {
        writer.write("12:00PM Lunch");
    }

    private void printNetworkingEvent(BufferedWriter writer) throws IOException {
        writer.write("05:00PM Networking Event");
    }

    private void printSession(Session session, BufferedWriter writer) throws IOException {
        String signature = session.getSignature();
        final int hourStart = session.getHourStart();
        int hour = hourStart;
        List<Task> tasks = session.getTasks();
        int duration = 0;
        int minute = 0;
        for (Task task : tasks) {
            //print hour
            if(hour < 10){
                writer.write('0');
            }
            writer.write(hour + "");

            writer.write(":");

            //print minute
            if (minute == 0) {
                writer.write("00");
            } else {
                if (minute < 10) {
                    writer.write('0');
                }
                writer.write(minute + "");
            }

            //print signature
            writer.write(signature);

            writer.write(" ");

            //print the name of a task
            writer.write(task.getName());

            writer.write(" ");

            //print the duration of a task
            int taskDuration = task.getDuration();
            if (taskDuration != 0) {
                writer.write(taskDuration + "");
                writer.write("min");
            }

            writer.newLine();

            duration += taskDuration;
            int hourIncre = duration / 60;

            hour = hourStart + hourIncre;
            minute = duration % 60;

        }
    }
}
