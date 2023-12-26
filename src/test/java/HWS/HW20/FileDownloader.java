package HWS.HW20;

import HWS.HW20.pages.DownloadPage;
import HWS.UtilTest.BaseTest;
import HWS.Utils.FileHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileDownloader extends BaseTest {
    String fileName = "csv file.csv";

    @Test
    public void downloadCsv() throws IOException {
        DownloadPage downloadPage = new DownloadPage(driver);
        downloadPage.open();

        downloadPage.downloadFile(fileName);
        Assert.assertTrue(FileHelper.waitFileDownloaded(DOWNLOAD_FOLDER_PATH, fileName, 5));
        Assert.assertTrue(FileHelper.hasCorrectExtension(DOWNLOAD_FOLDER_PATH + "\\" + fileName, ".csv"));

        List<String> rows = Files.readAllLines(Paths.get(DOWNLOAD_FOLDER_PATH + "\\" + fileName));
        Assert.assertFalse(rows.isEmpty(), "File is empty");

        List<String> headers = FileHelper.getHeader(rows,",");
        List<String> expectedHeaders = Arrays.asList("Manufacturer Id", "Period", "Glass - Mixed", "Aluminium", "PET - Clear", "PET - Colour", "HDPE", "Liquid Paper Board", "Steel", "Other Materials");
        Assert.assertEquals(headers, expectedHeaders, "CSV headers are not as expected");

        String expectedRow1 = "QM20000003,M2022-11,10,20,30,40,5,6,7,8";
        Assert.assertTrue(rows.contains(expectedRow1));
    }
}
