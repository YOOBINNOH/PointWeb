package project.PointWeb.Domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Resign {

    @Id @GeneratedValue
    private Long resign_id;

    private String member_id;

    private LocalDateTime resign_date;


    public Resign(String member_id, LocalDateTime resign_date){
        this.member_id = member_id;
        this.resign_date = resign_date;
    }



}
