package com.example.blum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductsActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    public static String JSON_URL = "https://raw.githubusercontent.com/danql45/ProjektPAM/master/products.json";

    List<Products> productsList;
    ProductsAdapter productsAdapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        recyclerView = findViewById(R.id.productsItemList);
        productsList = new ArrayList<>();

        extractProducts();
    }



    private void extractProducts(){
//        Cache cache = new DiskBasedCache(getCacheDir(), 10024 * 10024);
//        Network network = new BasicNetwork(new HurlStack());
        RequestQueue queue = Volley.newRequestQueue(this);
//        RequestQueue queue = new RequestQueue(cache, network);
//        queue.start();
        @SuppressLint("NotifyDataSetChanged") JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, response -> {

            int categoryClicked = getIntent().getIntExtra("clickedPos", 99);



            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject jsonObject = response.getJSONObject(i);
                    JSONArray jsonArray = jsonObject.getJSONArray("productInfo");

                    System.out.println(i + " iteracja");
                    //parse nested json elements

                    if(jsonObject.getInt("category") == 1 && categoryClicked == 1) {
                        Products prowadnikHeader = new Products();
                        prowadnikHeader.setId(jsonObject.getInt("id"));
                        prowadnikHeader.setTitle(jsonObject.getString("title"));
                        prowadnikHeader.setImageURL(jsonObject.getString("imageURL"));
                        productsList.add(prowadnikHeader);
                        Log.i("prowadnik object", jsonObject.getString("imageURL"));
                    }
                    if(jsonObject.getInt("category") == 2 && categoryClicked == 0) {
                        Products zawiasHeader = new Products();
                        zawiasHeader.setId(jsonObject.getInt("id"));
                        zawiasHeader.setTitle(jsonObject.getString("title"));
                        zawiasHeader.setImageURL(jsonObject.getString("imageURL"));
                        productsList.add(zawiasHeader);
                    }
                    if(jsonObject.getInt("category") == 3 && categoryClicked == 2) {
                        Products silownikHeader = new Products();
                        silownikHeader.setId(jsonObject.getInt("id"));
                        silownikHeader.setTitle(jsonObject.getString("title"));
                        silownikHeader.setImageURL(jsonObject.getString("imageURL"));
                        productsList.add(silownikHeader);
                    }


                    for (int j = 0; j < jsonArray.length(); j++){

                        //prowadniki
                        if(jsonObject.getInt("category") == 1 && categoryClicked == 1){
                            Products product = new Products();

                            JSONObject jo = jsonArray.getJSONObject(j);
//                            System.out.println(jo);
                            product.setParentID(jo.getInt("parentID"));
                            product.setArticleNumber(jo.getString("articleNumber"));
                            product.setColour(jo.getString("colour"));
                            product.setDistance(jo.getString("distance"));
                            product.setHeight(jo.getString("height"));
                            product.setFixingMethod(jo.getString("fixingMethod"));
                            product.setProductURL(jo.getString("productURL"));
                            productsList.add(product);


                            //zawiasy
                        }else if(jsonObject.getInt("category") == 2 && categoryClicked == 0){
                            Products product = new Products();

                            JSONObject jo = jsonArray.getJSONObject(j);
//                            System.out.println(jo);
                            product.setParentID(jo.getInt("parentID"));
                            product.setProductURL(jo.getString("productURL"));
                            product.setArticleNumber(jo.getString("articleNumber"));
                            product.setColour(jo.getString("colour"));
                            product.setFixingMethod(jo.getString("fixingMethod"));
                            product.setDoorType(jo.getString("doorType"));
                            product.setOpeningAngle(jo.getString("openingAngle"));
                            product.setProductSystem(jo.getString("productSystem"));
                            productsList.add(product);
                        }else if(jsonObject.getInt("category") == 3 && categoryClicked == 2){
                            Products product = new Products();

                            JSONObject jo = jsonArray.getJSONObject(j);
                            product.setParentID(jo.getInt("parentID"));
                            product.setProductURL(jo.getString("productURL"));
                            product.setArticleNumber(jo.getString("articleNumber"));
                            product.setColour(jo.getString("colour"));
                            product.setFixingMethod(jo.getString("fixingMethod"));
                            product.setOpeningAngle(jo.getString("openingAngle"));
                            product.setProductSystem(jo.getString("productSystem"));
                            product.setCabinetHeight(jo.getString("cabinetHeight"));
                            product.setCabinetMinDepth(jo.getString("cabinetMinDepth"));
                            product.setPowerFactorLF(jo.getString("powerFactorLF"));
                            productsList.add(product);
                        }
                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(manager);
            recyclerView.setHasFixedSize(true);
            productsAdapter = new ProductsAdapter(this, productsList, categoryClicked);
            recyclerView.setAdapter(productsAdapter);

        }, error -> Log.d("tag", "onErrorResponse: " + error.getMessage()));


        queue.add(jsonArrayRequest);
    }
//    /**
//     * Extracts a {@link Cache.Entry} from a {@link NetworkResponse}.
//     * Cache-control headers are ignored. SoftTtl == 3 mins, ttl == 24 hours.
//     * @param response The network response to parse headers from
//     * @return a cache entry for the given response, or null if the response is not cacheable.
//     */
//    public static Cache.Entry parseIgnoreCacheHeaders(NetworkResponse response) {
//        long now = System.currentTimeMillis();
//
//        Map<String, String> headers = response.headers;
//        long serverDate = 0;
//        String serverEtag = null;
//        String headerValue;
//
//        headerValue = headers.get("Date");
//        if (headerValue != null) {
//            serverDate = HttpHeaderParser.parseDateAsEpoch(headerValue);
//        }
//
//        serverEtag = headers.get("ETag");
//
//        final long cacheHitButRefreshed = 3 * 60 * 1000; // in 3 minutes cache will be hit, but also refreshed on background
//        final long cacheExpired = 24 * 60 * 60 * 1000; // in 24 hours this cache entry expires completely
//        final long softExpire = now + cacheHitButRefreshed;
//        final long ttl = now + cacheExpired;
//
//        Cache.Entry entry = new Cache.Entry();
//        entry.data = response.data;
//        entry.etag = serverEtag;
//        entry.softTtl = softExpire;
//        entry.ttl = ttl;
//        entry.serverDate = serverDate;
//        entry.responseHeaders = headers;
//
//        return entry;
//    }

}