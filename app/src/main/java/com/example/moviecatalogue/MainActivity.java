package com.example.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  String[] dataJudul;
    private String[] dataDescription;
    private  String[] dataTanggalRilis;
    private TypedArray dataPoster;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieAdapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(movieAdapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movies.get(i).getJudul(), Toast.LENGTH_SHORT).show();
                Movie movie = new Movie();
                movie.setPoster(movies.get(i).getPoster());
                movie.setJudul(movies.get(i).getJudul());
                movie.setDeskripsi(movies.get(i).getDeskripsi());
                movie.setTanggalRilis(movies.get(i).getTanggalRilis());
                Intent intent = new Intent(MainActivity.this, DetailMovie.class);
                intent.putExtra("object", movie);
                startActivity(intent);
            }
        });
    }

    private void addItem(){
        movies = new ArrayList<>();
        for (int i = 0;i <dataJudul.length; i++){
            Movie movie = new Movie();
            movie.setJudul(dataJudul[i]);
            Log.i("judul", dataJudul[i]);
            movie.setDeskripsi(dataDescription[i]);
            movie.setTanggalRilis(dataTanggalRilis[i]);
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movies.add(movie);
        }
        movieAdapter.setMovies(movies);
    }

    private void  prepare(){
//        dataJudul = getResources().getStringArray(R.array.)
        dataJudul = getResources().getStringArray(R.array.data_judul);
        dataDescription = getResources().getStringArray(R.array.data_deskripsi);
        dataTanggalRilis = getResources().getStringArray(R.array.data_tanggalRilis);
        dataPoster = getResources().obtainTypedArray(R.array.data_photo);
    }
}
