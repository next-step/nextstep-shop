package nextstep.coupon.application;

import lombok.RequiredArgsConstructor;
import nextstep.coupon.domain.Coupon;
import nextstep.coupon.infra.CouponRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    @Transactional
    public String register(String code, int type, int amount, int rate) {
        return couponRepository.save(new Coupon(code, type, amount, rate)).getCode();
    }

    public Coupon find(String code) {
        return couponRepository.findByCode(code);
    }
}
