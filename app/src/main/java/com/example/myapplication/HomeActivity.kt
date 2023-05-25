package com.example.myapplication

import CarsModel.Car
import CarsModel.CarsResponse
import RecyclerViewAdapter.CarsAdapter
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.viewModel.PerfilViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import APIServiceBuilder.APIServiceBuilder

class HomeActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{

    private lateinit var drawer : DrawerLayout
    private lateinit var toggle : ActionBarDrawerToggle
    private lateinit var viewModel : PerfilViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.home_layout)

        toggle = ActionBarDrawerToggle( this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer. addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R. id.nav_view)
        navigationView. setNavigationItemSelectedListener(this)

        viewModel = ViewModelProvider(this)[PerfilViewModel::class.java]
        viewModel.username  = intent.getStringExtra("username").toString()

        println(viewModel.username)
        Toast.makeText(this, viewModel.username, Toast.LENGTH_SHORT).show()

        getActivity()

    }

    private fun getActivity() {
        val service = APIServiceBuilder.create()

        service.getCarsList("NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4").enqueue(object: Callback<List<Car>> {
            override fun onResponse(
                call: Call<List<Car>>,
                response: Response<List<Car>>
            ) {
                Toast.makeText(this@HomeActivity, "Response obtenida", Toast.LENGTH_LONG).show()

                showData(response.body()!!)
            }

            override fun onFailure(call: Call<List<Car>>, t: Throwable) {

                Toast.makeText(this@HomeActivity, "No se pudo obtener Response", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun showData(carList: List<Car>) {

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = CarsAdapter(carList)
        }

             }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //En este metodo escuchamos cada vez que clikeamos va a imprimir un toast, se puede utilizar para darle funcionalidad al presionar un item
        when(item.itemId){
            R.id.nav_item_one -> Toast.makeText(this,"Item 1", Toast.LENGTH_SHORT).show()
            R.id.nav_item_two -> Toast.makeText(this,"Item 2", Toast.LENGTH_SHORT).show()
            R.id.nav_item_three -> Toast.makeText(this,"Item 3", Toast.LENGTH_SHORT).show()
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}