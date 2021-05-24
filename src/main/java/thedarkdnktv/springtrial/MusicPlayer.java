package thedarkdnktv.springtrial;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author TheDarkDnKTv
 *
 */
@Component
@Scope("singleton") // I know i not needed to specify it
public class MusicPlayer {

	private IMusic music;
	
	@Value("${musicPlayer.name}")
	private String name;
	@Value("${musicPlayer.volume}")
	private int voulme;

	// Inversion of Controll
	@Autowired
	public MusicPlayer(@Qualifier("rockMusic") IMusic musicIn) {
		this.music = musicIn; 
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Init method");
	}
	
	@PreDestroy
	public void destory() {
		System.out.println("Destory method");
	}
	
	public String playMusic() {
		return "Playing: " + music.getSong();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVoulme() {
		return voulme;
	}

	public void setVoulme(int voulme) {
		this.voulme = voulme;
	}
}
