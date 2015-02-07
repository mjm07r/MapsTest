package com.example.root.mapstest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created By Mike McGee
 * Used as template for a starting activity which would enter into maps.
 *
 */
public class MainActivity extends Activity {

    Button submitButton;
    TextView locationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.first_page);

        submitButton = (Button) findViewById(R.id.test_submit_button);
        locationTextView = (TextView) findViewById(R.id.location_textview);


        try{
            Bundle bundle = getIntent().getParcelableExtra("bundle");
            LatLng coordinates = bundle.getParcelable("Coordinates");
            Log.d("Coordinates", coordinates.latitude +"-"+coordinates.longitude);

            //Cant get the coordinates to show on textview, although they are correct in the logs
            double latitude = coordinates.latitude;
            double longitude = coordinates.longitude;
            String meetingLocation = "Meeting location "+String.valueOf(latitude)+"-"+String.valueOf(longitude);
            locationTextView.setText(meetingLocation);
            locationTextView.setVisibility(View.VISIBLE);
        }catch (NullPointerException e)
        {
            locationTextView.setVisibility(View.INVISIBLE);
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void enterMapFrag(View view) {

        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);

    }
}

