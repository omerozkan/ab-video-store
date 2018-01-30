package tr.org.ab.spring.rest.videostore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class VideoStoreApplication{


	public static void main(String[] args) {
		SpringApplication.run(VideoStoreApplication.class, args);
	}
}
