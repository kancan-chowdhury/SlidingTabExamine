package com.kanchan.slidingtabexamine.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Kanchan on 12/25/2016.
 */

public class MoviesResponseParcelable implements Parcelable {

    private int page;
    private int totalResults;
    private int totalPages;
    private List<Movie> results;

    public MoviesResponseParcelable(int page, int totalResults, int totalPages, List<Movie> results) {
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.results = results;
    }

    public MoviesResponseParcelable(Parcel in) {
        page = in.readInt();
        totalResults = in.readInt();
        totalPages = in.readInt();
        results = in.readArrayList(Movie.class.getClassLoader());
    }

    public static final Creator<MoviesResponseParcelable> CREATOR = new Creator<MoviesResponseParcelable>() {
        @Override
        public MoviesResponseParcelable createFromParcel(Parcel in) {
            return new MoviesResponseParcelable(in);
        }

        @Override
        public MoviesResponseParcelable[] newArray(int size) {
            return new MoviesResponseParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(page);
        dest.writeInt(totalResults);
        dest.writeInt(totalPages);
        dest.writeList(results);
    }


    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<Movie> getResults() {
        return results;
    }

}
