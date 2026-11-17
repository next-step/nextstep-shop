package nextstep.coupon.ui;

import lombok.RequiredArgsConstructor;
import nextstep.coupon.application.CouponService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody CouponRequest request) {
        String code = couponService.register(
                request.getCode(), request.getType(), request.getAmount(), request.getRate());
        return ResponseEntity.created(URI.create("/coupons/" + code)).build();
    }

    @GetMapping("/{code}")
    public CouponResponse find(@PathVariable String code) {
        return CouponResponse.from(couponService.find(code));
    }
}
