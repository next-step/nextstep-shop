package nextstep.coupon.ui;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CouponRequest {

    private String code;
    private int type;
    private int amount;
    private int rate;
}
