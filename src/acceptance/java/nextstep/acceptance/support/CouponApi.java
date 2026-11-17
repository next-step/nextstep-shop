package nextstep.acceptance.support;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public final class CouponApi {

    /** Coupon.type 값. 1: 정액, 2: 정률 */
    private static final int 정액 = 1;
    private static final int 정률 = 2;

    private CouponApi() {
    }

    public static ExtractableResponse<Response> 정액_쿠폰을_등록한다(String 코드, int 할인_금액) {
        return 등록한다(Map.of("code", 코드, "type", 정액, "amount", 할인_금액, "rate", 0));
    }

    public static ExtractableResponse<Response> 정률_쿠폰을_등록한다(String 코드, int 할인율) {
        return 등록한다(Map.of("code", 코드, "type", 정률, "amount", 0, "rate", 할인율));
    }

    public static ExtractableResponse<Response> 조회한다(String 코드) {
        return given()
                .when().get("/coupons/{code}", 코드)
                .then().extract();
    }

    private static ExtractableResponse<Response> 등록한다(Map<String, Object> body) {
        return given().contentType(JSON).body(body)
                .when().post("/coupons")
                .then().extract();
    }
}
