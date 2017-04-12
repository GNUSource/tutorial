package spring.tutorial.bean.assem.manager.impl;

import spring.tutorial.bean.assem.manager.IFlower;

public class Rose implements IFlower {

	@Override
	public void sayName() {
		System.out.println("I'm rose");
	}

}
