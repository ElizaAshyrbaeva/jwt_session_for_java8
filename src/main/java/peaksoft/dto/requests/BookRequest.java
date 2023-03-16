package peaksoft.dto.requests;

import lombok.Builder;
import peaksoft.enums.Genre;

import java.math.BigDecimal;

/**
 * ~ @created 16/03/2023
 * ~ @project_name jwt_session_for_java8
 * ~ @author kurbanov
 **/
@Builder
public record BookRequest(
        String title,
        BigDecimal price,
        Genre genre,
        String description
) {
}
