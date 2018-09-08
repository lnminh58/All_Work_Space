package com.lnminh.hello.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

public class AuthenticationInterceptor implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("inside auth interceptor");
        Map<String,Object> sessionAttribute = invocation.getInvocationContext().getSession();
        String user = (String) sessionAttribute.get("USER");
        if (user==null){
            return "login";
        } else {
            Action action = (Action) invocation.getAction();
            return invocation.invoke();
        }
    }
}
