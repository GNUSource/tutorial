package spring.tutorial.bean.assem.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.tutorial.bean.assem.manager.ICar;
import spring.tutorial.bean.assem.manager.IPlant;

@Component(value="specialTree")
public class Tree implements IPlant {
	
	@Autowired
	private ICar icar;

	private String name = "我是树木";

	@Override
	public void getName() {
		System.out.println(this.name);
	}
	
	public void printName() {
		this.getName();
		this.icar.sayName();
	}
}
