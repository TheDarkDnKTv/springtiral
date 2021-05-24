package thedarkdnktv.springtrial.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author TheDarkDnKTv
 *
 */
public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {
			SpringConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {
			"/" // Send all requests to servlet
		};
	}

}
