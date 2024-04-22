package com.example.day5cw1.service;

import org.springframework.stereotype.Service;

import com.example.day5cw1.model.Gokulesh;
import com.example.day5cw1.repository.GokuleshReo;

@Service
public class GokuleshService {
    public GokuleshReo GokuleshReo;
    public GokuleshService(GokuleshReo productRepo)
    {
        this.GokuleshReo = productRepo;
    }
    public boolean saveProduct(Gokulesh product)
    {
        try
        {
            GokuleshReo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,Gokulesh product)
    {
        if(this.getProductById(id)==null)
        {
            return false;
        }
        try{
            GokuleshReo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteProduct(int id)
    {
        if(this.getProductById(id) == null)
        {
            return false;
        }
        GokuleshReo.deleteById(id);
        return true;
    }
    public Gokulesh getProductById(int id)
    {
        return GokuleshReo.findById(id).orElse(null);
    }
}
