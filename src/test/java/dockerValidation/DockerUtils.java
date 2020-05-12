package dockerValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;

public class DockerUtils {
	public static void executeAndMonitorDockerCompose(String dockerCommand, String SearchLog) throws IOException, InterruptedException {
		boolean flag = false;
		Runtime  runtime = Runtime.getRuntime();
		runtime.exec(dockerCommand);

		String logFile = "dockerLog.txt";
		
		File file= new File(logFile);
		while(!file.exists())
		{
		    Thread.sleep(2000);
		}

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 60);
		long stopnow = cal.getTimeInMillis();

		while(System.currentTimeMillis() < stopnow) {
			if(flag) {
				break;
			}

			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currentLine = reader.readLine();

			while(currentLine!=null && !flag) {
				if(currentLine.contains(SearchLog)) {
					System.out.println("Found my text...");
					flag=true;
					break;
				}

				currentLine = reader.readLine();
			}
			reader.close();
		}

		Assert.assertTrue(flag);
	}
	
	public static void deleteFile(String fileName) {
		File fi = new File(fileName);
		if(fi.delete()) {
			System.out.println("File deleted successfully!");
		}
	}
}
