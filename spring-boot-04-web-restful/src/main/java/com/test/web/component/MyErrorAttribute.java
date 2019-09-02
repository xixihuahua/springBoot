package com.test.web.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * description
 *
 * @author 24360 2019/08/30 10:48
 */

@Component
public class MyErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company" , "xixihuahua");
        //自定义异常处理器携带的数据
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext",0);
        map.put("ext",ext);
        return map ;
    }
}
