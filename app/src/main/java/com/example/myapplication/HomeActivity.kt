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
import android.graphics.Color
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import fragments.AutosFragment
import fragments.HomeContent
import fragments.SearchFragment
import fragments.UserFragment
import github.com.st235.lib_expandablebottombar.ExpandableBottomBar
import github.com.st235.lib_expandablebottombar.MenuItemDescriptor




class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel : PerfilViewModel
    private lateinit var navigationView: NavigationView
    private lateinit var drawer: DrawerLayout
    //lateinit var binding:

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Drawer
        setSupportActionBar(findViewById(R.id.toolbar))

        drawer = findViewById(R.id.home_layout)
        navigationView = findViewById(R.id.navigation_view)
        val drawerToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Manejar la selección del elemento del menú aquí
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Lógica para el elemento 1
                    Toast.makeText(this, "nav_home", Toast.LENGTH_LONG).show()
                    changeFragment(HomeContent())
                    true
                }
                R.id.nav_configuration -> {
                    // Lógica para el elemento 2
                    Toast.makeText(this, "nav_configuration", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.nav_favorites -> {
                    // Lógica para el elemento 3
                    Toast.makeText(this, "nav_favorites", Toast.LENGTH_LONG).show()
                    true
                }
                // Agrega más casos según tus necesidades
                else -> false
            }
        }


//        changeFragment(HomeContent())

        viewModel = ViewModelProvider(this)[PerfilViewModel::class.java]
        viewModel.username  = intent.getStringExtra("username").toString()

        getActivity()


        //bottom navigation
        val bottomBar: ExpandableBottomBar = findViewById(R.id.expandable_bottom_bar)

        bottomBar.onItemReselectedListener = { view, menuItem,True ->

            when(menuItem.id){
                R.id.home_btn_bar -> changeFragment(HomeContent())
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

//                findViewById<RecyclerView>(R.id.recyclerView).apply {
//                    layoutManager = LinearLayoutManager(this@HomeActivity)
//                    adapter = CarsAdapter(carList)
//                }

             }

}