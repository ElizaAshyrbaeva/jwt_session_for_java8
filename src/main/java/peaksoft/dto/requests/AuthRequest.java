package peaksoft.dto.requests;

import jakarta.validation.constraints.Email;
import lombok.Builder;


@Builder
public record AuthRequest(
        @Email
        String email,

        String password
) {


}
