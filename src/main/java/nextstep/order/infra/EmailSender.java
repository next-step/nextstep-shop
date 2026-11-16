package nextstep.order.infra;

import lombok.extern.slf4j.Slf4j;

/** 이메일 발송. 실제 발송 대신 로그만 남긴다. */
@Slf4j
public class EmailSender {

    public static void send(String to, String content) {
        log.info("[이메일] 받는사람={}, 내용={}", to, content);
    }
}
