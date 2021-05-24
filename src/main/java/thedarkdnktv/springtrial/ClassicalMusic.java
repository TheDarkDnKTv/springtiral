package thedarkdnktv.springtrial;

/**
 * @author TheDarkDnKTv
 *
 */
public class ClassicalMusic implements IMusic {
	
	private ClassicalMusic() {}
	
	public static ClassicalMusic getInstance() {
		return new ClassicalMusic();
	}
	
	public void init() {
		System.out.println("Init of bean");
	}
	
	public void destroy() {
		System.out.println("Destroy of bean");
	}
	
	@Override
	public String getSong() {
		return "Hungarian Rhapsody";
	}

}
