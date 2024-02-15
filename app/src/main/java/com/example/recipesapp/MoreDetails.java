package com.example.recipesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MoreDetails extends AppCompatActivity {
    private Button menu;
    private TextView NameTextView,TimeToMakeTextView,descriptionTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);
        Bundle b = getIntent().getExtras();
        int recipe_id = -1; // or other values
        if(b != null) {
            recipe_id = b.getInt("recipe_id");
//            Log.d("MoreDetails", "Received recipe_id: " + recipe_id);
        }
        DBMock db = new DBMock();
        String json = db.getRecipe(recipe_id);
        try {
            JSONObject recipeObject = new JSONObject(json);

            String recipeName = recipeObject.getString("recipe_name");
            NameTextView = findViewById(R.id.NameRTextView);
            NameTextView.setText(recipeName);

            String timeToMake = recipeObject.getString("recipe_Time");
            TimeToMakeTextView = findViewById(R.id.TimeTextView);
            TimeToMakeTextView.setText(timeToMake + " minutes");

            String description = recipeObject.getString("recipe_description");
            descriptionTextView = findViewById(R.id.descriptionTextView);
            descriptionTextView.setText(description);
        } catch (JSONException e){
            e.printStackTrace();
        }


        menu = findViewById(R.id.buttonMenuU);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MoreDetails.this, MainActivity.class));
            }
        });
    }
}