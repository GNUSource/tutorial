package spring.tutorial.bean.assem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.tutorial.bean.assem.manager.ICar;
import spring.tutorial.bean.assem.manager.IFlower;
import spring.tutorial.bean.assem.manager.IMobilePhone;
import spring.tutorial.bean.assem.manager.impl.Bwm;
import spring.tutorial.bean.assem.manager.impl.OnePlus;

@Configuration
@ComponentScan
@Import(FlowerConfig.class)
public class JavaConfig {
	/**
	 * 显示的装配bean
	 * 
	 * @param iCar 通过 DI 注入
	 * @return
	 */
	@Bean(name="phone")
	public IMobilePhone getMobilePhone(ICar iCar) {
		OnePlus onePlus = new OnePlus(iCar);
		return onePlus;
	}
	
	/**
	 * 注入其他配置类中的 bean
	 * @param iFlower
	 * @return
	 */
	@Bean(name="car")
	public ICar getCar(IFlower iFlower) {
		Bwm bwm = new Bwm();
		bwm.setIflower(iFlower);
		return bwm;
	}
}
