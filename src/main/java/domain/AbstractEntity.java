package domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.domain.AuditorAware;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

/**
 * Created by Cristian.Dumitru on 2/18/2015.
 */
public class AbstractEntity {

    @Id
    @GeneratedValue
    protected Long id;

    @CreatedDate
    protected ZonedDateTime createDateTime;

    @LastModifiedDate
    protected ZonedDateTime modifiedDateTime;

    public ZonedDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(ZonedDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public ZonedDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(ZonedDateTime modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }
}
