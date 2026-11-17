package nextstep.acceptance.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import nextstep.acceptance.support.MemberApi;
import nextstep.acceptance.support.ScenarioContext;

import static nextstep.acceptance.support.GradeNames.등급;
import static org.assertj.core.api.Assertions.assertThat;

/** 스텝 정의 객체는 시나리오마다 새로 만들어지므로 가입 응답을 필드에 둔다. */
public class MemberSteps {

    private final ScenarioContext context;

    private ExtractableResponse<Response> 가입_응답;

    public MemberSteps(ScenarioContext context) {
        this.context = context;
    }

    @When("방문자가 이름 {string}로 가입한다")
    public void 가입한다(String 이름) {
        가입_응답 = MemberApi.가입한다(이름);
    }

    @Given("등급이 {string}인 회원 {string}(이)(가) 있다")
    public void 등급이_있는_회원이_있다(String 등급, String 이름) {
        ExtractableResponse<Response> response = MemberApi.가입한다(이름);
        assertThat(response.statusCode()).as("가입 응답").isEqualTo(201);
        String 위치 = response.header("Location");
        assertThat(MemberApi.등급을_변경한다(위치, 등급(등급).name()).statusCode()).as("등급 변경 응답").isEqualTo(204);
        context.회원을_기억한다(이름, Long.valueOf(위치.substring(위치.lastIndexOf('/') + 1)));
    }

    @When("가입한 회원의 등급을 {string}로 바꾼다")
    public void 가입한_회원의_등급을_바꾼다(String 등급) {
        assertThat(가입_응답.statusCode()).as("가입 응답").isEqualTo(201);
        context.response = MemberApi.등급을_변경한다(가입_응답.header("Location"), 등급(등급).name());
    }

    @Then("가입한 회원을 조회하면 이름은 {string}이다")
    public void 가입한_회원의_이름(String 이름) {
        assertThat(가입한_회원을_조회한다().jsonPath().getString("name")).isEqualTo(이름);
    }

    @Then("가입한 회원을 조회하면 등급은 {string}이다")
    public void 가입한_회원의_등급(String 등급) {
        assertThat(가입한_회원을_조회한다().jsonPath().getString("grade")).isEqualTo(등급(등급).name());
    }

    private ExtractableResponse<Response> 가입한_회원을_조회한다() {
        assertThat(가입_응답.statusCode()).as("가입 응답").isEqualTo(201);
        ExtractableResponse<Response> response = MemberApi.조회한다(가입_응답.header("Location"));
        assertThat(response.statusCode()).as("조회 응답").isEqualTo(200);
        return response;
    }
}
