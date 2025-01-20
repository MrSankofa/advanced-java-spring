package com.codingnomads.springtest.mockingmethods.controllers;

import com.codingnomads.springtest.mockingmethods.models.Ingredient;
import com.codingnomads.springtest.mockingmethods.models.Recipe;
import com.codingnomads.springtest.mockingmethods.models.Review;
import com.codingnomads.springtest.mockingmethods.models.Step;
import com.codingnomads.springtest.mockingmethods.repositories.RecipeRepo;
import com.codingnomads.springtest.mockingmethods.services.RecipeService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class RecipeControllerTest {
  @Autowired
  MockMvc mockMvc;

  @Autowired
  RecipeRepo recipeRepo;

  private RecipeService recipeService;


  @Test
  public void testGetRecipeByIdSuccessBehavior() throws Exception {

    final long recipeId = 1;

    // set up GET request
    mockMvc.perform(get("/recipes/" + recipeId))

        // print response
        .andDo(print())
        // expect status 200 OK
        .andExpect(status().isOk())
//        // expect return Content-Type header as application/json
        .andExpect(content().contentType(
            MediaType.APPLICATION_JSON_VALUE))

        // confirm returned JSON values
        .andExpect(jsonPath("id").value(recipeId))
        .andExpect(jsonPath("minutesToMake").value(2))
        .andExpect(jsonPath("reviews", hasSize(1)))
        .andExpect(jsonPath("ingredients", hasSize(1)))
        .andExpect(jsonPath("steps", hasSize(2)))
        .andExpect(jsonPath("username").value("bob"));
  }

//  @Test
//  public void testGetRecipeByIdSuccessBehavior() throws Exception {
//    final long recipeId = 1;
//
//    // Mock the RecipeService response
//    Recipe mockRecipe = new Recipe();
//    mockRecipe.setId(recipeId);
//    mockRecipe.setMinutesToMake(2);
//    mockRecipe.setReviews(List.of(new Review())); // Mock nested objects
//    mockRecipe.setIngredients(List.of(new Ingredient()));
//    mockRecipe.setSteps(List.of(new Step(), new Step()));
//    mockRecipe.setUsername("bob");
//
//    Mockito.when(recipeService.getRecipeById(recipeId)).thenReturn(mockRecipe);
//
//    // Perform GET request and validate response
//    mockMvc.perform(get("/recipes/" + recipeId))
//        .andDo(print())
//        .andExpect(status().isOk())
//        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE)) // Ensure Content-Type is correct
//        .andExpect(jsonPath("id").value(recipeId))
//        .andExpect(jsonPath("minutesToMake").value(2))
//        .andExpect(jsonPath("reviews", hasSize(1)))
//        .andExpect(jsonPath("ingredients", hasSize(1)))
//        .andExpect(jsonPath("steps", hasSize(2)))
//        .andExpect(jsonPath("username").value("bob"));
//  }
//  @Test
//  void getAllRecipes() {
//  }
//
//  @Test
//  void getRecipesByName() {
//  }
//
//  @Test
//  void deleteRecipeById() {
//  }
//
//  @Test
//  void updateRecipe() {
//  }

  @Test
  public void testGetRecipeByIdFailureBehavior() throws Exception {

    final long recipeId = 5000;

    // set up guaranteed to fail in testing environment request
    mockMvc.perform(get("/recipes/" + recipeId))

        //print response
        .andDo(print())
        //expect status 404 NOT FOUND
        .andExpect(status().isNotFound())
        //confirm that HTTP body contains correct error message
        .andExpect(content().string(containsString(
            "No recipe with ID " + recipeId +
                " could be found")));
  }

  @Test
  public void testGetAllRecipesSuccessBehavior() throws Exception {

    // set up get request for all recipe endpoint
    mockMvc.perform(get("/recipes"))

        // expect status is 200 OK
        .andExpect(status().isOk())

        // expect it will be returned as JSON
        .andExpect(content().contentType(
            MediaType.APPLICATION_JSON_VALUE))

        // expect there are 4 entries
        .andExpect(jsonPath("$", hasSize(4)))

        // expect the first entry to have ID 1
        .andExpect(jsonPath("$[0].id").value(1))

        // expect the first entry to have name test recipe
        .andExpect(jsonPath("$[0].name").value("test recipe"))

        // expect the second entry to have id 2
        .andExpect(jsonPath("$[1].id").value(2))

        // expect the second entry to have a minutesToMake value of 2
        .andExpect(jsonPath("$[1].minutesToMake").value(2))

        // expect the third entry to have id 3
        .andExpect(jsonPath("$[2].id").value(3))

        // expect the third entry to have difficulty rating
        .andExpect(jsonPath("$[2].difficultyRating").value(5));
  }

//  @Test
//// make sure this test runs last
//  @Order(11)
//  public void testGetAllRecipesFailureBehavior() throws Exception {
//
//    // delete all entries to force error
//    recipeRepo.deleteAll();
//
//    // perform GET all recipes
//    mockMvc.perform(get("/recipes"))
//
//        .andDo(print())
//
//        // expect 404 NOT FOUND
//        .andExpect(status().isNotFound())
//
//        // expect error message defined in RecipeService class
//        .andExpect(jsonPath("$").value(
//            "There are no recipes yet :( " +
//                "feel free to add one though"));
//  }


}