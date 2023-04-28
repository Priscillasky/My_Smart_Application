package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton



class MainActivity : AppCompatActivity() {
    private lateinit var mAddFab:FloatingActionButton
    private lateinit var mAddAlarmFab:FloatingActionButton
    private lateinit var mAddSupportFab:FloatingActionButton
    private lateinit var mAddContactFab:FloatingActionButton

    private lateinit var addAlarmActionText:TextView
    private lateinit var addSupportActionText:TextView
    private lateinit var addCloudText:TextView




    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        replaceFragment(FavouriteFragment())
        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.fav ->replaceFragment(FavouriteFragment())
                R.id.things ->replaceFragment(FirstFragment())
                R.id.routines ->replaceFragment(RoutinesFragment())
                R.id.id ->replaceFragment(idFragment())
                R.id.settings ->replaceFragment(SettingsFragment())

                else ->{

                }
            }
            true
        }

    }
    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

    }

    fun onadd_fab(view: View) {

        binding.addAlarmFab.visibility = View.VISIBLE
        binding.addCloudText.visibility = View.VISIBLE
        binding.addContactFab.visibility = View.VISIBLE
        binding.addAlarmActionText.visibility = View.VISIBLE
        binding.addSupportActionText.visibility = View.VISIBLE
        binding.addSupportFab.visibility = View.VISIBLE
    }
}