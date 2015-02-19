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

    /*
    * Choose the pointcut, to insert the advice!
    * */
    @Pointcut("execution(* repository.EmployeeRepository.findEmployeeByFirstname(..))")
    private void pointcutBeforeFindEmployee() {}

//    /*
//    * Actions before the execution of the pointcut!
//    * */
//    @Before("pointcutBeforeFindEmployee()")
//    private void beforeFindEmployee() {
//        System.out.println("Now we are going to find an employee by firstname:");
//    }
//
//    /*
//    * Actions after the execution of the pointcut!
//    * */
//    @After("pointcutBeforeFindEmployee()")
//    private void afterFindEmployee() {
//        System.out.println("The aspect went well!");
//    }

    /*
    * Actions that are executed "around" the pointcut!
    * It uses ProceedingJoinPoint method proceed() to support around advice!
    * */
    @Around("pointcutBeforeFindEmployee()")
    private Object doSomething(ProceedingJoinPoint pjp){
        Object object = null;
        try {
            System.out.println("Now we are going to find an employee by firstname:");
            object = pjp.proceed();
            System.out.println("The aspect went well!");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return object;
    }
}
