package aspects;

import domain.*;

/**
 * Created by Cristian.Dumitru on 2/23/2015.
 */
public aspect AuditableIntroducer {

    public AuditableIntroducer() {}

    declare parents : Car extends AuditableImpl;
}
