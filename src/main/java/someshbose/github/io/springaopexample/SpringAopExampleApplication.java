package someshbose.github.io.springaopexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import someshbose.github.io.springaopexample.service.GreetingService;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopExampleApplication implements CommandLineRunner {

	@Autowired
	private GreetingService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringAopExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			service.getGreeting("Somesh");
			service.getGreeting("Roshan");
	}
}
