package gitHub.saad.spring.boot;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@SpringBootApplication
@EnableJpaRepositories
@EnableCaching
public class Application {
	@Bean
	public ServletRegistrationBean h2servletRegistration(){
		String url= "/console/*";
		ServletRegistrationBean registrition = new ServletRegistrationBean();
		registrition.addUrlMappings(url);
		registrition.setServlet(new WebServlet());
		return registrition;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}