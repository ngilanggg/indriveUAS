package com.example.indriveuas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class SecondActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnFindDriver = findViewById<Button>(R.id.btnFindDriver)
        btnFindDriver.setOnClickListener {
            val intent = Intent (this, ThirdActivity::class.java)
            startActivity(intent)
            // Handle button click event
        }

        // Initialize map
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in a sample location and move the camera
        val location = LatLng(-6.9175, 107.6191) // Contoh koordinat
        mMap.addMarker(MarkerOptions().position(location).title("Marker in Bandung"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location))
    }
}