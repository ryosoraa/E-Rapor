package com.erapor.erapor.controller;

import com.erapor.erapor.model.DAO.StudentsDAO;
import com.erapor.erapor.model.DTO.RankingDTO;
import com.erapor.erapor.model.DTO.StudentsDTO;
import com.erapor.erapor.repository.StudentsRepository;
import com.erapor.erapor.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class Students {

    @Autowired
    StudentsRepository studentsRepository;

    @Autowired
    StudentsService studentsService;

    @GetMapping("/top")
    public ResponseEntity<List<RankingDTO>> topRank(
            @RequestParam Integer page,
            @RequestParam Integer size
            ){
        return ResponseEntity.ok()
                .body(studentsService.ranking(page - 1, size));
    }

    @GetMapping("/search")
    public ResponseEntity<RankingDTO> search(
            @RequestParam String name
    ){
        return ResponseEntity.ok()
                .body(studentsService.byName(name));
    }


}

