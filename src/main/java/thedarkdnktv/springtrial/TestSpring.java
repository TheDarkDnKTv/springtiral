package thedarkdnktv.springtrial;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
//		MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//		musicPlayer.playMusic();
//		
//		System.out.println(musicPlayer.getName());
//		System.out.println(musicPlayer.getVolume());
		IMusic mus = context.getBean("musicBean", IMusic.class);
		
		System.out.println(mus.getSong());
		
		context.close();
	}
}
