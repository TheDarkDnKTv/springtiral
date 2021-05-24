package thedarkdnktv.springtrial;

/**
 * @author TheDarkDnKTv
 *
 */
public class MusicPlayer {
	
	private IMusic music;
	
	private String name;
	private int volume;
	
	public MusicPlayer() {}
	
	// Inversion of Controll
	public MusicPlayer(IMusic musicIn) {
		this.music = musicIn; 
	}
	
	public void playMusic() {
		System.out.println("Playing: " + music.getSong());
	}
	
	public void setMusic(IMusic music) {
		this.music = music;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
}
