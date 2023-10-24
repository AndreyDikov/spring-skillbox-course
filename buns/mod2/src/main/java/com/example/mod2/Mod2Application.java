package com.example.mod2;

import aop.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mod2Application {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);

		context.close();
	}
}
