package spring.tutorial.bean.assem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.tutorial.bean.assem.manager.IFlower;
import spring.tutorial.bean.assem.manager.impl.Rose;

@Configuration
public class FlowerConfig {
	
	@Bean
	public IFlower flower() {
		IFlower iFlower = new Rose();
		return iFlower;
	}

}
