package ro.company.service;

import org.springframework.stereotype.Service;
import ro.company.domain.Audit;
import ro.company.repository.AuditRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Cristian.Dumitru on 2/25/2015.
 */
@Service
//@Configurable
public class AuditServiceImpl implements AuditService {

    @Inject
    private AuditRepository auditRepository;

    @Override
    public Audit createAudit(Audit audit) {

        //return em.merge(audit);
        return auditRepository.saveAndFlush(audit);
    }

    @Override
    public Audit findFirstByObjectIdAndObjectType(Long objectId, String objectType) {

        return auditRepository.findFirstByObjectIdAndObjectType(objectId, objectType);
    }

    @Override
    public Audit findFirstByObjectId(Long objectId) {

        return auditRepository.findFirstByObjectId(objectId);
    }

    @Override
    public Audit findAuditByObjectIdAndAction(Long objectId, String action) {

        return auditRepository.findAuditByObjectIdAndAction(objectId, action);
    }

    @Override
    public Audit findAuditByObjectIdAndObjectTypeAndAction(Long objectId, String objectType, String action) {

        return auditRepository.findAuditByObjectIdAndObjectTypeAndAction(objectId, objectType, action);
    }


    @Override
    public List<Audit> findAllAudits() {

        return auditRepository.findAll();
    }

    @Override
    public void deleteAudit(Long id) {

        auditRepository.delete(id);

    }
}

