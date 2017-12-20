package com.loyom.rank.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public class AppVerifyAuthInterceptor extends AbsInterceptor {

    private static final String IDENTIFY_CODE = "/api/v1/rank/";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String appId = this.extractAppID(request);
        if (appId == null) {
            return true;
        }
        System.out.println(appId);
        System.out.println(appId);
        System.out.println(appId);
        return true;
    }

    private String extractAppID(HttpServletRequest request) {
        String uri = request.getRequestURI();
        if (uri.indexOf(IDENTIFY_CODE) == 0) {
            String tmp = uri.substring(IDENTIFY_CODE.length());
            String[] info = tmp.split("/");
            return info[0];
        }
        return null;
    }
}
