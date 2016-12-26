package com.kanchan.slidingtabexamine.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kanchan.slidingtabexamine.R;
import com.kanchan.slidingtabexamine.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Kanchan on 12/23/2016.
 */

public class OneFragment extends Fragment {

    private int tabNo;
    TextView txtViewName;
    ImageView imgView;
    ProgressBar progressBar;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  Toast.makeText(getActivity(), "OneFragment onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     //   Toast.makeText(getActivity(), "OneFragment onCreateView()", Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtViewName = (TextView) view.findViewById(R.id.txtViewName);
      //  txtViewName.setText("Fragment " + tabNo);
      //  Toast.makeText(getActivity(), "OneFragment onViewCreated()", Toast.LENGTH_SHORT).show();
    /*    progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        imgView = (ImageView) view.findViewById(R.id.imageView);
        Glide.with(getContext())
                .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
             //   .placeholder(R.drawable.manual_entry)
                .error(R.drawable.contact_list)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(imgView);  */

    }

    @Override
    public void onPause() {
        super.onPause();
      //  Toast.makeText(getActivity(), "OneFragment onPause()", Toast.LENGTH_SHORT).show();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
      //  Toast.makeText(getActivity(), "OneFragment onResume()", Toast.LENGTH_SHORT).show();
        EventBus.getDefault().register(this);
    }


 /*   @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(this.isVisible()) {
            if(isVisibleToUser) {
                Toast.makeText(getActivity(), "OneFragment visible", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "OneFragment invisible", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(getActivity(), "OneFragment onAttach()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getActivity(), "OneFragment onDetach()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity(), "OneFragment onDestroyView()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "OneFragment onDestroy()", Toast.LENGTH_SHORT).show();
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

}
