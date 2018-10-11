package com.niit.MYfirstbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Configdbtest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
	}

}
