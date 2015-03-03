package ro.company.service;

import ro.company.domain.Audit;

import java.util.List;

/**
 * Created by Cristian.Dumitru on 2/25/2015.
 */
public interface AuditService {

    //CREATE OR UPDATE
    Audit createAudit(Audit audit);

    //READ
    Audit findByObjectIdAndObjectType(Long objectId, String objectType);
    Audit findFirstByObjectId(Long objectId);
    List<Audit> findAllAudits();

    //DELETE
    void deleteAudit(Long id);
}
