package nextstep.acceptance.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import nextstep.acceptance.support.CouponApi;

import static org.assertj.core.api.Assertions.assertThat;

public class CouponSteps {

    @Given("할인 금액이 {int}원인 정액 쿠폰 {string}(이)(가) 있다")
    public void 정액_쿠폰이_있다(int 할인_금액, String 코드) {
        assertThat(CouponApi.정액_쿠폰을_등록한다(코드, 할인_금액).statusCode()).as("쿠폰 등록 응답").isEqualTo(201);
    }

    @Given("할인율이 {int}%인 정률 쿠폰 {string}(이)(가) 있다")
    public void 정률_쿠폰이_있다(int 할인율, String 코드) {
        assertThat(CouponApi.정률_쿠폰을_등록한다(코드, 할인율).statusCode()).as("쿠폰 등록 응답").isEqualTo(201);
    }

    @Then("쿠폰 {string}(을)(를) 조회하면 할인 금액은 {int}원이다")
    public void 쿠폰_할인_금액(String 코드, int 할인_금액) {
        assertThat(조회한다(코드).jsonPath().getInt("amount")).as("쿠폰 \"" + 코드 + "\"의 할인 금액").isEqualTo(할인_금액);
    }

    @Then("쿠폰 {string}(을)(를) 조회하면 할인율은 {int}%이다")
    public void 쿠폰_할인율(String 코드, int 할인율) {
        assertThat(조회한다(코드).jsonPath().getInt("rate")).as("쿠폰 \"" + 코드 + "\"의 할인율").isEqualTo(할인율);
    }

    private ExtractableResponse<Response> 조회한다(String 코드) {
        ExtractableResponse<Response> response = CouponApi.조회한다(코드);
        assertThat(response.statusCode()).as("쿠폰 조회 응답").isEqualTo(200);
        return response;
    }
}
