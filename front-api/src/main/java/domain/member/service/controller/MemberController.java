package domain.member.service.controller;

import domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/get/sample")
    public String getSampleMember() {
        return "hello sample domain.member!!";
    }

    @GetMapping(value = "/register/{userId}")
    public Long registerMember(@PathVariable String userId) {
        return memberService.getSampleMember();
        //return this.memberService.registerMember(userId);
    }
}
