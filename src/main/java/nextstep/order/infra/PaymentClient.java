package nextstep.order.infra;

import lombok.extern.slf4j.Slf4j;

/** 외부 결제 시스템 호출. 실제 연동 대신 로그만 남긴다. */
@Slf4j
public class PaymentClient {

    public static void pay(String cardNo, int amount) {
        log.info("[결제] 카드번호={}, 금액={}", cardNo, amount);
    }
}
