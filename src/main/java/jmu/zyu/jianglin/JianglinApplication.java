package jmu.zyu.jianglin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
//@SpringBootConfiguration
public class JianglinApplication {

	public static void main(String[] args) {
		SpringApplication.run(JianglinApplication.class, args);
	}

}
