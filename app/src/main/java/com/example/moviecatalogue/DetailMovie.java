package com.example.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovie extends AppCompatActivity {
    private ImageView posterImageView;
    private TextView judulTextView, deskripsiTextView, tanggalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        posterImageView = findViewById(R.id.detailPosterImageView);
        judulTextView = findViewById(R.id.detailJudulTextView);
        deskripsiTextView = findViewById(R.id.detailDeskripsiTextView);
        tanggalTextView = findViewById(R.id.detailTanggalRilisTextView);
        Bundle extras = getIntent().getExtras();
        Log.i("detail movie", "true");
        if (extras!= null){
            Log.i("extras", "true");
            Movie movie = extras.getParcelable("object");
            if (movie != null){
                Log.i("movie", "true");
                Log.i("info movie", movie.getJudul());
                Log.i("info movie", movie.getDeskripsi());
                Log.i("info movie", movie.getTanggalRilis());
                judulTextView.setText(movie.getJudul());
                deskripsiTextView.setText(movie.getDeskripsi());
                tanggalTextView.setText(movie.getTanggalRilis());
                posterImageView.setImageResource(movie.getPoster());
            }

        }

    }
}
