package core.annotations;

/**
 * Annotations.
 *
 * @author Artem Boiko
 */
@SomeAnnotation(value = "some value",           /* required - more than one method is declared */
                complexityLevel = Level.MEDIUM) /* not required - default value is set */
public class AnnotatedClass {
}
