package com.marcelo.gt.magicstockmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.GridView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class CardsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        getSupportActionBar().setTitle("Cards");

        RequestQueue queue = Volley.newRequestQueue(this);

        displayCards();

        final String url = "https://api.magicthegathering.io/v1/cards?set=kld";

        // prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", response.toString());
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        );

        // add it to the RequestQueue
        queue.add(getRequest);
    }

    private void displayCards(){

        Card[] cards = {
                new Card("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=417574&type=card"),
                new Card("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=417605&type=card"),
                new Card("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=417625&type=card"),
                new Card("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=417637&type=card"),
                new Card("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=417641&type=card"),
                new Card("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=417644&type=card"),
                new Card("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=417647&type=card"),
                new Card("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=417650&type=card"),
                new Card("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=417655&type=card"),
                new Card("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=417658&type=card")
        };

        GridView gridView = (GridView)findViewById(R.id.gridview);
        CardsAdapter cardsAdapter = new CardsAdapter(this, cards);
        gridView.setAdapter(cardsAdapter);
    }
}
