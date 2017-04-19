package spring.tutorial.bean.assem.advanced.manager.impl;

import spring.tutorial.bean.assem.advanced.permission.IPermission;
import spring.tutorial.util.Constants;

public class BasePermission implements IPermission {
	
	@Override
	public Boolean checkPermission(String userType, String perssion) {
		String value = Constants.user_type_x_permission.get(userType);
		return perssion.equals(value);
	}
	
}
