package com.example.myapplication

import CarsModel.Car
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.viewModel.PerfilViewModel
import com.google.android.material.navigation.NavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import APIServiceBuilder.APIServiceBuilder
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import fragments.AutosFragment
import fragments.HomeFragment
import fragments.SearchFragment
import fragments.SettingsFragment
import fragments.UserFragment
import github.com.st235.lib_expandablebottombar.ExpandableBottomBar


class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel : PerfilViewModel
    private lateinit var navigationView: NavigationView
    private lateinit var drawer: DrawerLayout
    private lateinit var headerView: View
    private lateinit var textUsernameNavHeader : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        changeFragment(HomeFragment())

        viewModel = ViewModelProvider(this).get(PerfilViewModel::class.java)
        viewModel.username  = intent.getStringExtra("username").toString()

        //Drawer
        var toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.home_layout)
        navigationView = findViewById(R.id.navigation_view)
        val drawerToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        //Seteo Username en navHeader
        headerView = navigationView.getHeaderView(0)
        textUsernameNavHeader = headerView.findViewById(R.id.nav_header_username)
        textUsernameNavHeader.text = viewModel.username

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Manejar la selección del elemento del menú aquí
            when (menuItem.itemId) {
                R.id.nav_perfil -> {
                    changeFragment(UserFragment())
                    drawer.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_configuration -> {
                    changeFragment(SettingsFragment())
                    drawer.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_favorites -> {
                    Toast.makeText(this, "nav_favorites", Toast.LENGTH_LONG).show()
                    drawer.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }

        }

        //bottom navigation
        val bottomBar: ExpandableBottomBar = findViewById(R.id.expandable_bottom_bar)

        bottomBar.onItemSelectedListener = { view, menuItem,True ->
            when(menuItem.id){
                R.id.home_btn_bar -> changeFragment(HomeFragment())
                R.id.shop_btn_bar -> changeFragment(AutosFragment())
                R.id.search_btn_bar -> changeFragment(SearchFragment())
                R.id.perfil_btn_bar -> changeFragment(UserFragment())
            }

        }
    }

    private fun changeFragment(fragment: Fragment){
        val fragmentVar = supportFragmentManager.beginTransaction()
        fragmentVar.replace(R.id.fragmentContainerView, fragment).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    }