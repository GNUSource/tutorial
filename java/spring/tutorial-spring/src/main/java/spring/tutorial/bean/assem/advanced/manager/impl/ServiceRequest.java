package spring.tutorial.bean.assem.advanced.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.tutorial.bean.assem.advanced.manager.IServiceRequest;
import spring.tutorial.bean.assem.advanced.permission.IPermission;
import spring.tutorial.util.Constants;

@Component
public class ServiceRequest implements IServiceRequest {
	
	@Autowired
	@Qualifier(Constants.PERMISSION_MANAGE_SERVICE_REQUEST)
	private IPermission iPermission;
	
	@Override
	public Boolean accessUri(String userType) {
		return iPermission.checkPermission(userType, Constants.PERMISSION_MANAGE_SERVICE_REQUEST);
	}

}
