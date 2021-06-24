package someshbose.github.io.springaopexample.service;

import org.springframework.stereotype.Service;
import someshbose.github.io.springaopexample.aspect.Loggable;
import someshbose.github.io.springaopexample.customaspect.Counter;

@Service
public class GreetingService {

  @Loggable
  @Counter
  public String getGreeting(String name){
    return "Hola" + name;
  }
}
