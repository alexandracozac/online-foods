package org.fasttrackit.onlinefoods.web;

import org.fasttrackit.onlinefoods.domain.Foods;
import org.fasttrackit.onlinefoods.exception.ResourseNotFoundException;
import org.fasttrackit.onlinefoods.service.FoodsService;
import org.fasttrackit.onlinefoods.transfer.CreateFoodsRequest;
import org.fasttrackit.onlinefoods.transfer.UpdateFoodsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/foods")
@CrossOrigin

public class FoodsController {


    private final FoodsService foodsService;

    @Autowired
    public FoodsController(FoodsService foodsService) {
        this.foodsService = foodsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foods> getFoods(@PathVariable("id") long id) throws ResourseNotFoundException {
        Foods response = foodsService.getFoods(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<Foods> createFoods(@RequestBody @Valid CreateFoodsRequest request){
        Foods response = foodsService.createFoods(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity updateFoods(@PathVariable("id") long id,@Valid @RequestBody UpdateFoodsRequest request) throws ResourseNotFoundException {
         foodsService.updateFoods(id, request);
        return new ResponseEntity( HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFoods(@PathVariable("id") long id){
        foodsService.deleteFoods(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
