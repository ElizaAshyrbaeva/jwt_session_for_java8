package peaksoft.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.requests.AuthorRequest;
import peaksoft.dto.requests.AuthorRequestWithBook;
import peaksoft.dto.responses.AuthorResponse;
import peaksoft.dto.responses.SimpleResponse;
import peaksoft.service.AuthorService;

import java.util.List;

/**
 * ~ @created 16/03/2023
 * ~ @project_name jwt_session_for_java8
 * ~ @author kurbanov
 **/
@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorAPI {
    private final AuthorService authorService;

    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public SimpleResponse saveAuthor(@RequestBody
                                     @Valid

                                     AuthorRequest authorRequest) {
        return authorService.saveAuthor(authorRequest);
    }

    @GetMapping
    @PreAuthorize("permitAll()")
    public List<AuthorResponse> findAll() {
        return authorService.findAll();
    }

    @PostMapping("/save")
    public SimpleResponse saveAuthorWithBook(
            @Valid  @RequestBody AuthorRequestWithBook
                    authorRequestWithBook) {
        return authorService.saveAuthorWithBook(authorRequestWithBook);
    }


}
