package com.kanchan.slidingtabexamine.apicallback;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kanchan.slidingtabexamine.utility.Config;
import com.kanchan.slidingtabexamine.viewinterface.VolleyApiInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by masum on 22/08/2015.
 */
public class MovieListApiCallback {

    VolleyApiInterface volleyApiInterface;
    Context context;

    public MovieListApiCallback(Context context) {
        this.context = context;
    }

    /** api for update auto reservation */
    public void callMovieListApi(final String apiKey, VolleyApiInterface volleyApiInterface) {
        this.volleyApiInterface = volleyApiInterface;
        StringRequest myReq = new StringRequest(Request.Method.POST, Config.BASE_URL + "movie/top_rated", createMyReqSuccessListener(), createMyReqErrorListener()) {
            protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("api_key", apiKey);
                return params;
            }
        };

        int socketTimeout = 30000; //30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        myReq.setRetryPolicy(policy);
     //   HttpRequestQueue.getInstance().addToRequestQueue(myReq);
        Volley.newRequestQueue(context).add(myReq);

    }


    /** Response listener for login api */
    private Response.Listener<String> createMyReqSuccessListener() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volleyApiInterface.onRequestSuccess(response);
            }

        };
    }

    private Response.ErrorListener createMyReqErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyApiInterface.onRequestFailed(error);
            }
        };
    }

}
