package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
public class WebServiceLogger {

    private static final Logger logger = LoggerFactory.getLogger(WebServiceLogger.class);

    @Pointcut("execution(* app.*(..))")
    public void webServiceMethod() {
    }

    @Around("webServiceMethod()")
    public void logWebService(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getClass().getName();
        Object[] args = joinPoint.getArgs();

        logger.debug("Call method " + methodName + " in class " + className + (args == null || args.length == 0 ? null : " with args " + Arrays.toString(args)));
        joinPoint.proceed();
        logger.debug("End method " + methodName + " in class " + className + (args == null || args.length == 0 ? null : " with args " +
                Arrays.toString(args)));
    }
}