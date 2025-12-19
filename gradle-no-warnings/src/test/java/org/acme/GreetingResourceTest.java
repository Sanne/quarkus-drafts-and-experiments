package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

    @Test
    void testJvmFlags() {
        given()
                .when().get("/hello/flags")
                .then()
                .statusCode(200)
                .body(
                        allOf(
                                containsString("--add-opens=java.base/java.lang=ALL-UNNAMED"),
                                containsString("--add-opens=java.base/java.lang.invoke=ALL-UNNAMED"),
                                containsString("--add-exports=java.base/jdk.internal.module=ALL-UNNAMED"),
                                containsString("-Djava.util.logging.manager=org.jboss.logmanager.LogManager"),
                                containsString("-DsettingSomething=ToBlah")
                        )
                );
    }

}