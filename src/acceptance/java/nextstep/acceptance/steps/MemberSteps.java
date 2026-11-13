package nextstep.acceptance.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import nextstep.acceptance.support.MemberApi;
import nextstep.acceptance.support.ScenarioContext;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberSteps {

    @Autowired
    ScenarioContext context;

    @When("방문자가 이름 {string}로 가입한다")
    public void 가입한다(String 이름) {
        context.response = MemberApi.가입한다(이름);
    }

    @Then("가입한 회원을 조회하면 이름은 {string}이다")
    public void 가입한_회원의_이름(String 이름) {
        assertThat(가입한_회원을_조회한다().jsonPath().getString("name")).isEqualTo(이름);
    }

    @Then("가입한 회원을 조회하면 등급은 일반이다")
    public void 가입한_회원의_등급은_일반() {
        assertThat(가입한_회원을_조회한다().jsonPath().getString("grade")).isEqualTo("NORMAL");
    }

    private ExtractableResponse<Response> 가입한_회원을_조회한다() {
        assertThat(context.response.statusCode()).as("가입 응답").isEqualTo(201);
        ExtractableResponse<Response> response = MemberApi.조회한다(context.response.header("Location"));
        assertThat(response.statusCode()).as("조회 응답").isEqualTo(200);
        return response;
    }
}
