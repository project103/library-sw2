package com.library_management_system.library.aspect;

import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.Category;
import com.library_management_system.library.repository.BookRepository;
import com.library_management_system.library.repository.CategoryRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.AccessibleObject;


@Aspect
@Component
public class CategoryAspect {

    Logger log= LoggerFactory.getLogger(CategoryAspect.class);

    //the next code will execute before and after the function
    @Around(value = "execution(* com.library_management_system.library.service..*(..))")
    //using join point we can retrieve info about the function
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable{

        long startTime = System.currentTimeMillis();
        //kpi tell us the time that function takes.
        //getSignature() return method name ,withArgs return parameters for the method, joinPoint.getArgs() will return the parameters
        StringBuilder sb= new StringBuilder("KPI");
        sb.append("[").append(joinPoint.getKind()).append("]\tfor: ").append(joinPoint.getSignature())
                .append("\twithArgs: ").append("(").append(StringUtils.join(joinPoint.getArgs(), ",")).append(")");
        sb.append("\ttook: ");

        Object returnValue = joinPoint.proceed();
         log.info(sb.append(System.currentTimeMillis() - startTime).append("ms.").toString());
         return returnValue;
    }

}
