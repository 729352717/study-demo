package com.jsh.demo.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 国际化配置
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Locale loacale = Locale.getDefault();
        if (loacale != null && request.getHeader("Accept-Language") == null) {
            return loacale;
        } else {
            // 截取请求参数，获取语言环境
            String lang = request.getParameter("l");
            if(StringUtils.hasLength(lang)){ // 如果没有传使用默认的
                String[] langArr = lang.split("_");
                loacale = new Locale(langArr[0], langArr[1]);
            }
        }
        return loacale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
