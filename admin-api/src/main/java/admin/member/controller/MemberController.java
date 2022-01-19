package admin.member.controller;

import admin.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/admin/member/sample")
    public Mono<ResponseEntity<?>> getSample() {
        return Mono.just(ResponseEntity.ok(this.memberService.getSample()));
    }

    @GetMapping(value = "/admin/member/register/{userId}")
    public Mono<ResponseEntity<?>> registerMember(@PathVariable String userId) {
        var registeredMemberSeq = this.memberService.registerMember(userId);
        return Mono.just(
            ResponseEntity.created(
                URI.create(String.format("/member/%s", registeredMemberSeq)))
                .body(String.format("member registered %s", registeredMemberSeq)));
    }

    @GetMapping(value = "/admin/member/{memberSeq}")
    public Mono<ResponseEntity<?>> findMember(@PathVariable Long memberSeq) {
        return Mono.just(
            ResponseEntity.ok(this.memberService.findMember(memberSeq)));
    }
}
