package com.example.recipesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowRecipe extends AppCompatActivity implements View.OnTouchListener {
    private Button MoreDetailsB;
    private TextView NameTextView,TimeToMakeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_recipe);

        DBMock db = new DBMock();
        String json = db.getAllRecipes(); // If you had a service, these 2 lines would have changed to be an HTTP request (GET/POST)


        try {
            JSONArray recipesArray = new JSONArray(json);

            for (int i = 0; i < recipesArray.length(); i++) {
                JSONObject recipeObject = recipesArray.getJSONObject(i);

                String recipeName = recipeObject.getString("recipe_name");
                NameTextView = findViewById(R.id.NameTextView);
                NameTextView.setText(recipeName);

                String timeToMake = recipeObject.getString("recipe_Time");
                TimeToMakeTextView = findViewById(R.id.TimeToMakeTextView);
                TimeToMakeTextView.setText(timeToMake + " minutes");



                MoreDetailsB= (Button) findViewById(R.id.MoreDetails);

                MoreDetailsB.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        System.out.println("Hello World!");
                        return false;
                    }
                });

//                int finalI = i;
//                MoreDetailsB.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(ShowRecipe.this,MoreDetails.class);
//                        Bundle b= new Bundle();
//                        b.putInt("id", finalI);
//                        intent.putExtras(b);
//
//                        startActivity(intent);
//                        finish();
//                    }
//                });


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        System.out.println("Hello World!");
        return false;
    }
}