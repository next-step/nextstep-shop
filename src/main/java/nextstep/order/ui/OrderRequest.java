package nextstep.order.ui;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderRequest {

    private Long memberId;
    private List<Long> productIds;
    private List<Integer> quantities;
    private String couponCode;
}
