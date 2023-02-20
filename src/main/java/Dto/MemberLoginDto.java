package Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberLoginDto {

    private String member_id;
    private Long member_pw;

}
