package com.lambdaschool.zoos.repository;


import com.lambdaschool.zoos.model.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZooRespository extends CrudRepository<Zoo,Long>
{

}
