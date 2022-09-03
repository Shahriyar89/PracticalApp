package com.matrix87.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.matrix87.practicalapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.nnav_graph)
        navController.setGraph(navGraph, intent.extras)

        Log.e("Tag", "My tag dfjkdlfjldkfj;sdlkfjsdlkf")

        val appBarConfiguration =
            AppBarConfiguration(setOf(
                R.id.homeFragment,
                R.id.addFragment2,
                R.id.searchFragment,
                R.id.settingFragment
            ))
        setupActionBarWithNavController(navController, appBarConfiguration)
//        bottomView.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.homeMenu->navController.navigate(R.id.homeFragment)
//                R.id.addMenu->navController.navigate(R.id.addFragment2)
//                R.id.searchMenu->navController.navigate(R.id.searchFragment)
//                R.id.settingMenu->navController.navigate(R.id.settingFragment)
//            }
//            true
//        }

        bottomView.setupWithNavController(navController)
    }
}