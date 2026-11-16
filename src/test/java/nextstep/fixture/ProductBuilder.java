package nextstep.fixture;

import nextstep.product.domain.Product;

/**
 * 테스트용 상품 빌더.
 * <pre>
 * Product coat = aProduct().name("코트").price(60_000).build();
 * </pre>
 */
public class ProductBuilder {

    private String name = "티셔츠";
    private int price = 10_000;
    private int stock = 100;

    public static ProductBuilder aProduct() {
        return new ProductBuilder();
    }

    public ProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder price(int price) {
        this.price = price;
        return this;
    }

    public ProductBuilder stock(int stock) {
        this.stock = stock;
        return this;
    }

    public Product build() {
        return new Product(name, price, stock);
    }
}
