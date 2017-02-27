package reflect;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(value = ElementType.FIELD )
@Retention(value = RetentionPolicy.RUNTIME)
public @interface StorageEntity {
	String value();
}
