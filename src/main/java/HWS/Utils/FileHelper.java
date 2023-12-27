package HWS.Utils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileHelper {
    public static boolean waitFileDownloaded(String directory, String fileName, int timeoutInSec) {
        for (int i = 0; i < timeoutInSec; i++) {
            File file = new File(directory + "\\" + fileName);
            if (file.exists() & file.length() > 0) return true;

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public static boolean hasCorrectExtension(String filePath, String extension) {
        File file = new File(filePath);
        String fileName = file.getName();
        return fileName.endsWith(extension);
    }

    public static List<String> getHeader(List<String> rows, String separator) {
        return Arrays.asList(rows.get(0).split(separator));
    }
}
