package ro.company.repository;

import org.springframework.stereotype.Repository;
import ro.company.domain.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Cristian.Dumitru on 2/20/2015.
 */
@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {

    Audit findByObjectId(Long objectId);
}