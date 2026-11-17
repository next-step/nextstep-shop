package nextstep.member.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @Test
    void 가입한_회원의_이름은_입력한_이름이다() {
        Member member = Member.join("철수");

        assertThat(member.getName()).isEqualTo("철수");
    }

    @Test
    void 가입한_회원의_등급은_일반이다() {
        Member member = Member.join("철수");

        assertThat(member.getGrade()).isEqualTo(Grade.NORMAL);
    }

    @Test
    void 등급을_바꾸면_바꾼_등급이_된다() {
        Member member = Member.join("철수");

        member.changeGrade(Grade.VIP);

        assertThat(member.getGrade()).isEqualTo(Grade.VIP);
    }
}
