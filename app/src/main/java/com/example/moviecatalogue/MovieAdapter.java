package com.example.moviecatalogue;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies){
        this.movies = movies;
    }

    public MovieAdapter(Context context){
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       if (convertView == null){
           convertView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);

       }
       ViewHolder viewHolder = new ViewHolder(convertView);
       Movie movie = (Movie) getItem(position);
       viewHolder.bind(movie);
       return convertView;

    }

    private class ViewHolder{
        private ImageView posterImageView;
        private TextView judulTextView;
        private TextView deskripsiTextView;
        private TextView tanggalRilisTextView;

        ViewHolder(View view){
            judulTextView = view.findViewById(R.id.judulTextView);
            deskripsiTextView = view.findViewById(R.id.deskripsiTextView);
            tanggalRilisTextView = view.findViewById(R.id.tanggalRilisTextView);
            posterImageView = view.findViewById(R.id.posterImageView);
        }
        void bind(Movie movie){
            judulTextView.setText(movie.getJudul());
            deskripsiTextView.setText(movie.getDeskripsi());
            tanggalRilisTextView.setText(movie.getTanggalRilis());
            posterImageView.setImageResource(movie.getPoster());

        }
    }
}
