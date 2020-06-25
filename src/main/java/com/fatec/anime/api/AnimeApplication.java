package com.fatec.anime.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class AnimeApplication {

	public static void main(String[] args) {

		SpringApplication.run(AnimeApplication.class, args);

		String welcomeMessage =
				"  ,---.   ,--.  ,--. ,--. ,--.   ,--. ,------. ,------.   ,---.   ,--------. ,------.  ,-----. \r\n" +
						" /  O  \\  |  ,'.|  | |  | |   `.'   | |  .---' |  .---'  /  O  \\  '--.  .--' |  .---' '  .--./ \r\n" +
						"|  .-.  | |  |' '  | |  | |  |'.'|  | |  `--,  |  `--,  |  .-.  |    |  |    |  `--,  |  |     \r\n" +
						"|  | |  | |  | `   | |  | |  |   |  | |  `---. |  |`    |  | |  |    |  |    |  `---. '  '--'\\ \r\n" +
						"`--' `--' `--'  `--' `--' `--'   `--' `------' `--'     `--' `--'    `--'    `------'  `-----' ";
		System.out.println(welcomeMessage);
	}

}
