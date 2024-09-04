package com.revature.HelloSpringAOP.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect //This Class is an ASPECT. We will handle all of our Logging in this class
public class LoggingAspect {

    //Instantiate our Logger object
    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /*Before Advice
    - This method will run before any method in the models package runs
    - A log will be created indicating what method was called when */
    @Before("within(com.revature.HelloSpringAOP.models.*)")
    public void logHumanMethods(JoinPoint jp) {

        //getTarget() returns the class.object in question
        //getSignature() returns the method name
        logger.info(jp.getTarget() + " invoked " + jp.getSignature());
        logger.info("Kind: " + jp.getKind());

    }

    /*After Returning advice
    - This method will run after a method in the Human Class returns a value
    - If the method throws an error/exception, this advice will not get injected */
    @AfterReturning(pointcut = "execution(String eat(int))", returning = "result")
    public void logSuccessfulEat(JoinPoint jp, String result){
        logger.info(jp.getSignature() + " returned: " + result);
    }


    /*After Throwing advice
    - This method will run after a method in the Human Class throws an exception
    - If the method returns a value, this advice will not get injected */
    @AfterThrowing(pointcut = "execution(String eat(int))", throwing = "exception")
    public void logFailedEat(JoinPoint jp, IllegalArgumentException exception){
        logger.error(jp.getSignature() + " threw an exception: " + exception.getMessage());
    }


    //NOT SHOWN: there is also a generic After Advice (after a method completes)

    //NOT SHOWN: there is also a Around Advice (before and/or after a method is called)
}
