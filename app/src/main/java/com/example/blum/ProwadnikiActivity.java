package com.example.blum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProwadnikiActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Prowadnik> prowadniki;
    public static String JSON_URL = "https://raw.githubusercontent.com/danql45/ProjektPAM/master/pro3.json";

    ProwadnikiAdapter prowadnikiAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prowadniki);
        recyclerView = findViewById(R.id.prowadnikiItemList);
        prowadniki = new ArrayList<>();

        extractProducts();
    }

    private void extractProducts(){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, response -> {

            int categoryClicked = getIntent().getIntExtra("clickedPos", 99);

            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject jsonObject = response.getJSONObject(i);
                    JSONArray jsonArray = jsonObject.getJSONArray("productInfo");

                    System.out.println(i + " iteracja");
                    //parse nested json elements

                    for (int j = 0; j < jsonArray.length(); j++){

                        if(jsonObject.getInt("category") == 1 && categoryClicked == 1){
                            Prowadnik prowadnik = new Prowadnik();



                            prowadnik.setId(jsonObject.getInt("id"));
                            prowadnik.setTitle(jsonObject.getString("title").toString());
                            prowadnik.setImageURL(jsonObject.getString("imageURL"));

                            JSONObject jo = jsonArray.getJSONObject(j);
                            System.out.println(jo);

                            prowadnik.setArticleNumber(jo.getString("articleNumber").toString());
                            prowadnik.setColour(jo.getString("colour").toString());
                            prowadnik.setDistance(jo.getString("distance").toString());
                            prowadnik.setHeight(jo.getString("height").toString());

                            prowadniki.add(prowadnik);
                        }else if(jsonObject.getInt("category") == 2 && categoryClicked == 0){
                            Prowadnik prowadnik = new Prowadnik();
                            prowadnik.setId(jsonObject.getInt("id"));
                            prowadnik.setTitle(jsonObject.getString("title").toString());
                            prowadnik.setImageURL(jsonObject.getString("imageURL"));

                            JSONObject jo = jsonArray.getJSONObject(j);
                            System.out.println(jo);

                            prowadnik.setColour(jo.getString("colour").toString());
                            prowadniki.add(prowadnik);
                        }




//                    int stop = 0;
//                    if(jsonObject.getInt("id") == 3) stop = 1;
//                    //parse nested json elements
//
//                    for (int j = 0; j < jsonArray.length(); j++){
//                        Prowadnik prowadnik = new Prowadnik();
//
//                        prowadnik.setId(jsonObject.getInt("id"));
//                        prowadnik.setTitle(jsonObject.getString("title").toString());
//                        prowadnik.setImageURL(jsonObject.getString("imageURL"));
//
//                        JSONObject jo = jsonArray.getJSONObject(j);
//                        System.out.println(jo);
//
//                        if(stop == 1) break;
//                        else {
//                            prowadnik.setArticleNumber(jo.getString("articleNumber").toString());
//                            prowadnik.setColour(jo.getString("colour").toString());
//                            prowadnik.setDistance(jo.getString("distance").toString());
//                            prowadnik.setHeight(jo.getString("height").toString());
//                        }
//                        System.out.println(jo.getString("distance").toString());
//                        prowadniki.add(prowadnik);
                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(manager);
            recyclerView.setHasFixedSize(true);
            prowadnikiAdapter = new ProwadnikiAdapter(this, prowadniki);
            recyclerView.setAdapter(prowadnikiAdapter);
        }, error -> Log.d("tag", "onErrorResponse: " + error.getMessage()));

        queue.add(jsonArrayRequest);
    }

}