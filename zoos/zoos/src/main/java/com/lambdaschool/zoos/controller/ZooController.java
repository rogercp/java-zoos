package com.lambdaschool.zoos.controller;


import com.lambdaschool.zoos.model.Zoo;
import com.lambdaschool.zoos.service.AnimalService;
import com.lambdaschool.zoos.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value="zoos")
public class ZooController
{
    @Autowired
    private ZooService zooService;


    @GetMapping(value="/zoos",produces = {"application/json"})
    public ResponseEntity<?>listAllZoos()
    {
        ArrayList<Zoo> myZoos=zooService.findAll();
        return new ResponseEntity<>(myZoos, HttpStatus.OK);
    }

    @DeleteMapping(" /admin/zoos/{id}")
    public ResponseEntity<?> deleteZooById(@PathVariable long id)
    {
        zooService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
