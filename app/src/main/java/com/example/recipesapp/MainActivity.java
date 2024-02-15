package com.example.recipesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recycleView;
    private LinearLayoutManager layoutManager;
    private RecipeAdapter addapter;
    private Recipe[] recipes;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recycleView = (RecyclerView) findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(MainActivity.this); // new GridLayoutManager
        recycleView.setLayoutManager(layoutManager);

        recycleView.setItemAnimator(new DefaultItemAnimator());

        this.fillRecipeArray();

        addapter = new RecipeAdapter(this.recipes);
        recycleView.setAdapter(addapter);


    }

    private void fillRecipeArray(){
        DBMock db = new DBMock();
        String json = db.getAllRecipes(); // If you had a service, these 2 lines would have changed to be an HTTP request (GET/POST)
        
//        HTTPGETREQUEST http = new HTTPsjsljdgf("http://127.0.0.1:4567/recipes/all");
//        http.setHeader("Content-type","application/json");
//        http.setHeader("Accept", "json");
//        String json = Http.getResponse();

        try {
            JSONArray recipesArray = new JSONArray(json);
            recipes = new Recipe[recipesArray.length()];
            for (int i = 0; i < recipesArray.length(); i++) {
                Recipe r = new Recipe();

                JSONObject recipeObject = recipesArray.getJSONObject(i);
                r.setName(recipeObject.getString("recipe_name"));
                r.setTime(recipeObject.getString("recipe_Time"));
                r.setCalories(Integer.parseInt(recipeObject.getString("calories")));
                r.setDescription(recipeObject.getString("recipe_description"));
                r.setId(Integer.parseInt(recipeObject.getString("recipe_id")));

                recipes[i] = r;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}