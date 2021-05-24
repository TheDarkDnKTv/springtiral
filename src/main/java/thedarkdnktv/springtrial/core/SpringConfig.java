package thedarkdnktv.springtrial.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author TheDarkDnKTv
 *
 */
@Configuration
@ComponentScan("thedarkdnktv.springtrial") // Enable scanning
@PropertySource("classpath:MusicPlayer.properties") // Source of some values
public class SpringConfig {
	
	/*
	 * Insteadof XML config
	 * 
	 * @Bean
	 * public ClassicMusic musicBean() {
	 * 		return new ClassicalMusic();
	 * }
	 */
}
