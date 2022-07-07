package spring.data.jpa;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

/**
 * // TODO add some description
 *
 * @author Artem Boiko
 */
@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class JPA_SpringBootTest_KB {
    public static void main(String[] args) {
        /*
        1) In Integration Tests (IT) all classes that need to get up application context,
           (@SpringBootTest annotation is present) they should be also
           @Transactional
           and maybe
           @ActiveProfiles("test")
           and with
           spring.jpa.hibernate.ddl-auto=create-drop
           in application.properties (inside test(!) resource folder)
         */
    }
}
