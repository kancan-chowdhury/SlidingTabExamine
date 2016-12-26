package com.kanchan.slidingtabexamine.presenter;

import android.content.Context;
import android.util.Log;

import com.android.volley.VolleyError;
import com.kanchan.slidingtabexamine.apicallback.MovieListApiCallback;
import com.kanchan.slidingtabexamine.model.Movie;
import com.kanchan.slidingtabexamine.viewinterface.MovieListInterface;
import com.kanchan.slidingtabexamine.viewinterface.VolleyApiInterface;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kanchan on 12/25/2016.
 */

public class MovieListPresenter {
    MovieListInterface movieView;

    public MovieListPresenter(MovieListInterface movieView){
        this.movieView = movieView;
    }

    public void getMovieList(Context context, String apiKey) {
        movieView.showProgressDialog();
        new MovieListApiCallback(context).callMovieListApi(apiKey, new VolleyApiInterface() {
            @Override
            public void onRequestSuccess(String response) {
                try {
                    movieView.dismissDialog();
                    Log.e("movie_response", response);
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jArray = jsonObject.getJSONArray("results");
                    List<Movie> moviesList = new ArrayList<Movie>();
                    for(int i = 0; i < jArray.length(); i++) {
                        Movie movie = new Movie();
                        movie.setTitle(jArray.getJSONObject(i).getString("title"));
                        movie.setReleaseDate(jArray.getJSONObject(i).getString("release_date"));
                        movie.setOverview(jArray.getJSONObject(i).getString("overview"));
                        movie.setVoteAverage(jArray.getJSONObject(i).getDouble("vote_average"));
                        moviesList.add(movie);
                    }
                    movieView.setMovieList(moviesList);
                } catch (Exception e) {

                }
            }

            @Override
            public void onRequestFailed(VolleyError error) {
                movieView.dismissDialog();
                movieView.showToast("" + error);
            }
        });
    }

}
