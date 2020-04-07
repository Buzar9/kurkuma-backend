package pl.zhr.scouting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.zhr.scouting.properties.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class ScoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScoutingApplication.class, args);
	}

}

