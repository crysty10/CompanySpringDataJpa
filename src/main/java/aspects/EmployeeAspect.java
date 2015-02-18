package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Cristian.Dumitru on 2/18/2015.
 */
@Aspect
@Component
public class EmployeeAspect {

    @Pointcut("execution(* repository.EmployeeRepository.findEmployeeByFirstname(..))")
    private void pointcutBeforeFindEmployee() {}

    @Before("pointcutBeforeFindEmployee()")
    private void beforeFindEmployee() {
        System.out.println("Now we are going to find an employee by firstname:");
    }

    @After("pointcutBeforeFindEmployee()")
    private void afterFindEmployee() {
        System.out.println("The aspect went well!");
    }

    /*@Around("pointcutBeforeFindEmployee()")
    private void doSomething(ProceedingJoinPoint pjp){
        try {
            System.out.println("Now we are going to find an employee by firstname:");
            pjp.proceed();
            System.out.println("The aspect went well!");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }*/
}
