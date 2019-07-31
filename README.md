# springBoot with Postgres

## Lesson-1 : GET method (hardcoded)

* Caused by: org.hibernate.AnnotationException: No identifier specified for entity: com.bts.epiphany.model.Product

* Check that you have the EL dependencies on the classpath, or use ParameterMessageInterpolator instead
javax.validation.ValidationException: HV000183: Unable to load 'javax.el.ExpressionFactory'. 

	<dependency>
		<groupId>javax.el</groupId>
		<artifactId>javax.el-api</artifactId>
		<version>2.2.4</version>
	</dependency>
		
	<!-- SpringBoot Web : @RestController -->   
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        

* java.net.BindException: Address already in use: bind

	server.port=8085

        
## Lesson-2 : GET method (DB), Run API ONLY on Eclipse
* You need an embedded Tomcat inside the Eclipse


	<!-- SpringBoot Web : @RestController 
	Task: Remove exclusions , Only keep this dependency
	-->   
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
	

## Lesson-3 : GET method (DB), Deploy war to JBOSS (Wildfly)
* {"WFLYCTL0080: Failed services" => {"jboss.deployment.unit.\"epiphany-0.0.1-SNAPSHOT.war\".undertow-deployment" => 
"java.lang.RuntimeException: java.lang.ClassCastException: org.apache.tomcat.websocket.server.WsServerContainer cannot be cast to io.undertow.websockets.jsr.ServerWebSocketContainer
    Caused by: java.lang.RuntimeException: java.lang.ClassCastException: org.apache.tomcat.websocket.server.WsServerContainer cannot be cast to io.undertow.websockets.jsr.ServerWebSocketContainer
    Caused by: java.lang.ClassCastException: org.apache.tomcat.websocket.server.WsServerContainer cannot be cast to io.undertow.websockets.jsr.ServerWebSocketContainer"}}

* You need to remove an embedded Tomcat from your war in order to deploy it to JBOSS

	<groupId>com.bts</groupId>
	<artifactId>epiphany</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
	        <exclusions>
	            <exclusion>
	                <groupId>org.apache.tomcat.embed</groupId>
	                <artifactId>tomcat-embed-websocket</artifactId>
	            </exclusion>
	        </exclusions>            
        </dependency>

* In order to run the Servlet on JBOSS
```java
@SpringBootApplication
public class App extends SpringBootServletInitializer{
```
## Lesson-4 : Enhance
