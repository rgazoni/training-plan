package io.spring.training.boot.trainingplan.internal.config;

import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.migration.JavaMigration;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class FlywayInit {

    private final Flyway flyway;

    public FlywayInit(DataSource dataSource, ApplicationContext applicationContext) {
        this.flyway = Flyway.configure()
                .dataSource(dataSource)
                .javaMigrations(applicationContext.getBeansOfType(JavaMigration.class).values().toArray(new JavaMigration[0]))
                .load();
    }

    @PostConstruct
    public void migrate() {
        flyway.migrate();
    }

}
