package project.PointWeb.Dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberRegisterDto {

    @NotBlank
    private String memberId;

    @NotNull @Range(min = 1000L, max = 9999L)
    private Long memberPw;

    @NotNull @Range(min = 1L, max = 10L)
    private Long teamId;

}
