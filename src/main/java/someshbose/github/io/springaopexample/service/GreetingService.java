package someshbose.github.io.springaopexample.service;

import org.springframework.stereotype.Service;
import someshbose.github.io.springaopexample.aspect.Loggable;

@Service
public class GreetingService {

  @Loggable
  public String getGreeting(String name){
    return "Hola" + name;
  }
}
