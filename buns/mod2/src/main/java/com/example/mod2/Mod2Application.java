package com.example.mod2;

import aop.Book;
import aop.Config;
import aop.UniLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mod2Application {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);

		UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);
		library.addBook(new Book("Война и мир", "Л.Н.Толстой"));
		library.addBook(new Book("Гарри Поттер и философский камень", "Дж.К.Роулинг"));
		library.addBook(new Book("Гарри Поттер и узник Азкабана", "Дж.К.Роулинг"));
		library.addBook(new Book("Гарри Поттер и Кубок огня", "Дж.К.Роулинг"));

		System.out.println(library.getBook("Вперед, Гаря, ты избранный"));

		System.out.println(library);

		context.close();
	}
}
