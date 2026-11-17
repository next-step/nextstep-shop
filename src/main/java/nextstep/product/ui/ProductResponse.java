package nextstep.product.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nextstep.product.domain.Product;

@Getter
@AllArgsConstructor
public class ProductResponse {

    private Long id;
    private String name;
    private int price;
    private int stock;

    public static ProductResponse from(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getPrice(), product.getStock());
    }
}
