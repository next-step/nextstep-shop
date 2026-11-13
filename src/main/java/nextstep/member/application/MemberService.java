package nextstep.member.application;

import lombok.RequiredArgsConstructor;
import nextstep.member.domain.Member;
import nextstep.member.infra.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(String name) {
        return memberRepository.save(Member.join(name)).getId();
    }

    public Member find(Long id) {
        return memberRepository.findById(id).orElseThrow();
    }
}
