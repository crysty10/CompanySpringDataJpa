package ro.company.service;

import ro.company.domain.Audit;

/**
 * Created by Cristian.Dumitru on 2/25/2015.
 */
public interface AuditService {

    Audit createAudit(Audit audit);

    Audit findAuditById(Long id);
}
