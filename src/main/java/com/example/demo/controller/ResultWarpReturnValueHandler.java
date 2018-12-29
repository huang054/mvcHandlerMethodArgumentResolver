package com.example.demo.controller;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 对返回数据类型的包装
 */
public class ResultWarpReturnValueHandler  implements HandlerMethodReturnValueHandler {

    private final HandlerMethodReturnValueHandler handlerMethodReturnValueHandler;

    public ResultWarpReturnValueHandler(HandlerMethodReturnValueHandler handlerMethodReturnValueHandler){
          this.handlerMethodReturnValueHandler=handlerMethodReturnValueHandler;

    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return handlerMethodReturnValueHandler.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
                handlerMethodReturnValueHandler.handleReturnValue(new Response(returnValue),returnType,mavContainer,webRequest);
    }
}
