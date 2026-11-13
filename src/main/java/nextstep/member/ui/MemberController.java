package nextstep.member.ui;

import lombok.RequiredArgsConstructor;
import nextstep.member.application.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Void> join(@RequestBody MemberRequest request) {
        Long id = memberService.join(request.getName());
        return ResponseEntity.created(URI.create("/members/" + id)).build();
    }

    @GetMapping("/{id}")
    public MemberResponse find(@PathVariable Long id) {
        return MemberResponse.from(memberService.find(id));
    }
}
