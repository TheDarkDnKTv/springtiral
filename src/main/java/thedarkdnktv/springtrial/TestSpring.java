package thedarkdnktv.springtrial;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		TestBean test = context.getBean("testBean", TestBean.class);
		
		System.out.println(test.getName());
		
		context.close();
	}
}
