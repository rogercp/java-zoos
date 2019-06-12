package com.lambdaschool.zoos.service;

import java.util.ArrayList;

import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.view.CountZoosOfAnimals;

public interface AnimalService
{

    ArrayList<CountZoosOfAnimals> getCountZoosOfAnimal();
}
