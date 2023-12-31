package com.erapor.erapor.repository;

import com.erapor.erapor.model.DAO.StudentsDAO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentsRepository extends JpaRepository<StudentsDAO, String> {

    @Query("SELECT s FROM StudentsDAO s JOIN FETCH s.valuesDAO val ORDER BY val.TOTAL DESC")
    List<StudentsDAO> findRanking(Pageable pageable);

    @Query("SELECT s FROM StudentsDAO s JOIN FETCH s.valuesDAO val ORDER BY val.TOTAL DESC")
    List<StudentsDAO> findRanking();

    @Query("SELECT s FROM StudentsDAO s JOIN FETCH s.valuesDAO val WHERE s.name LIKE %:name%")
    StudentsDAO findByName(@Param("name") String name);


}
