package com.kanchan.slidingtabexamine.viewinterface;

import android.app.ProgressDialog;

import com.kanchan.slidingtabexamine.model.Movie;

import java.util.List;

/**
 * Created by Kanchan on 12/25/2016.
 */

public interface MovieListInterface {
    void setMovieList(List<Movie> movieList);
    void showProgressDialog();
    void showToast(String message);
    void dismissDialog();
}
