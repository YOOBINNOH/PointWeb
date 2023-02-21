package project.PointWeb.Domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member{

    @Id @GeneratedValue
    private Long id;

    private String memberId;

    private Long memberPw;

    private Long current_point;

    private Long give_point;

    private Long receive_point;

    private LocalDateTime login_date;

    private LocalDateTime register_date;

    private LocalDateTime resign_date;

    private Long teamId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name= "teamId")
//    private Team team;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="resign_id")
//    private Resign resign;




    // 회원가입
    public Member(String memberId, Long memberPw, Long teamId,LocalDateTime register_date ) {

        this.memberId = memberId;
        this.memberPw = memberPw;
        this.teamId = teamId;
        this.register_date = register_date;

        this.current_point = 1000L;
        this.give_point = 0L;
        this.receive_point = 0L;
        this.login_date = register_date;
        this.resign_date = null;


    }

    public void update_Login_date(LocalDateTime login_date) {
        this.login_date = login_date;
    }



}
