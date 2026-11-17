package nextstep.acceptance.support;

import nextstep.member.domain.Grade;

import java.util.Map;

/** 시나리오의 등급 이름(일반, VIP 등)을 Grade로 바꾼다. */
public final class GradeNames {

    private static final Map<String, Grade> 등급들 = Map.of(
            "일반", Grade.NORMAL,
            "실버", Grade.SILVER,
            "골드", Grade.GOLD,
            "VIP", Grade.VIP);

    private GradeNames() {
    }

    public static Grade 등급(String 이름) {
        Grade grade = 등급들.get(이름);
        if (grade == null) {
            throw new IllegalArgumentException("알 수 없는 등급: " + 이름);
        }
        return grade;
    }
}
