package com.uniovi.notaneitor.repositories;
import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


public interface MarksRepository extends CrudRepository<Mark, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Mark SET resend = ?1 WHERE id = ?2")
    void updateResend(Boolean resend, Long id);

    @Query("SELECT r FROM Mark r WHERE r.user = ?1 ORDER BY r.id ASC")
    Page<Mark> findAllByUser(Pageable pageable,User user);
    Page<Mark> findAll(Pageable pageable);

    @Query("Select r from Mark r where (lower(r.description) like lower(?1) or lower(r.user.name)like lower(?1))")
    Page<Mark> searchByDescriptionAndName(Pageable pageable,String searchtext);

    @Query("select r from Mark r where (lower(r.description) like lower(?1) or lower(r.user.name)" +
            " like lower(?1)) and r.user=?2")
    Page<Mark> searchByDescriptionNameAndUser(Pageable pageable,String searchtext,User user);
}