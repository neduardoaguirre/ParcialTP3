package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.viewModel.PerfilViewModel

class UserFragment : Fragment() {

    private lateinit var imageViewProfile: ImageView
    private lateinit var textViewName: TextView
    private lateinit var viewModel : PerfilViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)

        imageViewProfile = view.findViewById(R.id.imageViewProfile)
        textViewName = view.findViewById(R.id.textViewName)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =  ViewModelProvider(requireActivity()).get(PerfilViewModel::class.java)
        textViewName.text = viewModel.username
    }
}

data class User(val profileImageResId: Int, val name: String)
