package com.mobidev.pdsl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PdslApplication extends SpringBootServletInitializer {

//    @Autowired
//    PropertiesUtils propertiesUtils;
//
//    @Value("${spring.datasource.url}")
//    private String springDatasourceUrl;
//
//    @Value("${spring.datasource.username}")
//    private String springDatasourceUsername;
//
//    @Value("${spring.datasource.password}")
//    private String springDatasourcePassword;
//
//    @Value("${spring.jpa.properties.hibernate.dialect}")
//    private String springJpaPropertiesHibernateDialect;
//
//    @Value("${spring.jpa.hibernate.ddl-auto}")
//    private String springJpaHibernateDdlAuto;
//
//    @Value("${server.address}")
//    private String serverAddress;
//
//    @Value("${server.port}")
//    private String serverPort;
//
//    @Value("${server.use-forward-headers}")
//    private String serverUseForwardHeaders;
//
//    @Value("${env.name}")
//    private String envName;

    public static void main(String[] args) {
//        propertiesUtils.initProperties();
        SpringApplication.run(PdslApplication.class, args);

//        ConfigurableApplicationContext context = SpringApplication.run(PdslApplication.class, args);
//        PdslApplication pdslApplication = context.getBean(PdslApplication.class);
//        printEnvironmentsProperties(pdslApplication);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PdslApplication.class);
    }


//    private static void printEnvironmentsProperties(PdslApplication pdslApplication) {
//        String stringBuilder = "Properties Files ......\n" + "env.name" + " : " + pdslApplication.envName + "\n" +
//                "spring.datasource.url" + " : " + pdslApplication.springDatasourceUrl + "\n" +
//                "spring.datasource.username" + " : " + pdslApplication.springDatasourceUsername + "\n" +
//                "spring.datasource.password" + " : " + pdslApplication.springDatasourcePassword + "\n" +
//                "spring.jpa.properties.hibernate.dialect" + " : " + pdslApplication.springJpaPropertiesHibernateDialect + "\n" +
//                "spring.jpa.hibernate.ddl-auto" + " : " + pdslApplication.springJpaHibernateDdlAuto + "\n" +
//                "server.address" + " : " + pdslApplication.serverAddress + "\n" +
//                "server.port" + " : " + pdslApplication.serverPort + "\n" +
//                "server.use-forward-headers" + " : " + pdslApplication.serverUseForwardHeaders + "\n";
//
//        System.out.println(stringBuilder);
//    }
}
