package com.kanchan.slidingtabexamine.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kanchan.slidingtabexamine.R;
import com.kanchan.slidingtabexamine.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Kanchan on 12/23/2016.
 */

public class ThreeFragment extends Fragment {

    private int tabNo;
    TextView txtViewName;

    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  Toast.makeText(getActivity(), "ThreeFragment onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     //   Toast.makeText(getActivity(), "ThreeFragment onCreateView()", Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtViewName = (TextView) view.findViewById(R.id.txtViewName);
      //  txtViewName.setText("Fragment " + tabNo);
     //   Toast.makeText(getActivity(), "ThreeFragment onViewCreated()", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onPause() {
        super.onPause();
      //  Toast.makeText(getActivity(), "ThreeFragment onPause()", Toast.LENGTH_SHORT).show();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
      //  Toast.makeText(getActivity(), "ThreeFragment onResume()", Toast.LENGTH_SHORT).show();
        EventBus.getDefault().register(this);
    }

 /*   @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(this.isVisible()) {
            if(isVisibleToUser) {
                Toast.makeText(getActivity(), "ThreeFragment visible", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "ThreeFragment invisible", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(getActivity(), "ThreeFragment onAttach()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getActivity(), "ThreeFragment onDetach()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity(), "ThreeFragment onDestroyView()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "ThreeFragment onDestroy()", Toast.LENGTH_SHORT).show();
    }  */


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
