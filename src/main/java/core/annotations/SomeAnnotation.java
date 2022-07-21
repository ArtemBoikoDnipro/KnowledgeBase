package core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation @interface.
 *
 * @author Artem Boiko
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SomeAnnotation {
    String value();

    Level complexityLevel() default Level.EASY;
}
