package thedarkdnktv.springtrial.mvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.HiddenHttpMethodFilter;
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
	
	@Override
	public void onStartup(ServletContext context) throws ServletException {
		super.onStartup(context);
		context.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter())
			.addMappingForUrlPatterns(null, true, "/*"); // Adds hidden http request in forms
	}
}
