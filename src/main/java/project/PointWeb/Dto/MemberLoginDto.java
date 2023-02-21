package project.PointWeb.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberLoginDto {

    private String memberId;
    private Long memberPw;

}
