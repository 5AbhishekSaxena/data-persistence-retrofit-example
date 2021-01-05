package tech.developingdeveloper.datapersistenceretrofitexample.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import tech.developingdeveloper.datapersistenceretrofitexample.databinding.FragmentHomeBinding


/**
 * @author Abhishek Saxena
 * @since 06-01-2021 02:21
 */

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentHomeBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = homeViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.dogRecyclerView.apply {
            adapter = DogAdapter()

            layoutManager =
                GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        }
        binding.executePendingBindings()

    }
}