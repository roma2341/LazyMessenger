package com.softgroup.common.database.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zigza on 31.03.2017.
 */
@Configuration
@ComponentScan(basePackages = {"com.softgroup.common.database"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Configuration.class})
)
public class MigrationConfig {
    @Autowired
    DataSource dataSource;

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db.changelog-master.xml");
        liquibase.setDataSource(dataSource);
        liquibase.setDefaultSchema("Messenger");
        liquibase.setContexts("test,dev,prod");
//        liquibase.setIgnoreClasspathPrefix(true);
//        ChangeLogHistoryServiceFactory.getInstance().reset();
        liquibase.setDropFirst(false);
        liquibase.setShouldRun(true);
        Map params = new HashMap<>();
        params.put("verbose", "true");
        liquibase.setChangeLogParameters(params);
        return liquibase;
    }
}
