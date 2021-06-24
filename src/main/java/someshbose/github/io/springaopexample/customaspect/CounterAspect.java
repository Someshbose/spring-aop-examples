package someshbose.github.io.springaopexample.customaspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CounterAspect {

  private static int counter =0;
  @Pointcut("@annotation(Counter)")
  public void executeCounting(){ }

  @Before(value = "executeCounting()")
  public void startCounting(JoinPoint joinPoint){
    counter++;
    System.out.println("method "+joinPoint.getSignature().getName() +counter +" counter");
  }
}
