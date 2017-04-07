package spring.tutorial.bean.assem.manager.impl;

import org.springframework.stereotype.Component;

import spring.tutorial.bean.assem.manager.IPlant;

@Component
public class Tree implements IPlant {

	private String name = "我是树木";

	@Override
	public void getName() {
		System.out.println(this.name);
	}
}
