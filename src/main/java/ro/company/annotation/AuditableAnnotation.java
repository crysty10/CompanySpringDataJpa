package ro.company.annotation;

import javax.persistence.Inheritance;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Cristian.Dumitru on 3/2/2015.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inheritance
public @interface AuditableAnnotation {
}
