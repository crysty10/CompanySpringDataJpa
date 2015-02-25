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