package nextstep.fake;

import nextstep.member.domain.Member;
import nextstep.member.infra.MemberRepository;

public class FakeMemberRepository extends FakeJpaRepository<Member> implements MemberRepository {
}
