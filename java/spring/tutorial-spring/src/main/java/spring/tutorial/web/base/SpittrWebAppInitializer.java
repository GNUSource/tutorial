package spring.tutorial.web.base;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

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
	
	/**
	 * 通过该方法，我们可以对 DispatcherServlet 进行额外的配置，从而实现自定义 DispatcherServlet 配置
	 * (1). 调用 setLoadOnStartup() 设置 load-on-startup 优先级
	 * (2). 调用 setInitParameter() 设置初始化参数
	 * (3). 调用 setMultipartConfig() 配置 Servlet 3.0 对 multipart的支持
	 */
	@Override
	protected void customizeRegistration(Dynamic registration) {
		/**
		 * 配置 multipart 请求
		 * 可以接受的参数有：
		 * 临时目录：临时目录路径（必填）
		 * 上传文件的最大容量：以字节为单位，默认是没有限制的。
		 * 整个multipart请求的最大容量：以字节为单位，不会关心有多少个part以及每个part的大小，默认是没有限制的。
		 * 是否写入临时文件：在上传的过程中，如果文件大小达到了一个指定最大容量，将会写入到临时文件路径中，默认值为0，也就是所有上传的文件都会写入到磁盘上。
		 */
//		registration.setMultipartConfig(new MultipartConfigElement("D:/workspace/kaifei/tmp"));
	}

}
