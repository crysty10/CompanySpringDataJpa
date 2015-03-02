package ro.company.aspects;

import ro.company.annotation.AuditableAnnotation;
import ro.company.domain.AuditableImpl;

/**
* Created by Cristian.Dumitru on 2/23/2015.
*/
public aspect AuditableIntroducer {

    public AuditableIntroducer() {}

    /**
     * Employee extends AuditableImpl, so we can add those new columns to our table.
     * */
    //declare parents : ro.company.domain.Identifiable+ extends ro.company.domain.Auditable+;
    declare parents : (@AuditableAnnotation *) extends AuditableImpl;
}

/*TODO:
* Resolve all the warnings or errors that we get at runtime!
* See how to use all the entities in AuditableIntroducer to extends AuditableImpl!
* Debug why with @Aspect, from package springaop, doesn't work!
* Create service for all the entities!
* Rename the functions to CRUD, from service!
* Clean up the code!
* ...*/
