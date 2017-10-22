package id.sch.smktelkom_mlg.learn.apps1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    Button maps, satelite, hybrid;
    GoogleMap googleMap;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maps = (Button) findViewById(R.id.bMap);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        satelite = (Button) findViewById(R.id.bSatelite);
        satelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });

        hybrid = (Button) findViewById(R.id.bHybrid);
        hybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        googleMap = map;
        LatLng telkom = new LatLng(-7.976830, 112.658958);
        CameraPosition position = CameraPosition.builder().target(telkom).zoom(14).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(position));
    }
}
