package ro.company.aspects;

/**
* Created by Cristian.Dumitru on 2/23/2015.
*/
public aspect AuditableIntroducer {

    public AuditableIntroducer() {}

    /**
     * Employee extends AuditableImpl, so we can add those new columns to our table.
     * */
    declare parents : ro.company.domain.Employee extends ro.company.domain.AuditableImpl;
}

/*TODO:
* Resolve all the warnings or errors that we get at run!
* Debug why with @Aspect, from package springaop, doesn't work!
* Create service for all the entities!
* Rename the functions to CRUD, from service!
* Clean up  the code!
* ...*/