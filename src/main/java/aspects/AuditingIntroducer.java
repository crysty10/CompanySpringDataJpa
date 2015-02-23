package aspects;

import domain.Auditable;
import domain.AuditableImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by Cristian.Dumitru on 2/19/2015.
 */
//@Aspect
public class AuditingIntroducer {
    /**
     * Adding new functionality around the objects methods. Concept known as
     * introduction(4.3.4 from Spring in action 3rd edition).
     */

//    @DeclareParents(value = "domain.*+", defaultImpl = AuditableImpl.class)
    public static Auditable auditable;
}