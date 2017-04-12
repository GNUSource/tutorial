package spring.tutorial.bean.assem.manager.impl;

import spring.tutorial.bean.assem.manager.ICar;
import spring.tutorial.bean.assem.manager.IMobilePhone;

public class OnePlus implements IMobilePhone {

	private ICar icar;
	
	public OnePlus() {
	}
	
	public ICar getIcar() {
		return icar;
	}

	public void setIcar(ICar icar) {
		this.icar = icar;
	}

	public OnePlus(ICar icar) {
		this.icar = icar;
	}

	@Override
	public void sayName() {
		System.out.println("onePlus3...");
	}
}
