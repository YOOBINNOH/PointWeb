package project.PointWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PointWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointWebApplication.class, args);
	}

}
