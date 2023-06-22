package org.gontuseries.springcore;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringProject {
public static void main(String args[]) {
	ClassPathXmlApplicationContext context=
			new ClassPathXmlApplicationContext();
	Restaruant restaruantObj = (Restaruant) context.getBean("restaruantBean");
	restaruantObj.greetCustomer();
}
}
