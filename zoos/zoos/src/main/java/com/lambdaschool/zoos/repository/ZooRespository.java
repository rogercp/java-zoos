package com.lambdaschool.zoos.repository;


import com.lambdaschool.zoos.model.Zoo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ZooRespository extends CrudRepository<Zoo,Long>
{
    @Modifying
    @Query(value ="DELETE FROM zoo WHERE zooid=:zooid", nativeQuery = true)
    void deleteZooFromZoos(long zooid);

}
