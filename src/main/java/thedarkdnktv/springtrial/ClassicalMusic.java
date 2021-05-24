package thedarkdnktv.springtrial;

import org.springframework.stereotype.Component;

/**
 * @author TheDarkDnKTv
 *
 */
@Component
public class ClassicalMusic implements IMusic {
	@Override
	public String getSong() {
		return "Hungarian Rhapsody";
	}
}
