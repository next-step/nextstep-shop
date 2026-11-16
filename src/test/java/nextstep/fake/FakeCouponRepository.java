package nextstep.fake;

import nextstep.coupon.domain.Coupon;
import nextstep.coupon.infra.CouponRepository;

public class FakeCouponRepository extends FakeJpaRepository<Coupon> implements CouponRepository {

    /** 실제 리포지토리처럼 없으면 null을 돌려준다. */
    @Override
    public Coupon findByCode(String code) {
        return findAllBy(coupon -> coupon.getCode().equals(code)).stream()
                .findFirst()
                .orElse(null);
    }
}
