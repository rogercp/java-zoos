package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.view.CountZoosOfAnimals;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal,Long>
{

    @Query(value="SELECT a.animalid,animaltype,count(zooid) as countzoos FROM zooanimals a INNER JOIN animal c ON a.animalid=c.animalid GROUP BY a.animalid,animaltype",nativeQuery = true)
    ArrayList<CountZoosOfAnimals> getCountZoosOfAnimal();

}
