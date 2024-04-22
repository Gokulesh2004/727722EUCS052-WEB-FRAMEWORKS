package com.example.day6pah.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6pah.model.Gokulesh;
import com.example.day6pah.repository.GokuleshRepo;

@Service
public class GokuleshService {
    public GokuleshRepo GokuleshRepo;
    public GokuleshService(GokuleshRepo languageRepo)
    {
        this.GokuleshRepo = languageRepo;
    }
    public boolean postLanguage(Language language)
    {
        try{

            GokuleshRepo.save(language);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Gokulesh> getSortedLanguages(String field)
    {
        return GokuleshRepo.findAll(Sort.by(field));
    }
    public List<Gokulesh> getPaginationLanguages(int offset,int size)
    {
        return GokuleshRepo.findAll(PageRequest.of(offset, size)).getContent();
        // return childrenRepo.findAll(Pageable.ofSize(size).withPage(offset)).getContent();
                        
    }
    public List<Gokulesh> getSortedPaginationLanguages(int offset,int size,String field)
    {
        return GokuleshRepo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }
}
