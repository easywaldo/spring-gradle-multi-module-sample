package domain.member.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity(name = "member")
@Table(name="domain.member")
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
}
