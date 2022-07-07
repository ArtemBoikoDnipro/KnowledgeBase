package glassfish;

/**
 * // TODO add some description
 *
 * @author Artem Boiko
 */
public class JAX_RS_KB {
    /*
     * зависимости для поднятие JAX_RS под Jersey+GlassFish
     * https://russianblogs.com/article/76251217494/
     * (но это для старой версии servlet api!!!)
     *
     * простой пример
     * https://www.baeldung.com/jax-rs-spec-and-implementations
     *
     * туториал Developing RESTful APIs with JAX-RS от JavaBrains
     * https://www.youtube.com/playlist?list=PLqq-6Pq4lTTZh5U8RbdXq0WaYvZBz2rbn
     *
     * new project
     * java enterprice
     * rest service (jax-rs)
     *
     * но вот только из зависимостей нужны лишь:
     *
     *   <properties>
           <jersey.version>2.34</jersey.version>
         </properties>
        <dependency>
            <groupId>org.glassfish.jersey.containers</groupId>
            <artifactId>jersey-container-servlet</artifactId>
            <version>${jersey.version}</version>
        </dependency>
        <dependency>
            <groupId>org.glassfish.jersey.media</groupId>
            <artifactId>jersey-media-json-jackson</artifactId>
            <version>${jersey.version}</version>
        </dependency>
        <dependency>
            <groupId>org.glassfish.jersey.inject</groupId>
            <artifactId>jersey-cdi2-se</artifactId>
            <version>${jersey.version}</version>
        </dependency>
     *
     * не запускался, пока не положил в
     * \src\main\resources\META-INF
     * файл beans.xml
     */
}
