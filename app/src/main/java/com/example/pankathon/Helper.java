package com.example.pankathon;


import android.content.Context;
import android.util.Log;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Helper {

    public static void extractEggs(Context context, final EggListener listener) {

        final RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = "http://easteregg.wildcodeschool.fr/api/eggs";

        final List<Egg> eggList = new ArrayList<>();
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject eggObject = response.getJSONObject(i);
                                String name = eggObject.getString("name");
                                String image = eggObject.getString("image");
                                String id = eggObject.getString("id");
                                String color = eggObject.getString("color");
                                String caliber = eggObject.getString("caliber");
                                int farming = eggObject.getInt("farming");
                                String country = eggObject.getString("country");
                                String  rarity = eggObject.getString("rarity");
                                String power = eggObject.getString("power");
                                Egg egg = new Egg(id, name, color, caliber, farming, country, rarity, image, power, 100);
                                eggList.add(egg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        listener.onEggLoaded(eggList);
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

    public interface EggListener {
        void onEggLoaded(List<Egg> eggList);
    }



    public static Egg randomEgg(ArrayList<Egg> eggList) {
            Random r = new Random();
            int i = r.nextInt(eggList.size());
            return eggList.get(i);
    }
}
