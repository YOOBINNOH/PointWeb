package domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String member_id;

    private Long member_pw;

    private Long current_point;

    private Long give_point;

    private Long receive_point;

    private LocalDateTime login_date;

    private LocalDateTime register_date;

    private LocalDateTime resign_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "team_id")
    private Team team;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="resign_id")
    private Resign resign;



}
