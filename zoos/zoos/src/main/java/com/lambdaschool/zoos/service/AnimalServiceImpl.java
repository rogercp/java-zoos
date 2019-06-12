package com.lambdaschool.zoos.service;

import com.lambdaschool.zoos.model.Zoo;
import com.lambdaschool.zoos.repository.AnimalRepository;
import com.lambdaschool.zoos.view.CountZoosOfAnimals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService
{
    @Autowired
    private AnimalRepository animalrepos;


    @Override
    public ArrayList<CountZoosOfAnimals> getCountZoosOfAnimal()
    {
        return animalrepos.getCountZoosOfAnimal();
    }

}
