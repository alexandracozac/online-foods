package org.fasttrackit.onlinefoods;

import org.fasttrackit.onlinefoods.domain.Foods;
import org.fasttrackit.onlinefoods.exception.ResourseNotFoundException;
import org.fasttrackit.onlinefoods.service.FoodsService;
import org.fasttrackit.onlinefoods.transfer.CreateFoodsRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest

public class FoodsServiceIntegrationTests {
    @Autowired
    private FoodsService foodsService;

    @Test
    public void testCreateFoods_whenValidRequest_thenReturnFoodsWithId() {
        Foods foods = createFoods();
        assertThat(foods, notNullValue());
        assertThat(foods.getId(), greaterThan(0L));


    }

    private Foods createFoods() {
        CreateFoodsRequest request = new CreateFoodsRequest();
        request.setName("Avocado");
        request.setProperties("Vitamina A, C, B6, grasimi bune");
        request.setQuantity(1);
        request.setCategory("Fruct");

        return foodsService.createFoods(request);
    }

    @Test(expected = ResourseNotFoundException.class)
    public void testGetFoods_whenFoodsNotFound_thenThrowResouceNotFoundException() throws ResourseNotFoundException {
        foodsService.getFoods(0);

    }
    @Test
    public void testGetFoods_whenExistingId_thenReturnMatchingFood() throws ResourseNotFoundException {

        Foods foods = createFoods();
        Foods retrievedfood = foodsService.getFoods(foods.getId());

        assertThat(retrievedfood.getId(),is(foods.getId()));
        assertThat(retrievedfood.getName(),is(foods.getName()));


    }
    @Test
    public void testUpdateFoods_whenValidRequestWithAllFields_thenReturnUpdateFood(){

    }


}
