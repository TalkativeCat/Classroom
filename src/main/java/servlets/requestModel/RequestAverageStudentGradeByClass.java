package servlets.requestModel;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestAverageStudentGradeByClass {
    @NotBlank
    int group;

}
