package nextstep.acceptance.support;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public final class MemberApi {

    private MemberApi() {
    }

    public static ExtractableResponse<Response> 가입한다(String 이름) {
        return given().contentType(JSON).body(Map.of("name", 이름))
                .when().post("/members")
                .then().extract();
    }

    public static ExtractableResponse<Response> 조회한다(String 위치) {
        return given()
                .when().get(위치)
                .then().extract();
    }
}
