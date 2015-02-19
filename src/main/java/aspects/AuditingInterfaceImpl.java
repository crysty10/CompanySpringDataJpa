package aspects;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by Cristian.Dumitru on 2/18/2015.
 */
@Component
public class AuditingInterfaceImpl implements AuditingInterface {

    private LocalDateTime createDateTime;
    private LocalDateTime modifiedDateTime;

    @Override
    public LocalDateTime getModifiedDateTime() {

        return modifiedDateTime;
    }

    @Override
    public void setModifiedDateTime(LocalDateTime localDateTime) {

        this.modifiedDateTime = localDateTime;
    }

    @Override
    public LocalDateTime getCreatedDateTime() {

        return createDateTime;
    }

    @Override
    public void setCreatedDateTime(LocalDateTime localDateTime) {

        this.createDateTime = localDateTime;
    }

    //@Pointcut("execution(* repository.EmployeeRepository.save(..)) && args(localDateTime)")
    //private void pointcutSave(LocalDateTime localDateTime) {}
}