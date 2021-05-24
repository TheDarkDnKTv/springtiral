package thedarkdnktv.springtrial.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		Computer comp = context.getBean("computer", Computer.class);
		
		System.out.println(comp.toString());
		
		context.close();
	}
}
