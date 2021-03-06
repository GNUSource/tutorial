package spring.tutorial.bean.assem.advanced.permission.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.tutorial.bean.assem.advanced.manager.impl.BasePermission;
import spring.tutorial.util.Constants;

@Component
@Qualifier(Constants.PERMISSION_MANAGE_SERVICE_REQUEST)
public class PermissionOfManagerServiceRequest extends BasePermission {

	@Override
	public Boolean checkPermission(String userType, String perssion) {
		return super.checkPermission(userType, perssion);
	}
}
