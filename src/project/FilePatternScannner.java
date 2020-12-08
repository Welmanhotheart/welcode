package project;

import net.mindview.util.Directory;

import java.io.File;

/**
 * 文件名符合特定pattern的文件扫描器
 *
 */
public class FilePatternScannner {

    private String directory;
    private String pattern;

    public FilePatternScannner(String directory, String pattern) {
        this.directory = directory;
        this.pattern = pattern;
    }
    public File[] getMatchedFiles() {
        return Directory.local(directory, pattern);

    }
}
