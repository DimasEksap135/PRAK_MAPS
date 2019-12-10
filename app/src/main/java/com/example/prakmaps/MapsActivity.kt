package com.example.prakmaps

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.autofill.AutofillId
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap



        val utyhebat = LatLng(-7.747033,110.355398)
        mMap.addMarker(MarkerOptions().position(utyhebat).title("Universitas Terdepan Yogyakarta").snippet("Ini Kampus Saya")
            .icon(BitmapDescriptorFromVector(applicationContext,R.drawable.uty)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(utyhebat,17.0f))

        val kontrakanku = LatLng(-7.7632774,110.3424331)
        mMap.addMarker(MarkerOptions().position(kontrakanku).title("Rented House")
            .icon(BitmapDescriptorFromVector(applicationContext,R.drawable.rh)))

        val myparty = LatLng(-7.7532722,110.3605456)
        mMap.addMarker(MarkerOptions().position(myparty).title("BOSHE VVIP Club Yogyakarta")
            .icon(BitmapDescriptorFromVector(applicationContext,R.drawable.boshe)))

        val myhotel = LatLng(-7.75927,110.3610851)
        mMap.addMarker(MarkerOptions().position(myhotel).title("Hotel Crystal Lotus")
            .icon(BitmapDescriptorFromVector(applicationContext,R.drawable.lotus)))
    }

    private fun BitmapDescriptorFromVector(context: Context, vectorResId: Int):
            BitmapDescriptor? {
        val vectorDrawable= ContextCompat.getDrawable(context, vectorResId)
        vectorDrawable!!.setBounds(0,0, vectorDrawable!!.intrinsicWidth,vectorDrawable.intrinsicHeight)
        val bitmap =Bitmap.createBitmap(vectorDrawable.intrinsicWidth,vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888)

        val canvas:Canvas= Canvas(bitmap)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)

    }
}