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

        return auditRepository.save(audit);
    }

    @Override
    public Audit findByObjectIdAndObjectType(Long objectId, String objectType) {

        return auditRepository.findByObjectIdAndObjectType(objectId, objectType);
    }

    @Override
    public Audit findFirstByObjectId(Long objectId) {

        return auditRepository.findFirstByObjectId(objectId);
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

