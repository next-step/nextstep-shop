package nextstep.member.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nextstep.member.domain.Member;

@Getter
@AllArgsConstructor
public class MemberResponse {

    private Long id;
    private String name;
    private String grade;

    public static MemberResponse from(Member member) {
        return new MemberResponse(member.getId(), member.getName(), member.getGrade().name());
    }
}
