package dockerValidation;

import java.io.IOException;
import org.testng.annotations.Test;

public class stopDocker {

	@Test
	public void stopFile() throws IOException, InterruptedException {
		DockerUtils.executeAndMonitorDockerCompose("cmd /c start dockerDown.bat", "stopped: selenium-hub");
	}
}
