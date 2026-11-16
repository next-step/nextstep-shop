package nextstep.member.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    private String cardNo;

    private String email;

    public Member(String name, Grade grade, String cardNo, String email) {
        this.name = name;
        this.grade = grade;
        this.cardNo = cardNo;
        this.email = email;
    }

    public static Member join(String name) {
        return new Member(name, Grade.NORMAL, null, null);
    }
}
