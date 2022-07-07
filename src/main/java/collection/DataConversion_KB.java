package collection;

import core.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * // TODO add some description
 *
 * @author Artem Boiko
 */
public class DataConversion_KB {
    private static final Logger logger = LogManager.getLogger(DataConversion_KB.class);

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        User user1 = new User(1, "name-1", "email-1");
        User user2 = new User(2, "name-2", "email-2");
        User user3 = new User(3, "name-3", "email-3");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        Map<String, User> usersByEmail = convertInShortWay(userList);
        usersByEmail.forEach((email, user) -> logger.debug("e-mail = " + email + "user = " + user));

        boolean isPresent = containsOnce(userList, new User(1, "name-1", "email-1"));
        logger.debug("isPresent = {}", isPresent);
    }

    public static Map<String, User> convertInShortWay(List<User> list) {
        return list.stream().collect(Collectors.toMap(User::getEmail, user -> user));
    }

    public static Map<String, User> convertInLongWay(List<User> list) {
        Map<String, User> usersByEmail = new HashMap<>();
        list.forEach(user -> usersByEmail.put(user.getEmail(), user));
        return usersByEmail;
    }

    public static boolean containsOnce(List<User> list, User user) {
        return list.stream().filter(u -> u.equals(user)).count() == 1;
    }
}
