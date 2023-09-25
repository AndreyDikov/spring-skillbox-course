package com.example.mod1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mod1Application {

	public static void main(String[] args) {
		xml();
		annotations();
		java1();
		java2();
	}

	private static void xml() {
		System.out.println("[XML Configuration]:");
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		xmlConfiguration.Person person =
				context.getBean("person", xmlConfiguration.Person.class);
		person.callPet();
		context.close();
	}

	private static void annotations() {
		System.out.println("\n\n[ANNOTATIONS Configuration]:");
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext2.xml");
		annotationsConfiguration.Person person =
				context.getBean("person", annotationsConfiguration.Person.class);
		System.out.println(person);
		person.callPet();
		context.close();
	}

	private static void java1() {
		System.out.println("\n\n[JAVA1 Configuration]:");
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(javaCodeConfiguration1.Config.class);
		javaCodeConfiguration1.Person person = context.getBean(
				"person",
				javaCodeConfiguration1.Person.class
		);
		System.out.println(person);
		person.callPet();
		context.close();
	}

	private static void java2() {
		System.out.println("\n\n[JAVA2 Configuration]:");
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(javaCodeConfiguration2.Config.class);
		javaCodeConfiguration2.Person person = context.getBean(
				"person",
				javaCodeConfiguration2.Person.class
		);
		System.out.println(person);
		person.callPet();
		context.close();
	}
}
