package ro.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import ro.company.domain.Audit;
import ro.company.repository.AuditRepository;

import javax.inject.Inject;

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
    public Audit findAuditById(Long id) {

        return auditRepository.findByObjectId(id);
    }
}
