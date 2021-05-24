package thedarkdnktv.springtrial.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author TheDarkDnKTv
 *
 */
@Component
public class Computer {
	
	private int id;
	private MusicPlayer player;
	
	@Autowired
	public Computer(MusicPlayer player) {
		this.id = 1;
		this.player = player;
	}
	
	@Override
	public String toString() {
		return String.format("Computer{id=%d, player=%s}", id, player.playMusic());
	}
}
