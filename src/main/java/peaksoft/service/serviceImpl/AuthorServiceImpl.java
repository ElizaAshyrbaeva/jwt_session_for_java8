package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.dto.requests.AuthorRequest;
import peaksoft.dto.requests.AuthorRequestWithBook;
import peaksoft.dto.responses.AuthorResponse;
import peaksoft.dto.responses.SimpleResponse;
import peaksoft.entity.AuthInfo;
import peaksoft.entity.Author;
import peaksoft.entity.Book;
import peaksoft.enums.Role;
import peaksoft.repository.AuthorRepository;
import peaksoft.service.AuthorService;

import java.time.LocalDate;
import java.util.List;

/**
 * ~ @created 16/03/2023
 * ~ @project_name jwt_session_for_java8
 * ~ @author kurbanov
 **/
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public SimpleResponse saveAuthor(AuthorRequest authorRequest) {
        if (authorRepository.existsByAuthInfoEmail(
                authorRequest.email())) {
            return SimpleResponse.builder().
                    status(HttpStatus.BAD_REQUEST).
                    message(String.format("Author with email :%s already exists",
                            authorRequest.email())).build();
        }
        Author author = new Author();
        author.setFirstName(authorRequest.firstName());
        author.setLastName(authorRequest.lastName());
        author.setPhoneNumber(authorRequest.phoneNumber());
        author.setCountry(authorRequest.country());
        author.setGender(authorRequest.gender());
        AuthInfo authInfo = new AuthInfo();
        authInfo.setEmail(authorRequest.email());
        authInfo.setPassword(passwordEncoder.encode(authorRequest.password()));
        authInfo.setRole(Role.AUTHOR);
        author.setAuthInfo(authInfo);
        authInfo.setAuthor(author);

        authorRepository.save(author);
        return SimpleResponse.builder().status(HttpStatus.OK).
                message(String.format("Author with fullName : %s " +
                                "successfully saved",
                        author.getFirstName().concat(" ").concat(author.getLastName()))).build();
    }

    @Override
    public List<AuthorResponse> findAll() {
        return authorRepository.findAllAuthor();
    }

    @Override
    public SimpleResponse saveAuthorWithBook(AuthorRequestWithBook authorRequest) {
        if (!authorRepository.existsByAuthInfoEmail(
                authorRequest.email())) {
            return SimpleResponse.builder().
                    status(HttpStatus.BAD_REQUEST).
                    message(String.format("Author with email :%s already exists",
                            authorRequest.email())).build();
        }
        Author author1 = new Author();
        author1.setFirstName(authorRequest.firstName());
        author1.setLastName(authorRequest.lastName());
        author1.setPhoneNumber(authorRequest.phoneNumber());
        author1.setCountry(authorRequest.country());
        author1.setGender(authorRequest.gender());
        AuthInfo authInfo = new AuthInfo();
        authInfo.setEmail(authorRequest.email());
        authInfo.setPassword(passwordEncoder.encode(authorRequest.password()));
        authInfo.setRole(Role.AUTHOR);
        author1.setAuthInfo(authInfo);
        authInfo.setAuthor(author1);
        Book book = new Book();
        book.setDescription(authorRequest.bookRequest().description());
        book.setPrice(authorRequest.bookRequest().price());
        book.setGenre(authorRequest.bookRequest().genre());
        book.setTitle(authorRequest.bookRequest().title());
        book.setDateOfIssue(LocalDate.now());
        author1.addBook(book);
        book.setAuthor(author1);
        authorRepository.save(author1);
        return SimpleResponse.builder().status(HttpStatus.OK).
                message(String.format("Author with fullName : %s " +
                                "successfully saved",
                        author1.getFirstName().concat(" ").concat(author1.getLastName()))).build();
    }
}
