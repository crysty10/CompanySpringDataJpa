package repository;

import domain.DateRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Cristian.Dumitru on 2/19/2015.
 */
@Repository
public interface DateRegistrationRepository
        extends JpaRepository<DateRegistration, Long> {

        public DateRegistration findByObjectId(Long object_id);
}
