package troubleshooting;

/**
 * // TODO add some description
 *
 * @author Artem Boiko
 */
public class Main {
    /**
     *     Address localhost:8080 is already in use
     *
     *     https://stackoverflow.com/questions/38986910/intellij-idea-address-localhost1099-is-already-in-use
     *
     *     cmd as admin
     *     netsh interface ipv4 show excludedportrange protocol=tcp
     *     net stop winnat
     *
     */
}
