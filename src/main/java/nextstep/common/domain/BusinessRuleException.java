package nextstep.common.domain;

/** 비즈니스 규칙 위반. 메시지는 사용자에게 거절 사유로 그대로 전달된다. */
public class BusinessRuleException extends RuntimeException {

    public BusinessRuleException(String message) {
        super(message);
    }
}
