package spring.tutorial.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Constants {
	
	public static final String PERMISSION_OPERATE_OWNER = "operateOwner";
	
	public static final String PERMISSION_MANAGE_SERVICE_REQUEST = "manageServiceRequest";
	
	public static Map<String, String> user_type_x_permission;
	
	static {
		user_type_x_permission = new HashMap<String, String>();
		user_type_x_permission.put("sysAdmin", PERMISSION_OPERATE_OWNER);
		user_type_x_permission.put("sysAdmin", PERMISSION_MANAGE_SERVICE_REQUEST);
		user_type_x_permission.put("operator", PERMISSION_MANAGE_SERVICE_REQUEST);
		user_type_x_permission.put("user", "");
	}
	
}
