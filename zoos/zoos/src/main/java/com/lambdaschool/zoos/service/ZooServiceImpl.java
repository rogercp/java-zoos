package com.lambdaschool.zoos.service;


import com.lambdaschool.zoos.model.Telephone;
import com.lambdaschool.zoos.model.Zoo;
import com.lambdaschool.zoos.repository.AnimalRepository;
import com.lambdaschool.zoos.repository.ZooRespository;
import com.lambdaschool.zoos.view.CountZoosOfAnimals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;


@Service(value = "zooService")
public class ZooServiceImpl implements ZooService
{
    @Autowired ZooRespository zoorepos;

    @Override
    public ArrayList<Zoo> findAll()
    {
        ArrayList<Zoo> list = new ArrayList<>();
        zoorepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public void delete(long id) throws EntityNotFoundException
    {
        if(zoorepos.findById(id).isPresent())
        {
            zoorepos.deleteZooFromZoos(id);
            zoorepos.deletePhonesFromZoos(id);
            zoorepos.deleteById(id);
        }else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public  Zoo save(Zoo zoo)
    {
        Zoo newZoo=new Zoo();
        newZoo.setZooname(zoo.getZooname());

        for(Telephone t :zoo.getPhones())
        {
            newZoo.getPhones().add(new Telephone(t.getPhonetype(),t.getPhonenumber()));
        }
        zoorepos.save(newZoo);
        return newZoo;
    }

    @Override
    public Zoo update(Zoo zoo,long id)
    {
        Zoo currentZoo= zoorepos.findById(id).orElseThrow(()->new EntityNotFoundException(Long.toString(id)));
        if(zoo.getZooname()!=null)
        {
            currentZoo.setZooname(zoo.getZooname());
        }
        if(zoo.getPhones().size()>0)
        {
            for(Telephone t : zoo.getPhones())
            {
                currentZoo.getPhones().add(new Telephone(t.getPhonetype(),t.getPhonenumber()));
            }
        }
        return zoorepos.save(currentZoo);
    }

}























