package spring.tutorial.web.base;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	/**
	 * 加载应用中的其他 bean，这些 bean 通常是驱动应用的后端中间层和数据层组件
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}

	/**
	 * 加载配置类或配置文件中声明的 bean，通常是视图解析器、控制器等
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	/**
	 * 将一个或多个路径映射到 DispatcherServlet 上
	 * "/" 表示为应用的默认 servlet，它会处理进入应用的所有请求
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
