package spring.tutorial.aop.annotation;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ViewCounterAdvice {
	
	private Map<Integer, Integer> viewCounts = new HashMap<Integer, Integer>();
	
//	@Pointcut("execution(* spring.tutorial.aop.annotation.manager.IDesignManager.getDetail(int)) " + " && args(designId)")
	@Pointcut("execution(* spring.tutorial.aop.annotation.manager.IDesignManager.getDetail(..))")
	public void trackViewNumber() {}
	
//	@Around("trackViewNumber(designId)")
	public void countNumber(int designId, ProceedingJoinPoint jp) {
		try {
			System.out.println("id : " + designId + ", number of view is : " + getDesignViewNumber(designId));
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Before("trackViewNumber()")
	public void countNumber2() {
		System.out.println("aop advice: before");
//		System.out.println("id : " + designId + ", number of view is : " + getDesignViewNumber(designId));
	}
	
	public Integer getDesignViewNumber(Integer designId) {
		Integer designViewNumber = viewCounts.containsKey(designId) ? viewCounts.get(designId) : 0;
		viewCounts.put(designId, designViewNumber + 1);
		return designViewNumber + 1;
	}

}
