package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.responses.AuthorResponse;
import peaksoft.entity.Author;

import java.util.List;

public interface AuthorRepository extends
        JpaRepository<Author, Long> {

    Boolean existsByAuthInfoEmail(String email);

    @Query("select  new peaksoft.dto.responses.AuthorResponse(a.id,concat(a.firstName,'  ',a.lastName),a.phoneNumber,a.authInfo.email )from Author a ")
    List<AuthorResponse> findAllAuthor();

}