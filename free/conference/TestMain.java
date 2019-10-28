package conference;

import conference.task.Task;
import conference.task.TaskDistributor;
import conference.task.TaskExtractor;
import conference.task.TrackPrinter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class TestMain {

    /**
     * the name of the file for input
     */
    public final static String INPUT_FILE_NAME = "task_input_file.txt";


    /**
     * the name of the file for output
     */
    public final static String OUTPUT_FILE_NAME = "track_output_file.txt";

    public static void main(String[] args) throws Exception {
        URL resource = TestMain.class.getClassLoader().getResource("conference");
        String fileDirePath = resource.getPath();
        String separator = File.separator;
        TaskExtractor extractor = new TaskExtractor(fileDirePath + separator + INPUT_FILE_NAME);

        List<Task> tasks = extractor.extract();


        TaskDistributor taskDistributor = new TaskDistributor(tasks);

        List<Track> tracks = taskDistributor.doDistribute();

        TrackPrinter printer = new TrackPrinter(fileDirePath + separator + OUTPUT_FILE_NAME);

        printer.print(tracks);

    }

}
