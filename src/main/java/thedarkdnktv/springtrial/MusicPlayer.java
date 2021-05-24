package thedarkdnktv.springtrial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author TheDarkDnKTv
 *
 */
@Component
public class MusicPlayer {

	private IMusic music;
	

	// Inversion of Controll
	@Autowired
	public MusicPlayer(@Qualifier("rockMusic") IMusic musicIn) {
		this.music = musicIn; 
	}
	
	public String playMusic() {
		return "Playing: " + music.getSong();
	}
}
