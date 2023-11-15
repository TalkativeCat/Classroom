package servlets.requestModel;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RequestAverageStudentGradeByClass {
    @NotBlank
    int group;

}
