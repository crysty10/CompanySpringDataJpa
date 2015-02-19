package aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.time.LocalDateTime;

/**
 * Created by Cristian.Dumitru on 2/19/2015.
 */
//@Aspect
//@Component
public class AuditingAspect {

    /*
    *
    * */
    @Inject
    private AuditingInterface auditingInterface;

    /*
    *
    * */
    @Pointcut("execution(* repository.*.save(..))")
    public void pointcutGetDate(){}

    @Before("pointcutGetDate()")
    public void beforePointcutGetDate() {

    }

    @After("pointcutGetDate()")
    public void afterPointcutGetDate() {

    }

    /*
    *
    * */
    @Pointcut("execution(* repository.*.save(..)) && args(localDateTime)")
    public void pointcutSetDate(LocalDateTime localDateTime){}

    @Before("pointcutSetDate(localDateTime)")
    public void beforePointcutSetDate(LocalDateTime localDateTime) {

    }

    @After("pointcutSetDate(localDateTime)")
    public void afterPointcutSetDate(LocalDateTime localDateTime) {

    }
}
