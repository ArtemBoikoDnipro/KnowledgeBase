package spring.security;

/**
 * // TODO add some description
 *
 * @author Artem Boiko
 */
public class Security_KB {
    /**
     * когда работаем с spring boot 2.7.0 и новее, то websecurityconfigureradapter deprecated
     *
     * https://www.codejava.net/frameworks/spring-boot/fix-websecurityconfigureradapter-deprecated
     *
     * configure(HttpSecurity http)
     * configure(WebSecurity web)
     *
     * change the methods above into:
     *
     * SecurityFilterChain filterChain(HttpSecurity http)
     * WebSecurityCustomizer webSecurityCustomizer()
     */
}
