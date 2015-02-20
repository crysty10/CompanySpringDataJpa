package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by Cristian.Dumitru on 2/19/2015.
 */
@Aspect
@Component
public class AuditingIntroducer {
    /**
     * Adding new functionality around the objects methods. Concept known as
     * introduction(4.3.4 from Spring in action 3rd edition).
     * */

     @DeclareParents(value = "domain.*", defaultImpl = AuditingInterfaceImpl.class)
    public static AuditingInterface auditingInterface;
}