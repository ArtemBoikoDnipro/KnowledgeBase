package crypt;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * // TODO add some description
 *
 * @author Artem Boiko
 */
public class BCrypt_KB {
    public static void main(String[] args) {
        /*
        for salt generation
         */
        BCrypt.gensalt();
    }
}
