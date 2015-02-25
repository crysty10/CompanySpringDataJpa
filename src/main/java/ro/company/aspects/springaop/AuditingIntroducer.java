//package ro.company.aspects.springaop;
//
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.DeclareParents;
//import ro.company.domain.Auditable;
//import ro.company.domain.AuditableImpl;
//
///**
//* Created by Cristian.Dumitru on 2/19/2015.
//*/
//@Aspect
//public class AuditingIntroducer {
//
//    public AuditingIntroducer(){}
//
//    /**
//     * Adding new functionality around the objects methods. Concept known as
//     * introduction(4.3.4 from Spring in action 3rd edition).
//     */
//    @DeclareParents(value = "ro.company.domain.Identifiable+", defaultImpl = AuditableImpl.class)
//    public static Auditable auditable;
//
//    /**
//     * Factory method for aspect!
//     * */
//    public static AuditingIntroducer aspectOf(){
//        return new AuditingIntroducer();
//    }
//}