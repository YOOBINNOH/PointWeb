package project.PointWeb.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberLoginDto {

    @NotBlank(message = "아이디 입력을 하세요.")
    private String memberId;

    @NotNull(message = "비밀번호 입력을 하세요.")
    private Long memberPw;

}
