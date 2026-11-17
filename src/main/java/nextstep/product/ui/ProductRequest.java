package nextstep.product.ui;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductRequest {

    private String name;
    private int price;
    private int stock;
}
