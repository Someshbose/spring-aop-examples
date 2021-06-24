package someshbose.github.io.springaopexample.aspect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggableAspect {

  private static final Logger logger= LoggerFactory.getLogger(LoggableAspect.class);

  @Pointcut("@annotation(Loggable)")
  public void executeLogging(){ }

//  @Before("executeLogging()")
//  public void logMethodCall(JoinPoint joinPoint){
//    StringBuilder message = new StringBuilder("Method:");
//    message.append(joinPoint.getSignature().getName());
//    Object[] args = joinPoint.getArgs();
//
//    if(null!=args && args.length>0){
//      message.append(" args= [ | ");
//      Arrays.asList(args).forEach(arg->{
//            message.append(arg).append(" | ");
//          });
//      message.append(" ]");
//    }
//    logger.info(message.toString());
//  }

//  @AfterReturning(value = "executeLogging()",returning = "returnValue")
//  public void logMethodCall2(JoinPoint joinPoint, Object returnValue){
//    StringBuilder message = new StringBuilder("Method:");
//    message.append(joinPoint.getSignature().getName());
//    Object[] args = joinPoint.getArgs();
//
//    if(null!=args && args.length>0){
//      message.append(" args= [ | ");
//      Arrays.asList(args).forEach(arg->{
//        message.append(arg).append(" | ");
//      });
//      message.append(" ]");
//    }
//
//    if(returnValue instanceof Collections){
//      message.append(", returning: ").append(((Collection)returnValue).size()).append(" parameters.");
//    }else{
//      message.append(", returning: ").append(returnValue.toString());
//    }
//    logger.info(message.toString());
//  }

  @Around(value = "executeLogging()")
  public Object logMethodCall3(ProceedingJoinPoint joinPoint) throws Throwable {

    long startTime = System.currentTimeMillis();
    Object returnValue = joinPoint.proceed();
    long totalTime = System.currentTimeMillis()-startTime;
    StringBuilder message = new StringBuilder("Method:");
    message.append(joinPoint.getSignature().getName());
    message.append(" totalTime").append(totalTime).append("ms.");

    Object[] args = joinPoint.getArgs();

    if(null!=args && args.length>0){
      message.append(" args= [ | ");
      Arrays.asList(args).forEach(arg->{
        message.append(arg).append(" | ");
      });
      message.append(" ]");
    }

    if(returnValue instanceof Collections){
      message.append(", returning: ").append(((Collection)returnValue).size()).append(" parameters.");
    }else{
      message.append(", returning: ").append(returnValue.toString());
    }
    logger.info(message.toString());

    return returnValue;
  }

}
