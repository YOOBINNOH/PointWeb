package project.PointWeb.Dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberLoginDto {

    @Size(min=4,max=4,message = "4글자의 알파벳만 가능합니다.")
    @NotBlank(message = "아이디를 입력해주세요.")
    private String memberId;

    @Min(value = 1000,message = "4자리의 숫자만 가능합니다.")
    @Max(value = 9999,message = "4자리의 숫자만 가능합니다.")
    @NotNull(message = "비밀번호를 입력해주세요.")
    private Long memberPw;

}
