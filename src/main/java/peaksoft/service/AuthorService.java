package peaksoft.service;

import peaksoft.dto.requests.AuthorRequest;
import peaksoft.dto.requests.AuthorRequestWithBook;
import peaksoft.dto.responses.AuthorResponse;
import peaksoft.dto.responses.SimpleResponse;

import java.util.List;

/**
 * ~ @created 16/03/2023
 * ~ @project_name jwt_session_for_java8
 * ~ @author kurbanov
 **/
public interface AuthorService {
    SimpleResponse saveAuthor(AuthorRequest authorRequest);

    List<AuthorResponse> findAll();

    SimpleResponse saveAuthorWithBook(AuthorRequestWithBook authorRequestWithBook);
}
