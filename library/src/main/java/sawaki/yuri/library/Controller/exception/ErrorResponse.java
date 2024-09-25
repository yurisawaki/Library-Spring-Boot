package sawaki.yuri.library.Controller.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ErrorResponse {

    private Instant timestamp;
    private Integer status;
    private String error;
    private  String message;
    private String path;

}
