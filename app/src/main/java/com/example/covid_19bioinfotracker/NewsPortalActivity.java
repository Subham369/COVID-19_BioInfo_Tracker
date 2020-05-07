package com.example.covid_19bioinfotracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.covid_19bioinfotracker.Model.Articles;
import com.example.covid_19bioinfotracker.Model.HeadLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsPortalActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText searchNews;
    Button btn_search;
    final String API_KEY="17463f3a3f7a414e876226c4e6e1724f";
    Adapter adapter;
    List<Articles> articles=new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_portal);

        searchNews=findViewById(R.id.edtSearch);
        btn_search=findViewById(R.id.btn_search);
        swipeRefreshLayout=findViewById(R.id.swipeFresh);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final String country=getCountry();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                retriveGson("",country,API_KEY);
            }
        });


        retriveGson("",country,API_KEY);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (searchNews.getText().toString().equals(""))
                {

                    swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            retriveGson(searchNews.getText().toString(),country,API_KEY);
                        }
                    });
                    retriveGson(searchNews.getText().toString(),country,API_KEY);
                }
                else
                {
                    swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            retriveGson("",country,API_KEY);
                        }
                    });
                    retriveGson("",country,API_KEY);
                }
            }
        });
    }

    public void retriveGson(String query,String country,String apiKey)
    {
        swipeRefreshLayout.setRefreshing(true);
        Call<HeadLine> call;
        if (!searchNews.getText().toString().equals(""))
        {
            call=APIClient.getInstance().getApi().getsearch(query,apiKey);
        }
        else
        {
            call=APIClient.getInstance().getApi().getheadline(country,apiKey);
        }

        call.enqueue(new Callback<HeadLine>() {
            @Override
            public void onResponse(Call<HeadLine> call, Response<HeadLine> response) {
                if (response.isSuccessful() && response.body().getArticles()!=null)
                {
                    swipeRefreshLayout.setRefreshing(false);
                    articles.clear();
                    articles= response.body().getArticles();
                    adapter=new Adapter(NewsPortalActivity.this,articles);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<HeadLine> call, Throwable t) {

                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(NewsPortalActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getCountry()
    {
        Locale locale=Locale.getDefault();

        String country=locale.getCountry();
        return country.toLowerCase();
    }

}