package thedarkdnktv.springtrial;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		IMusic mus = context.getBean("rockMusic", IMusic.class);
		IMusic mus1 = context.getBean("classicalMusic", IMusic.class);
		
		MusicPlayer musicPlayer = new MusicPlayer(mus);
		musicPlayer.playMusic();

		MusicPlayer musicPlayer1 = new MusicPlayer(mus1);
		musicPlayer1.playMusic();
		
		context.close();
	}
}
