package com.lambdaschool.zoos.repository;


import com.lambdaschool.zoos.model.Zoo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ZooRespository extends CrudRepository<Zoo,Long>
{
    Zoo findByZooid(long id);

    @Modifying
    @Query(value ="DELETE FROM zooanimals WHERE zooid=:zooid", nativeQuery = true)
    void deleteZooFromZoos(long zooid);

    @Modifying
    @Query(value = "DELETE FROM telephone WHERE zooid=:zooid",nativeQuery = true)
    void deletePhonesFromZoos(long zooid);


}
