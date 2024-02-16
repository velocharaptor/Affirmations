package com.example.affirmations.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.affirmations.R
import com.example.affirmations.navigation.NavHost
import com.example.affirmations.navigation.NavHostProvider
import com.example.affirmations.core.notifications.NotificationsManager
import com.example.affirmations.databinding.ActivityMainBinding
import com.example.affirmations.featureflag.feature.Feature
import com.example.affirmations.utils.resmanager.ResManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import java.util.regex.Pattern
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavHost {
    lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var resManager: ResManager
    @Inject
    lateinit var feature: Feature
    @Inject
    lateinit var navHostProvider: NavHostProvider
    private lateinit var navController: NavController
    @Inject
    lateinit var notificationManager: NotificationsManager
    private var fusedLocationClient: FusedLocationProviderClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        com.example.affirmations.utils.Log.log(TAG, "onCreate")
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //link to intent
        com.example.affirmations.utils.Log.log(TAG_INTENT, intent?.data.toString())
        parseLinks(intent?.data.toString())

        //permissions
        //requestLocations()

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bNav)

        /*bottomNavigationView.menu.apply {
            clear()
            var order: Int = 0
            add(
                Menu.NONE,
                R.id.homeFragment,
                order++,
                resManager.getString(R.string.home_lable)
            )
            if (feature.available(FeatureFlag.Catalog)) {
                add(
                    Menu.NONE,
                    R.id.catalogFragment,
                    order++,
                    resManager.getString(R.string.catalog_lable)
                )
            }
            if (feature.available(FeatureFlag.PersonalAccount)) {
                add(
                    Menu.NONE,
                    R.id.accountFragment,
                    order++,
                    resManager.getString(R.string.account_lable)
                )
            }
            add(
                Menu.NONE,
                R.id.settingsFragment,
                order++,
                resManager.getString(R.string.settings_lable)
            )
        }*/

        bottomNavigationView.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {

                }
                R.id.catalogFragment -> {

                }
                R.id.accountFragment -> {

                }
                R.id.settingsFragment -> {

                }
            }
        }
        setupWithNavController(bottomNavigationView, navController)
        navHostProvider.setNavHost(this)
    }

    private fun parseLinks(link: String) {
        val pattern = setOf(ACTION_PATTERN).find { pattern ->
            pattern.matcher(link.toUri().path).matches()
        }
        when (pattern) {
            ACTION_PATTERN -> {
                Toast.makeText(this, link, Toast.LENGTH_SHORT).show()
            }
        }

    }
/*
    private fun requestLocations() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED -> {
                fusedLocationClient?.lastLocation?.addOnSuccessListener { location: Location? ->
                    resManager.showToast(
                        "latitude: ${location?.latitude}," +
                                " longitude: ${location?.longitude}", Toast.LENGTH_LONG
                    )
                }
                fusedLocationClient?.requestLocationUpdates(
                    createLocationRequest(),
                    locationCallback,
                    Looper.getMainLooper()
                )
            }
            ActivityCompat.shouldShowRequestPermissionRationale(
                this, Manifest.permission.ACCESS_COARSE_LOCATION
            ) -> {

            }
            else -> {
                requestPermissions(
                    arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                    REQUEST_CODE
                )
            }
        }
    }*/

    private fun openFrag(idContainer: Int, f: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(idContainer, f)
            .commit()
    }
/*
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE) {
            permissions.forEachIndexed { index, value ->
                if (value == Manifest.permission.ACCESS_COARSE_LOCATION &&
                    grantResults[index] == PackageManager.PERMISSION_GRANTED
                ) {
                    requestLocations()
                }
            }
        }
    }

    private fun createLocationRequest(): LocationRequest {
        val locationRequest = LocationRequest.create()
        locationRequest.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
        locationRequest.interval = 60 * 1000
        return locationRequest
    }

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            super.onLocationResult(locationResult)
            /*locationResult.lastLocation.let { location ->
                if (_userLocation.value != location && location != null) {
                    locationRepository.setLastLocation(location = location)
                    onLocationChanged(location)
                    _userLocation.value = location
                    removeLocationUpdates()
                }
            }*/
        }
    }
*/
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        com.example.affirmations.utils.Log.log(TAG_INTENT, intent?.data.toString())
    }

    override fun provideNavController(): NavController {
        return navController
    }

    override fun onStart() {
        com.example.affirmations.utils.Log.log(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        com.example.affirmations.utils.Log.log(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        com.example.affirmations.utils.Log.log(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        com.example.affirmations.utils.Log.log(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        com.example.affirmations.utils.Log.log(TAG, "onDestroy")
        navHostProvider.clearNavHost()
        super.onDestroy()
    }

    companion object {
        private val ACTION_PATTERN = Pattern.compile("^/actions/?\$")
        private const val TAG_INTENT = "myIntentActivity"
        private const val TAG = "MainActivity"
        private const val REQUEST_CODE = 101
    }
}
