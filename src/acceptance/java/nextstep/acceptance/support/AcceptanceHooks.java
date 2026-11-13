package nextstep.acceptance.support;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;

public class AcceptanceHooks {

    @LocalServerPort
    int port;

    @Autowired
    DatabaseCleaner databaseCleaner;

    @Before
    public void setUp() {
        RestAssured.port = port;
        databaseCleaner.clean();
    }
}
