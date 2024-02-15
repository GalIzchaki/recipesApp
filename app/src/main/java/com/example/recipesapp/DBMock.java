package com.example.recipesapp;

public class DBMock {


    public String getAllRecipes() {
        return "[{\"recipe_id\": 1, \"recipe_name\": \"Recipe 1\", \"recipe_Time\": \"22\", \"recipe_description\": \"a description for recipe 1\", \"calories\": 150}," +
                "{\"recipe_id\": 2, \"recipe_name\": \"Recipe 2\", \"recipe_Time\": \"80\", \"recipe_description\": \"a description for recipe 2\", \"calories\": 250}," +
                "{\"recipe_id\": 3, \"recipe_name\": \"Recipe 3\", \"recipe_Time\": \"7\", \"recipe_description\": \"a description for recipe 3\", \"calories\": 350}," +
                "{\"recipe_id\": 4, \"recipe_name\": \"Recipe 4\", \"recipe_Time\": \"63\", \"recipe_description\": \"a description for recipe 4\", \"calories\": 450}," +
                "{\"recipe_id\": 5, \"recipe_name\": \"Recipe 5\", \"recipe_Time\": \"10\", \"recipe_description\": \"a description for recipe 5\", \"calories\": 550}," +
                "{\"recipe_id\": 6, \"recipe_name\": \"Recipe 6\", \"recipe_Time\": \"6\", \"recipe_description\": \"a description for recipe 6\", \"calories\": 650}," +
                "{\"recipe_id\": 7, \"recipe_name\": \"Recipe 7\", \"recipe_Time\": \"17\", \"recipe_description\": \"a description for recipe 7\", \"calories\": 750}," +
                "{\"recipe_id\": 8, \"recipe_name\": \"Recipe 8\", \"recipe_Time\": \"28\", \"recipe_description\": \"a description for recipe 8\", \"calories\": 850}," +
                "{\"recipe_id\": 9, \"recipe_name\": \"Recipe 9\", \"recipe_Time\": \"39\", \"recipe_description\": \"a description for recipe 9\", \"calories\": 950}," +
                "{\"recipe_id\": 10, \"recipe_name\": \"Recipe 10\", \"recipe_Time\": \"14\", \"recipe_description\": \"a description for recipe 10\", \"calories\": 1050}," +
                "{\"recipe_id\": 11, \"recipe_name\": \"Recipe 11\", \"recipe_Time\": \"11\", \"recipe_description\": \"a description for recipe 11\", \"calories\": 1150}]";
    }

    public String getRecipe(int recipe_id) {
        if (recipe_id > 11 || recipe_id < 1)
            throw new IndexOutOfBoundsException("Recipe does not exist");

        return "{\"recipe_id\": "+recipe_id+", \"recipe_name\": \"Recipe "+recipe_id+"\",  \"recipe_Time\": \"Time "+recipe_id+"\", \"recipe_description\": \"a description for recipe "+recipe_id+"\", \"calories\": "+recipe_id+"50}";
    }

}
