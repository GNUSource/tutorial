package spring.tutorial.aop.annotation.manager.impl;

import org.springframework.stereotype.Component;

import spring.tutorial.aop.annotation.manager.IDesignManager;

@Component
public class DesignManagerImpl implements IDesignManager {

	@Override
	public void getDetail(Integer designId) {
		System.out.println("show id : " + designId + " detail...");
	}
}
