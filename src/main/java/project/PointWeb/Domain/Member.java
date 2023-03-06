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

    // 로그인 시 로그인 date 최신화

    public void update_Login_date(LocalDateTime login_date) {
        this.login_date = login_date;
    }

    // 로그인 시 점수 올리기

    public void update_current_point() {
        this.current_point += 100L;
    }

    // 회원 팀 번호 변경

    public void change_teamId(Long teamId) {
        this.teamId = teamId;
    }

    // 포인트 지급
    public void add_point(Long add_point){
        this.current_point += add_point;
    }

    // 포인트 차감
    public void minus_point(Long minus_point){

        if((this.current_point - minus_point)>=0L){
            this.current_point -= minus_point;
        }
        else{
            this.current_point = 0L;
        }
    }

    // 기부 포인트 추가
    public void give_point(Long give_point){
        this.give_point+=give_point;
    }

    // 받은 포인트 추가
    public void receive_point(Long receive_point){
        this.receive_point += receive_point;
    }


}
