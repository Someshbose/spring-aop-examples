package someshbose.github.io.springaopexample.aspect;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
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

  @Before("executeLogging()")
  public void logMethodCall(JoinPoint joinPoint){
    StringBuilder message = new StringBuilder("Method:");
    message.append(joinPoint.getSignature().getName());
    Object[] args = joinPoint.getArgs();

    if(null!=args && args.length>0){
      message.append(" args= [ | ");
      Arrays.asList(args).forEach(arg->{
            message.append(arg).append(" | ");
          });
      message.append(" ]");
    }
    logger.info(message.toString());
  }

}
