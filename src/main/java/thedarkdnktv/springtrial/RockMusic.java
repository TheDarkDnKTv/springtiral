package thedarkdnktv.springtrial;

import org.springframework.stereotype.Component;

/**
 * @author TheDarkDnKTv
 *
 */
@Component
public class RockMusic implements IMusic {
	@Override
	public String getSong() {
		return "Wind cries Mary";
	}
}
