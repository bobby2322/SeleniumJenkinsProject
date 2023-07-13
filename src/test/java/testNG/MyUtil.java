package testNG;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MyUtil extends TestBase {

	public static String ssPath;

	public static void captureScreenShot(String str) {

		Calendar cal = Calendar.getInstance();
		int y = cal.get(Calendar.YEAR);
		int mo = cal.get(Calendar.MONTH);
		int d = cal.get(Calendar.DATE);
		int h = cal.get(Calendar.HOUR);
		int mi = cal.get(Calendar.MINUTE);
		int s = cal.get(Calendar.SECOND);

		File scFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			ssPath = System.getProperty("user.dir") + "\\Screenshot\\" + str + "_" + y + "_" + (mo + 1) + "_" + d + "_"
					+ h + "_" + mi + "_" + s + ".jpg";
			FileUtils.copyFile(scFile, new File(ssPath));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void zip(String filepath) {
		try {
			File inFolder = new File(filepath);
			File outFolder = new File("Reports.zip");
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
			BufferedInputStream in = null;
			byte[] data = new byte[1000];
			String files[] = inFolder.list();
			for (int i = 0; i < files.length; i++) {
				in = new BufferedInputStream(new FileInputStream(inFolder.getPath() + "/" + files[i]), 1000);
				out.putNextEntry(new ZipEntry(files[i]));
				int count;
				while ((count = in.read(data, 0, 1000)) != -1) {
					out.write(data, 0, count);
				}
				out.closeEntry();
			}
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
