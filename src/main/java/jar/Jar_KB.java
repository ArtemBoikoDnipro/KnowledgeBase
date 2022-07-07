package jar;

/**
 * // TODO add some description
 *
 * @author Artem Boiko
 */
public class Jar_KB {
    public static void main(String[] args) {
        /*
        * Иногда JAR файл при запуске из консоли,
        * а не в IDE, не хочет запускаться,
        * либо уже в процессе работы вылетает ClassNotFound,
        * решение:
        *
File
Project Structure
Artifacts
+
Jar
from modules with dependencies
прописать Starter класс
!!! и link via manifest
а сам манифест должен находиться в
\src\main\resources\META-INF\MANIFEST.MF

а в манифесте должны быть все зависимости:

Manifest-Version: 1.0
Main-Class: com.foxminded.university.Main
Class-Path: thymeleaf-extras-java8time-3.0.4.RELEASE.jar spring-core-5.3
 .19.jar validation-api-2.0.1.Final.jar bootstrap-5.1.3.jar spring-tx-5.
 3.19.jar spring-boot-autoconfigure-2.6.7.jar jackson-databind-2.13.2.1.
 jar spring-boot-devtools-2.6.7.jar jackson-datatype-jsr310-2.13.2.jar s
 pringfox-core-2.9.2.jar istack-commons-runtime-3.0.12.jar thymeleaf-spr
 ing5-3.0.15.RELEASE.jar spring-boot-starter-tomcat-2.6.7.jar tomcat-emb
 ed-websocket-9.0.62.jar jackson-datatype-jdk8-2.13.2.jar jakarta.transa
 ction-api-1.3.3.jar spring-data-jpa-2.6.4.jar h2-2.1.212.jar commons-di
 gester-1.8.jar jandex-2.4.2.Final.jar popper.js-2.9.3.jar hibernate-cor
 e-5.6.8.Final.jar txw2-2.3.6.jar jakarta.ws.rs-api-2.1.6.jar spring-boo
 t-starter-aop-2.6.7.jar thymeleaf-extras-springsecurity5-3.0.4.RELEASE.
 jar spring-aspects-5.3.19.jar spring-boot-starter-thymeleaf-2.6.7.jar j
 ul-to-slf4j-1.7.36.jar snakeyaml-1.29.jar spring-webmvc-5.3.19.jar jaka
 rta.xml.bind-api-2.3.3.jar jakarta.persistence-api-2.2.3.jar spring-boo
 t-2.6.7.jar springfox-spring-web-2.9.2.jar springfox-swagger-ui-2.9.2.j
 ar spring-boot-starter-logging-2.6.7.jar springfox-spi-2.9.2.jar guava-
 20.0.jar spring-boot-starter-data-jpa-2.6.7.jar HikariCP-4.0.3.jar spri
 ng-boot-starter-2.6.7.jar spring-jdbc-5.3.19.jar jakarta.annotation-api
 -1.3.5.jar commons-validator-1.4.0.jar hibernate-validator-6.0.13.Final
 .jar spring-security-web-5.6.3.jar commons-beanutils-1.8.3.jar tomcat-e
 mbed-el-9.0.62.jar spring-data-commons-2.6.4.jar spring-security-config
 -5.6.3.jar slf4j-api-1.7.36.jar spring-boot-starter-security-2.6.7.jar
 unbescape-1.1.6.RELEASE.jar swagger-annotations-1.5.20.jar spring-boot-
 starter-jdbc-2.6.7.jar jakarta.activation-api-1.2.2.jar spring-security
 -crypto-5.6.3.jar attoparser-2.0.5.RELEASE.jar spring-expression-5.3.19
 .jar logback-classic-1.2.11.jar spring-plugin-core-1.2.0.RELEASE.jar an
 tlr-2.7.7.jar checker-qual-3.5.0.jar spring-context-5.3.19.jar jboss-lo
 gging-3.4.3.Final.jar springfox-swagger-common-2.9.2.jar hibernate-comm
 ons-annotations-5.1.2.Final.jar swagger-models-1.5.20.jar thymeleaf-3.0
 .15.RELEASE.jar log4j-api-2.17.2.jar tomcat-embed-core-9.0.62.jar sprin
 g-plugin-metadata-1.2.0.RELEASE.jar jaxb-runtime-2.3.6.jar spring-orm-5
 .3.19.jar log4j-to-slf4j-2.17.2.jar spring-aop-5.3.19.jar spring-boot-s
 tarter-web-2.6.7.jar byte-buddy-1.11.22.jar jackson-core-2.13.2.jar spr
 ing-boot-starter-json-2.6.7.jar spring-jcl-5.3.19.jar spring-web-5.3.19
 .jar jakarta.activation-1.2.2.jar springfox-schema-2.9.2.jar spring-bea
 ns-5.3.19.jar jackson-annotations-2.13.2.jar mapstruct-1.2.0.Final.jar
 aspectjweaver-1.9.7.jar logback-core-1.2.11.jar spring-security-core-5.
 6.3.jar postgresql-42.3.4.jar commons-logging-1.1.1.jar jackson-module-
 parameter-names-2.13.2.jar classmate-1.5.1.jar springfox-swagger2-2.9.2
 .jar


        * */
    }
}
