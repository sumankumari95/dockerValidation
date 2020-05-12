package dockerValidation;

import java.io.IOException;
import org.testng.annotations.Test;

public class startDocker {

	@Test
	public void startFile() throws IOException, InterruptedException {
		DockerUtils.deleteFile("dockerLog.txt");
		DockerUtils.executeAndMonitorDockerCompose("cmd /c start dockerUp.bat", "Registered a node");
	}
}
