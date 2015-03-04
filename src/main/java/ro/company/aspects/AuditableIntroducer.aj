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
    declare parents : (@AuditableAnnotation *) extends AuditableImpl;
}