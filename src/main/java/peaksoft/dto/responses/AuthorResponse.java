package peaksoft.dto.responses;

import lombok.Builder;

/**
 * ~ @created 16/03/2023
 * ~ @project_name jwt_session_for_java8
 * ~ @author kurbanov
 **/
@Builder
public record AuthorResponse(
        Long id,
        String fullName,

        String phoneNumber,

        String email

) {
}
