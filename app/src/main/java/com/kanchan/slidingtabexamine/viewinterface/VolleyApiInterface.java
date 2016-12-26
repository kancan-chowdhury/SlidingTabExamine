package com.kanchan.slidingtabexamine.viewinterface;

import com.android.volley.VolleyError;

/**
 * Created by masum on 22/08/2015.
 */
public interface VolleyApiInterface {
    void onRequestSuccess(String response);
    void onRequestFailed(VolleyError error);
}
