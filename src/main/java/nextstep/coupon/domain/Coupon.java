package nextstep.coupon.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private int type; // 1: 정액, 2: 정률

    private int amount;

    private int rate;

    public Coupon(String code, int type, int amount, int rate) {
        this.code = code;
        this.type = type;
        this.amount = amount;
        this.rate = rate;
    }
}
