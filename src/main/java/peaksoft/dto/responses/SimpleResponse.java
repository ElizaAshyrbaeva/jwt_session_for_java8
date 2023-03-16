package peaksoft.dto.responses;

import lombok.Builder;
import org.springframework.http.HttpStatus;

/**
 * ~ @created 16/03/2023
 * ~ @project_name jwt_session_for_java8
 * ~ @author kurbanov
 **/
@Builder
public record SimpleResponse(
        HttpStatus status,
        String message
) {
}
