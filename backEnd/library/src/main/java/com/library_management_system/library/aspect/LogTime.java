package com.library_management_system.library.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;


@Aspect
@Component
public class LogTime {

    Logger log= LoggerFactory.getLogger(LogTime.class);

    @Pointcut(value = "execution(* com.library_management_system.library.service..*(..))")
    public void logPointCut(){

    }

    //the next code will execute before and after the function
    @Around("logPointCut()")
    //using join point we can retrieve info about the function
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();

        //getSignature() return method name ,withArgs return parameters for the method, joinPoint.getArgs() will return the parameters
        ObjectMapper mapper= new ObjectMapper();
        String methodName = joinPoint.getSignature().getName();
        String className= joinPoint.getTarget().getClass().toString();

        Object[] methodArg = joinPoint.getArgs();
        Object returnValue = joinPoint.proceed();

        long executionTime = System.currentTimeMillis()- startTime;
        log.info("Class Name is " + className+ ",Mehtod name is "+methodName+"() ,with Arguments: "+mapper.writeValueAsString(methodArg)+" and It takes "+ executionTime + " ms.");
        return returnValue;
    }




}
