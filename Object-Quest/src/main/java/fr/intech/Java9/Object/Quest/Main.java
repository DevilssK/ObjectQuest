package fr.intech.Java9.Object.Quest;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class Main {

	public static void main (String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean(initMethod = "start", destroyMethod = "stop")
	@ConditionalOnProperty(value = "h2.autoServer.enabled",havingValue = "true")
	public Server inMemoryH2DatabaseaServer() throws SQLException {
		return Server.createTcpServer(
				"-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
	}

}
