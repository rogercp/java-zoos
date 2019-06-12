package com.lambdaschool.zoos.service;


import com.lambdaschool.zoos.model.Zoo;
import com.lambdaschool.zoos.repository.ZooRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
