package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import github.com.st235.lib_expandablebottombar.ExpandableBottomBar

class SettingsFragment : Fragment() {

    private lateinit var bottomNavigationView : ExpandableBottomBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomNavigationView = requireActivity().findViewById<ExpandableBottomBar>(R.id.expandable_bottom_bar)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onResume() {
        super.onResume()
        bottomNavigationView.visibility = View.GONE
    }

    override fun onPause() {
        super.onPause()
        bottomNavigationView.visibility = View.VISIBLE
    }

}