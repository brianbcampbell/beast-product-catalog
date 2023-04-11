package beast.cart._testdata;

import org.flywaydb.core.Flyway;
import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MySQLContainer;

@Disabled("these 'tests' are dev utilities and not intended to be run as tests")
//@ExtendWith(SpringExtension.class)
public class JooqRegen {

    private static final String DB_NAME = "product_catalog";

    @Disabled
    @Test
    public void runFlyway() throws Exception {
        // to ONLY update localhost - no container, no jooq
        migrate("jdbc:mysql://localhost:3306", "root", "root");
    }

    @Test
    public void jooqRegen() throws Exception {

        System.out.println("================ CREATE AN EMPTY DB FROM A DOCKER CONTAINER ==========================================================");
        try (MySQLContainer mysql = new MySQLContainer("mysql:8.0.32")
                             // .withConfigurationOverride("init.sql");
                             //.withUsername("root")
                             //.withPassword("test")
                             .withDatabaseName(DB_NAME)
        ) {
            System.out.println("================ START THE DB CONTAINER ==========================================================");
            mysql.start();

            System.out.println("================ PERFORM FLYWAY DB MIGRATION ===============================================");
            migrate(mysql.getJdbcUrl(), "root", "test");

            System.out.println("================ REGEN JOOQ CLASSES ==========================================================");
            regen(mysql);


        } finally {
        }
    }

    private static void migrate(String jdbcurl, String username, String password) {
        Flyway flyway = Flyway.configure().dataSource(jdbcurl, username, password).load();
        flyway.migrate();
    }

    private static void regen(MySQLContainer mysql) throws Exception {

        org.jooq.meta.jaxb.Configuration configuration =
                new org.jooq.meta.jaxb.Configuration()
                        .withJdbc(
                                new Jdbc()
                                        .withDriver(mysql.getDriverClassName())
                                        .withUrl(mysql.getJdbcUrl())
//                                        .withSchema(DB_NAME)
                                        .withUser(mysql.getUsername())
                                        .withPassword(mysql.getPassword()))
                        .withGenerator(
                                new Generator()
                                        .withGenerate(new Generate().withJavaTimeTypes(true).withGeneratedAnnotation(false))
                                        .withDatabase(
                                                new Database()
                                                        // .withForcedTypes(
                                                        //  new ForcedType()
                                                        //    .withUserType(io.vertx.core.json.JsonObject)
                                                        //    .withBinding(ObjectToJsonObjectBinding)
                                                        //    .withExpression(".*")
                                                        //    .withTypes("(?i)JSON"))
                                                        .withName("org.jooq.meta.mysql.MySQLDatabase")
                                                        .withIncludes(".*")
                                                        .withExcludes("flyway_schema_history")
                                                        .withInputSchema(DB_NAME)
                                        )
                                        .withTarget(
                                                new Target()
                                                        .withPackageName("generated")
                                                        .withDirectory("./src/main/java")));
        GenerationTool.generate(configuration);
    }
}

