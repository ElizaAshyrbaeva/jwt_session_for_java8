package peaksoft.dto.requests;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import peaksoft.enums.Country;
import peaksoft.enums.Gender;

/**
 * ~ @created 16/03/2023
 * ~ @project_name jwt_session_for_java8
 * ~ @author kurbanov
 **/

@Builder
public record AuthorRequest(
        String firstName,
        String lastName,
        Gender gender,
        Country country,
        String phoneNumber,
        @Email
        String email,
        String password

) {
}
