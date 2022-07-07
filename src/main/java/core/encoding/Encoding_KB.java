package core.encoding;

import java.util.Base64;

import static logging.Logging_KB.log;

/**
 * Base64 encoding/decoding.
 *
 * @author Artem Boiko
 */
public class Encoding_KB {
    public static void main(String[] args) {
        String input = "Some input string.";
        log("input", input);

        String encodeMessage = encode(input);
        log("encodeMessage", encodeMessage);

        String decodedMessage = decode(encodeMessage);
        log("decodedMessage", decodedMessage);
    }

    /**
     * https://www.baeldung.com/java-base64-encode-and-decode
     */
    public static String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    /**
     * https://www.baeldung.com/java-base64-encode-and-decode
     */
    public static String decode(String message) {
        byte[] decodedBytes = Base64.getDecoder().decode(message);
        return new String(decodedBytes);
    }
}
