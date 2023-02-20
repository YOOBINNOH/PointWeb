package Domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member{

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

    private Long team_id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name= "team_id")
//    private Team team;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="resign_id")
//    private Resign resign;



}
