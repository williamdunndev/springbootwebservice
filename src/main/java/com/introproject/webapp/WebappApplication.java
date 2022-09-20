package com.introproject.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebappApplication {

	public static void main(String[] args) {
		// Dependency injection means we don't have to focus on object creation (ie. using "new").
		// "run" initialises Spring Container which contains objects called Spring Beans.
		// We decide which of our classes are initialised as Beans by adding @Component before the class definition.
		// Beans are created with Singleton or Prototype scope (there are others too). Singleton is default, which means
		// that only one instance of a class is created.
		// Set scope using eg. "@Scope(value="prototype")".
		// When using Prototype scope, the object is only created when it is requested (getBean is called). So more than one object
		// may be created.
		ConfigurableApplicationContext context = SpringApplication.run(WebappApplication.class, args);

		// The Player Bean is injected into the application
		Player p1 = context.getBean(Player.class);
		p1.printHello();






	}

}
