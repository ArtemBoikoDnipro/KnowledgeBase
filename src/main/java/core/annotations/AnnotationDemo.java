package core.annotations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.annotation.Annotation;

/**
 * Make some actions on annotation.
 *
 * @author Artem Boiko
 */
public class AnnotationDemo {
    private static final Logger logger = LogManager.getLogger(AnnotationDemo.class);

    public static void main(String[] args) {
        showAllAnnotations();
        showSpecificAnnotation();
    }

    private static void showAllAnnotations() {
        Annotation[] annotations = AnnotatedClass.class.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            logger.info("Annotation: {}", annotation);
        }
    }

    private static void showSpecificAnnotation() {
        SomeAnnotation specificAnnotation = AnnotatedClass.class.getDeclaredAnnotation(SomeAnnotation.class);
        String value = specificAnnotation.value();
        Level complexityLevel = specificAnnotation.complexityLevel();
        logger.info("value: {}", value);
        logger.info("complexityLevel: {}", complexityLevel);
    }
}
