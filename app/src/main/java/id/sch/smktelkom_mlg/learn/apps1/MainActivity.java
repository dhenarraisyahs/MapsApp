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
    Button telkom, mulmed, palace;
    GoogleMap googleMap;
    boolean mapReady = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telkom = (Button) findViewById(R.id.bTelkom);
        telkom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    LatLng telkom = new LatLng(-7.976830, 112.658958);
                    CameraPosition cp = CameraPosition.builder()
                            .target(telkom)
                            .zoom(14)
                            .bearing(295)
                            .tilt(75)
                            .build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp), 10000, null);
                }
            }
        });

        mulmed = (Button) findViewById(R.id.bMulmed);
        mulmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    LatLng mulmed = new LatLng(-6.182464, 106.830203);
                    CameraPosition cp = CameraPosition.builder()
                            .target(mulmed)
                            .zoom(14)
                            .bearing(295)
                            .tilt(75)
                            .build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp), 10000, null);
                }
            }
        });

        palace = (Button) findViewById(R.id.bPalace);
        palace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    LatLng palace = new LatLng(51.501364, -0.141890);
                    CameraPosition cp = CameraPosition.builder()
                            .target(palace)
                            .zoom(14)
                            .bearing(295)
                            .tilt(75)
                            .build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp), 10000, null);
                }
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        googleMap = map;
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}
