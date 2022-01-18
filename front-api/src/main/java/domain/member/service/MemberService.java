package domain.member.service;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public Long getSampleMember() {
        return 999L;
    }

    /*private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long registerMember(String userId) {
        //var member = new Member(userId);
       // var result = this.memberRepository.save(Member.builder().userId(userId).build());
        //return memberRepository.save(member).getSeqNo();
        return 0L;
    }*/
}
