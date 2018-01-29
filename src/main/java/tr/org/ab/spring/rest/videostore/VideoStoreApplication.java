package tr.org.ab.spring.rest.videostore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tr.org.ab.spring.rest.videostore.user.Role;
import tr.org.ab.spring.rest.videostore.user.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@SpringBootApplication
public class VideoStoreApplication{


	public static void main(String[] args) {
		SpringApplication.run(VideoStoreApplication.class, args);
	}
}
