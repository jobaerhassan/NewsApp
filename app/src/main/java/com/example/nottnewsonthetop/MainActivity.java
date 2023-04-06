package com.example.nottnewsonthetop;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.annotation.Target;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<news> arrNews = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //data set

//
//        loadNews();
//        loadData();
        String url = "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=6b76d42fba2745af906e3eef7fed4ba2";
        fetchdata(url);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this,arrNews);
        recyclerView.setAdapter(recyclerAdapter);
    }

    //public void loadNews()
//    {
//        String url = "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=6b76d42fba2745af906e3eef7fed4ba2";
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
//                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            JSONArray jsonArray = response.getJSONArray("articles");
//                            for(int i=0;i<jsonArray.length();i++)
//                            {
//                                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                                news n = new news(jsonObject.getString("title")
//                                ,jsonObject.getString("author")
//                                ,jsonObject.getString("description")
//                                ,jsonObject.getString("url")
//                                ,jsonObject.getString("urlToImage"));
//                                arrNews.add(n);
//                            }
//
//                        } catch (JSONException e) {
//                            Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//
//                    }
//                });
//
//// Access the RequestQueue through your singleton class.
//        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
//    }
    private void fetchdata(String url){
//        String url="https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=f545eab44cea4fee8ba496becd3f7c95";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET,url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray newjsonarray=response.getJSONArray("articles");
                            ArrayList<news> newsArray =new ArrayList<>();
                            for(int i=0;i<newjsonarray.length();i++)
                            {
                                JSONObject newJsonObject=newjsonarray.getJSONObject(i);
                                news ne=new news(newJsonObject.getString("title"),
                                        newJsonObject.getString("author"),
                                        newJsonObject.getString("url"),
                                        newJsonObject.getString("urlToImage"));
                                arrNews.add(ne);
                            }
//                            myadapter.updateNews(newsArray);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
//




}