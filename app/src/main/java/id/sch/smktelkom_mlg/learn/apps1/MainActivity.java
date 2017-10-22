package id.sch.smktelkom_mlg.learn.apps1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    static final CameraPosition kantor = CameraPosition.builder()
            .target(new LatLng(-6.182419, 106.830236))
            .zoom(15)
            .bearing(0)
            .tilt(90)
            .build();
    GoogleMap googleMap;
    boolean mapReady = false;
    LatLng KANTOR = new LatLng(-6.182419, 106.830236);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        googleMap = map;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(kantor));
        map.addCircle(new CircleOptions()
                .center(KANTOR)
                .radius(125)
                .strokeColor(Color.GRAY)
                .fillColor(Color.argb(64, 0, 255, 0)));
    }
}
