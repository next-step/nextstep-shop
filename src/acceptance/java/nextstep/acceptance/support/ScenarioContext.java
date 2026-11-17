package nextstep.acceptance.support;

import io.cucumber.spring.ScenarioScope;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/** 한 시나리오 안에서 스텝끼리 상태를 공유한다. 시나리오마다 새로 만들어진다. */
@Component
@ScenarioScope
public class ScenarioContext {

    public ExtractableResponse<Response> response;

    private final Map<String, Long> 회원들 = new HashMap<>();

    public void 회원을_기억한다(String 이름, Long id) {
        회원들.put(이름, id);
    }

    public Long 회원(String 이름) {
        Long id = 회원들.get(이름);
        assertThat(id).as("회원 \"" + 이름 + "\"").isNotNull();
        return id;
    }
}
