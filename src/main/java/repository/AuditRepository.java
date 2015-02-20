package repository;

import domain.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Cristian.Dumitru on 2/20/2015.
 */
public interface AuditRepository extends JpaRepository<Audit, Long> {

    public Audit findByObjectId(Long objectId);
}
