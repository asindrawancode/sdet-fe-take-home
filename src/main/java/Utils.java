import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.*;

public class Utils {
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("screenshot/" + screenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
