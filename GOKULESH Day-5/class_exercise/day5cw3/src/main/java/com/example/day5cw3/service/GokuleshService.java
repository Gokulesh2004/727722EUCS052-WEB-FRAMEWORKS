package com.example.day5cw3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day5cw1.model.Gokulesh;
import com.example.day5cw3.model.Gokulesh;
import com.example.day5cw3.repository.GokuleshRepo;

@Service
public class GokuleshService {
    private LanguageRepo GokuleshRepo;
    public GokuleshService(GokuleshRepo languageRepo)
    {
        this.GokuleshRepo=languageRepo;
    }
    public boolean saveLanguage(Gokulesh language)
    {
        try
        {
            GokuleshRepo.save(language);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Language> getLanguages()
    {
        return GokuleshRepo.findAll();
    }
    public boolean updateLanguage(int id,Gokulesh language)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        try{
            GokuleshRepo.save(language);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteLanguage(int id)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        GokuleshRepo.deleteById(id);
        return true;
        
    }
    public Gokulesh getLanguageById(int id)
    {
        return GokuleshRepo.findById(id).orElse(null);
    }

}
