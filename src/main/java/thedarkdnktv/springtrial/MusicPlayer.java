package thedarkdnktv.springtrial;

/**
 * @author TheDarkDnKTv
 *
 */
public class MusicPlayer {
	
	private IMusic music;
	
	// Inversion of Controll
	public MusicPlayer(IMusic musicIn) {
		this.music = musicIn; 
	}
	
	public void playMusic() {
		System.out.println("Playing: " + music.getSong());
	}
}
