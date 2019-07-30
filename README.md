# springBoot with Postgres

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

        