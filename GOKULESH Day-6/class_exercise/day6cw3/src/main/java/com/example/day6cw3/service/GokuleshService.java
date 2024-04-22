package com.example.day6cw3.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6cw3.model.Gokulesh;
import com.example.day6cw3.repository.GokuleshRepo;

@Service
public class GokuleshService {
    public GokuleshRepo GokuleshRepo;
    public GokuleshService(GokuleshRepo productRepo)
    {
        this.GokuleshRepo = productRepo;
    }
    public boolean postProduct(Gokulesh product)
    {
        try{

            GokuleshRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Gokulesh> pagination(int offset,int size)
    {
        return GokuleshRepo.findAll(PageRequest.of(offset, size)).getContent();
    }
    public List<Gokulesh> sortPagination(int offset,int size,String field)
    {
        return GokuleshRepo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }
    public Gokulesh getProductById(int id)
    {
        return GokuleshRepo.findById(id).orElse(null);
    }
}
