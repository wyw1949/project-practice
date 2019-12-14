package com.yoke.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest req, Exception exception){
        log.error("request url:{}, exception:{}", req.getRequestURL(), exception);
        final ModelAndView mv = new ModelAndView();
        mv.addObject("url", req.getRequestURL());
        mv.addObject("exception", exception);
        mv.setViewName("error/error");
        return mv;
    }
}
