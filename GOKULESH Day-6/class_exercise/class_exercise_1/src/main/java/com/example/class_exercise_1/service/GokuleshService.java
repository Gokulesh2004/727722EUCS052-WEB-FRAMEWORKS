package com.example.class_exercise_1.service;

import java.util.List;
import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.class_exercise_1.model.Gokulesh;
import com.example.class_exercise_1.repository.GokuleshRepo;

@Service
public class GokuleshService {

     @Autowired
     public GokuleshRepo GokuleshRepo;

     public List<Gokulesh> sort(String field) {
          return GokuleshRepo.findAll(Sort.by(Sort.Direction.DESC, field));
     }

     public Gokulesh save(Gokulesh children) {
          return GokuleshRepo.save(children);

     }

     public List<Gokulesh> sortedPage(int offset, int pagesize, String field) {
          Page<Gokulesh> sortedPage = GokuleshRepo
                    .findAll(PageRequest.of(offset, pagesize, Sort.by(Sort.Direction.ASC, field)));
          return sortedPage.getContent();
     }

     public List<Gokulesh> pagination(int offset, int pagesize) {
          Page<Gokulesh> pages = GokuleshRepo.findAll(PageRequest.of(offset, pagesize));
          return pages.getContent();

     }

}
