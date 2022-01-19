package domain.member.controller;

import domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController(value = "member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/member/sample")
    public Mono<ResponseEntity<?>> getSampleMember() {
        return Mono.just(ResponseEntity.ok("hello sample domain.member!!"));
    }

    @GetMapping(value = "/member/register/{userId}")
    public Mono<ResponseEntity<?>> registerMember(@PathVariable String userId) {
        var registeredMemberSeq = this.memberService.registerMember(userId);
        return Mono.just(
            ResponseEntity.created(
                URI.create(String.format("/member/%s", registeredMemberSeq)))
                .body(String.format("member registered %s", registeredMemberSeq)));
    }

    @GetMapping(value = "/member/{memberSeq}")
    public Mono<ResponseEntity<?>> findMember(@PathVariable Long memberSeq) {
        return Mono.just(
            ResponseEntity.ok(this.memberService.findMember(memberSeq)));
    }
}
