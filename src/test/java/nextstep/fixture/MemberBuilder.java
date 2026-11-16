package nextstep.fixture;

import nextstep.member.domain.Grade;
import nextstep.member.domain.Member;

/**
 * 테스트용 회원 빌더. 검증에 필요한 값만 지정하고 나머지는 기본값을 쓴다.
 * <pre>
 * Member member = aMember().grade(Grade.GOLD).build();
 * </pre>
 */
public class MemberBuilder {

    private String name = "철수";
    private Grade grade = Grade.NORMAL;
    private String cardNo = "1234-5678-9012-3456";
    private String email = "member@nextstep.camp";

    public static MemberBuilder aMember() {
        return new MemberBuilder();
    }

    public MemberBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MemberBuilder grade(Grade grade) {
        this.grade = grade;
        return this;
    }

    public MemberBuilder cardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public MemberBuilder email(String email) {
        this.email = email;
        return this;
    }

    public Member build() {
        return new Member(name, grade, cardNo, email);
    }
}
