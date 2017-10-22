package id.sch.smktelkom_mlg.learn.apps1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    static final CameraPosition Jakarta = CameraPosition.builder()
            .target(new LatLng(-6.186486, 106.834091))
            .zoom(15)
            .tilt(45)
            .build();
    GoogleMap googleMap;
    boolean mapReady = false;
    MarkerOptions plazaIndonesia, grandIndonesia, atriumPlaza, tamanAnggrek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plazaIndonesia = new MarkerOptions()
                .position(new LatLng(-6.193060, 106.821949))
                .title("Plaza Indonesia");

        grandIndonesia = new MarkerOptions()
                .position(new LatLng(-6.195150, 106.819720))
                .title("Grand Indonesia");

        atriumPlaza = new MarkerOptions()
                .position(new LatLng(-6.176898, 106.841367))
                .title("Plaza Atrium");

        tamanAnggrek = new MarkerOptions()
                .position(new LatLng(-6.178768, 106.792098))
                .title("Taman Anggrek Mall");
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        googleMap = map;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.addMarker(grandIndonesia);
        map.addMarker(plazaIndonesia);
        map.addMarker(tamanAnggrek);
        map.addMarker(atriumPlaza);
        flyTo(Jakarta);
    }

    private void flyTo(CameraPosition target) {
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
