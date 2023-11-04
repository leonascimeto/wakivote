package tech.leondev.wakivote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class WakivoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WakivoteApplication.class, args);
	}

}
