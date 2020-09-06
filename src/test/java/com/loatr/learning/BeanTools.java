package com.loatr.learning;

import java.lang.reflect.Method;

public class BeanTools {
    
    public static Object getBeanValue(Object bean,String beanName){
        String methodName = "get" + beanName.substring(0,1).toUpperCase() + beanName.substring(1);
		Class<?> c = bean.getClass();
		try {
			Method m= c.getMethod(methodName);
			Object value = m.invoke(bean);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
}
