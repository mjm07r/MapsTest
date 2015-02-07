package com.example.root.mapstest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Mike McGee on 2/3/15.
 * Dialog fragment for the alert dialog. Used to confirm meeting location
 */
public class LocationAlert extends DialogFragment {



    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {

        final LatLng passedLocation = (LatLng)getArguments().get("location");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Set Location");
        builder.setMessage("Use this as your location?");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Canceled", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(getActivity(), MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("Coordinates", passedLocation);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });

       // Dialog dialog = builder.create();

        return builder.create();
    }
}
