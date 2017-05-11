package spring.tutorial.bean.assem.manager.impl;

import spring.tutorial.bean.assem.manager.ICar;
import spring.tutorial.bean.assem.manager.IFlower;

public class Bwm implements ICar {
	
	private IFlower iflower;

	public IFlower getIflower() {
		return iflower;
	}

	public void setIflower(IFlower iflower) {
		this.iflower = iflower;
	}

	public void sayName() {
		System.out.println("宝马");
	}

}
