package thedarkdnktv.springtrial;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		IMusic music = context.getBean("musicBean", IMusic.class);
		new MusicPlayer(music).playMusic(); // Ручное внедрение зависимостей
		
		context.close();
	}
}
