package nextstep.acceptance.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import nextstep.acceptance.support.ProductApi;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductSteps {

    /** 시나리오에 재고가 나오지 않는 주문은 재고 부족이 일어나지 않도록 넉넉하게 등록한다. */
    private static final int 넉넉한_재고 = 100;

    @Given("가격이 {int}원인 상품 {string}(이)(가) 있다")
    public void 상품이_있다(int 가격, String 이름) {
        assertThat(ProductApi.등록한다(이름, 가격, 넉넉한_재고).statusCode()).as("상품 등록 응답").isEqualTo(201);
    }

    @Then("상품 목록에서 {string}의 가격은 {int}원이다")
    public void 상품_가격(String 이름, int 가격) {
        Integer 조회한_가격 = ProductApi.이름으로_찾는다(이름, "price");
        assertThat(조회한_가격).as("상품 \"" + 이름 + "\"의 가격").isEqualTo(가격);
    }
}
