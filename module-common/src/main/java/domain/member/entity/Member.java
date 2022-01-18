package domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity(name = "member")
@Table(name="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_seq")
    private Long seqNo;

    @Column(name = "user_id")
    private String userId;

    public Member(String userId) {
        this.userId = userId;
    }

    @Builder
    public Member(Long seqNo, String userId) {
        this.seqNo = seqNo;
        this.userId = userId;
    }
}
