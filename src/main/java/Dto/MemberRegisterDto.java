package Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberRegisterDto {

    private String member_id;
    private Long member_pw;
    private Long team_id;

}
