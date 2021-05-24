package thedarkdnktv.springtrial;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Computer comp = context.getBean("computer", Computer.class);
		
		System.out.println(comp.toString());
		
		context.close();
	}
}
