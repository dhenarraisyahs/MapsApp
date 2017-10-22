package id.sch.smktelkom_mlg.learn.apps1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    static final CameraPosition Jakarta = CameraPosition.builder()
            .target(new LatLng(-6.186486, 106.834091))
            .zoom(10)
            .bearing(0)
            .tilt(90)
            .build();
    GoogleMap googleMap;
    boolean mapReady = false;
    LatLng plazaIndonesia = new LatLng(-6.193060, 106.821949);
    LatLng grandIndonesia = new LatLng(-6.195150, 106.819720);
    LatLng atriumPlaza = new LatLng(-6.176898, 106.841367);
    LatLng tamanAnggrek = new LatLng(-6.178768, 106.792098);

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
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Jakarta));
        map.addPolyline(new PolylineOptions().geodesic(true)
                .add(plazaIndonesia)
                .add(grandIndonesia)
                .add(atriumPlaza)
                .add(tamanAnggrek)
                .add(plazaIndonesia));
    }
}
