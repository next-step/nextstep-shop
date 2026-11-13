package nextstep.acceptance.support;

import io.cucumber.spring.ScenarioScope;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

/** 한 시나리오 안에서 스텝끼리 상태를 공유한다. 시나리오마다 새로 만들어진다. */
@Component
@ScenarioScope
public class ScenarioContext {

    public ExtractableResponse<Response> response;
}
