package nextstep.acceptance.support;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;

public final class ProductApi {

    private ProductApi() {
    }

    public static ExtractableResponse<Response> 등록한다(String 이름, int 가격, int 재고) {
        return given().contentType(JSON).body(Map.of("name", 이름, "price", 가격, "stock", 재고))
                .when().post("/products")
                .then().extract();
    }

    public static ExtractableResponse<Response> 목록을_조회한다() {
        return given()
                .when().get("/products")
                .then().extract();
    }

    /** 상품 목록에서 이름이 같은 상품의 필드 값을 찾는다. 없으면 null. */
    public static <T> T 이름으로_찾는다(String 이름, String 필드) {
        ExtractableResponse<Response> response = 목록을_조회한다();
        assertThat(response.statusCode()).as("상품 목록 응답").isEqualTo(200);
        return response.jsonPath().get("find { it.name == '" + 이름 + "' }." + 필드);
    }

    public static Long 이름으로_id를_찾는다(String 이름) {
        Number id = 이름으로_찾는다(이름, "id");
        assertThat(id).as("상품 \"" + 이름 + "\"").isNotNull();
        return id.longValue();
    }
}
