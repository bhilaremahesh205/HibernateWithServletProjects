package com.javatpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {

		
		//System.out.println("---------Using BeanFactory --------");
		//Resource resource = new ClassPathResource("applicationContext.xml");
		//BeanFactory factory = new XmlBeanFactory(resource);

		//Student student1 = (Student) factory.getBean(""studentId"");
		//student1.displayInfo();
		
		//Employee emp1 = (Employee) factory.getBean("employeeId1");
		//emp1.show();
		

		System.out.println("---------Using Application Context--------");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		//Student student2 = (Student) context.getBean(""studentId"");
		//student2.displayInfo();
		
		Employee emp4 = (Employee) context.getBean("employeeId4");
		emp4.display("before set emp4");
		emp4.setId(444);
		emp4.setName("Name444");
		emp4.display("after set emp4");
		System.out.println();
		
		Employee emp5 = (Employee) context.getBean("employeeId4");
		//emp5.setId(555);
		//emp5.setName("Name555");
		
		
		Employee emp6 = (Employee) context.getBean("employeeId4");
		
		Employee emp7 = (Employee) context.getBean("employeeId4");
		
		emp5.display("emp5");
		emp6.display("emp6");
		emp7.display("emp7");
		
		
		
		
		
		
		

	}
}
