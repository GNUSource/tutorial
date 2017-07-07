package spring.tutorial.web.base;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import spring.tutorial.jdbc.DataSourceConfig;
import spring.tutorial.websocket.WebSocketConfig;
import spring.tutorial.websocket.WebSocketMessageBrokerConfig;

@Configuration
@ComponentScan
@Import({DataSourceConfig.class, WebSocketConfig.class, WebSocketMessageBrokerConfig.class})
public class RootConfig {
	
//	@Bean
//	public MultipartResolver multipartResolver() {
//		return new StandardServletMultipartResolver();
//	}
	
	@Bean
	public MultipartResolver multipartResolver() throws IOException {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		// 临时目录
		commonsMultipartResolver.setUploadTempDir(new FileSystemResource("D:/workspace/kaifei/tmp"));
		// 上传文件大小
		commonsMultipartResolver.setMaxUploadSize(10240000);
		// 所占用的最大内存，0 表示不管文件大小如何，所有文件都会写入磁盘
		commonsMultipartResolver.setMaxInMemorySize(0);
		
		return commonsMultipartResolver;
	}
}
