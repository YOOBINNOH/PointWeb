package domain;

import jakarta.persistence.*;

@Entity
public class Resign {

    @Id @GeneratedValue
    private Long resign_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;
}
