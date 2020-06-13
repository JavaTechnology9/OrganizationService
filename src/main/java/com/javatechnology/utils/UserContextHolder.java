package com.javatechnology.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserContextHolder {
	private static final ThreadLocal<UserContext> userContext=new ThreadLocal<>();
	
	public static final UserContext getContext() {
		UserContext context=userContext.get();
		if(context==null) {
			context=createEmptyContext();
			userContext.set(context);
		}
		return userContext.get();
	}
	public static final void setContext(UserContext context) {
		Assert.notNull("Only not null usercontext instance are permetted");
		userContext.set(context);
		
	}
	private static UserContext createEmptyContext() {
		// TODO Auto-generated method stub
		return new UserContext();
	}

}
