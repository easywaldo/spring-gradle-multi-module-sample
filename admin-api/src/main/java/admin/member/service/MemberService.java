package admin.member.service;

import domain.member.entity.Member;
import domain.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String getSample() {
        return "admin-sample-member";
    }

    @Transactional
    public Long registerMember(String userId) {
        var member = new Member(userId);
        var result = this.memberRepository.save(member);
        return result.getSeqNo();
    }

    @Transactional(readOnly = true)
    public Member findMember(Long memberSeq) {
        return this.memberRepository.findById(memberSeq).orElse(Member.builder().build());
    }
}
