package org.fasttrackit.onlinefoods.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.onlinefoods.domain.Foods;
import org.fasttrackit.onlinefoods.exception.ResourseNotFoundException;
import org.fasttrackit.onlinefoods.persistence.FoodsRepository;
import org.fasttrackit.onlinefoods.transfer.CreateFoodsRequest;
import org.fasttrackit.onlinefoods.transfer.UpdateFoodsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FoodsService {


    private static final Logger LOGGER = LoggerFactory.getLogger(FoodsService.class);

    private final FoodsRepository foodsRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public FoodsService(FoodsRepository foodsRepository, ObjectMapper objectMapper) {
        this.foodsRepository = foodsRepository;
        this.objectMapper = objectMapper;
    }

    public Foods createFoods(CreateFoodsRequest request) {
        LOGGER.info("Creating food {}", request);
        Foods foods = objectMapper.convertValue(request, Foods.class);

        return foodsRepository.save(foods);

    }

    public Foods getFoods(long id) throws ResourseNotFoundException {
        LOGGER.info("Retrieving food {}", id);
        return foodsRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Resourse" + id + "not found"));
    }

    public Foods updateFoods(long id, UpdateFoodsRequest request) throws ResourseNotFoundException {
        LOGGER.info("Updating food {}, {}", id, request);
        Foods foods = getFoods(id);

        BeanUtils.copyProperties(request, foods);
        return foodsRepository.save(foods);

    }

    public void deleteFoods(long id){
        LOGGER.info("Deleting food {}", id);
        foodsRepository.deleteById(id);

        LOGGER.info("Deleted food {}", id);

    }
}
