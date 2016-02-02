package company.example.mymapexample;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView mLat;
    private TextView mLon;
    private Button   btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLat    = (TextView) findViewById(R.id.mLat);
        mLon    = (TextView) findViewById(R.id.mLon);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(33.894434, -84.464680);
        mMap.addMarker(new MarkerOptions().position(sydney).title("dale Nigga!"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12));
    }

    public void ponmela(View v)
    {
        if(validate())
        {
            LatLng mPoint = new LatLng(Double.parseDouble(mLat.getText().toString()),Double.parseDouble(mLon.getText().toString()));
            //mMap.clear();
            mMap.addMarker(new MarkerOptions().position(mPoint).title("New Point" + mPoint.toString()));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mPoint,12));
        }
        else
            Toast.makeText(this,"no hay datos",Toast.LENGTH_LONG).show();

    }

    boolean validate()
    {
        boolean flag = false;

        if(mLat.getText().toString().isEmpty() && mLon.getText().toString().isEmpty())
            flag = false;
        else
            flag = true;

        return flag;
    }
}
