package nextstep.coupon.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nextstep.coupon.domain.Coupon;

@Getter
@AllArgsConstructor
public class CouponResponse {

    private Long id;
    private String code;
    private int type;
    private int amount;
    private int rate;

    public static CouponResponse from(Coupon coupon) {
        return new CouponResponse(coupon.getId(), coupon.getCode(), coupon.getType(), coupon.getAmount(), coupon.getRate());
    }
}
