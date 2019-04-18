package com.example.pankathon;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Helper {

    public static void extractEggs(Context context, final StationListener listener) {

        final RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = "http://easteregg.wildcodeschool.fr/api/eggs";

        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        List<Egg> eggList = new ArrayList<>();
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject egg = response.getJSONObject(i);
                                String name = egg.getString("name");
                                Glide.with(Fight.class).load(egg.getString("image")).into(ivLogo);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        listener.onStationsLoaded(eggList);
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("VOLLEY_ERROR", "onErrorResponse: " + error.getMessage());
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    public interface StationListener {
        void onStationsLoaded(List<Egg> eggList);
    }
}
