package id.sch.smktelkom_mlg.learn.apps1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class MainActivity extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback {
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

        StreetViewPanoramaFragment svpFragment = (StreetViewPanoramaFragment) getFragmentManager().findFragmentById(R.id.map);
        svpFragment.getStreetViewPanoramaAsync(this);
    }



    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        streetViewPanorama.setPosition(KANTOR);
        streetViewPanorama.setStreetNamesEnabled(false);
        StreetViewPanoramaCamera camera = StreetViewPanoramaCamera.builder()
                .bearing(180)
                .build();
        streetViewPanorama.animateTo(camera, 1000);
    }
}
