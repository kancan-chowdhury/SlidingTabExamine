package com.kanchan.slidingtabexamine.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kanchan.slidingtabexamine.R;
import com.kanchan.slidingtabexamine.activity.MainActivity;
import com.kanchan.slidingtabexamine.adapter.MoviesAdapter;
import com.kanchan.slidingtabexamine.event.MessageEvent;
import com.kanchan.slidingtabexamine.model.Movie;
import com.kanchan.slidingtabexamine.presenter.MovieListPresenter;
import com.kanchan.slidingtabexamine.viewinterface.MovieListInterface;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by Kanchan on 12/23/2016.
 */

public class TwoFragment extends Fragment implements MovieListInterface{

    private int tabNo;
    private TextView txtViewName;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;

    MovieListPresenter presenter;
    private final static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";


    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  Toast.makeText(getActivity(), "TwoFragment onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      //  Toast.makeText(getActivity(), "TwoFragment onCreateView()", Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtViewName = (TextView) view.findViewById(R.id.txtViewName);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewMovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
      //  txtViewName.setText("Fragment " + tabNo);
      //  Toast.makeText(getActivity(), "TwoFragment onViewCreated()", Toast.LENGTH_SHORT).show();

        presenter = new MovieListPresenter(this);
        presenter.getMovieList(getContext(), API_KEY);

    }


    @Override
    public void onPause() {
        super.onPause();
      //  Toast.makeText(getActivity(), "TwoFragment onPause()", Toast.LENGTH_SHORT).show();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
     //   Toast.makeText(getActivity(), "TwoFragment onResume()", Toast.LENGTH_SHORT).show();
        EventBus.getDefault().register(this);
    }


 /*   @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(this.isVisible()) {
            if(isVisibleToUser) {
                Toast.makeText(getActivity(), "TwoFragment visible", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "TwoFragment invisible", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(getActivity(), "TwoFragment onAttach()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getActivity(), "TwoFragment onDetach()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity(), "TwoFragment onDestroyView()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "TwoFragment onDestroy()", Toast.LENGTH_SHORT).show();
    }   */


    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
      //  tabNo = args.getInt("tab_no");
    }

    // This method will be called when a MessageEvent is posted (in the UI thread for Toast)
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        //  Toast.makeText(getActivity(), event.message, Toast.LENGTH_SHORT).show();
        txtViewName.setText(event.message);
    }

    @Override
    public void setMovieList(List<Movie> movieList) {
        recyclerView.setAdapter(new MoviesAdapter(movieList, R.layout.list_item_movie, getActivity()));
    }

    @Override
    public void showProgressDialog() {
        if(progressDialog == null) {
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
        }
        progressDialog.show();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void dismissDialog() {
        if(progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
