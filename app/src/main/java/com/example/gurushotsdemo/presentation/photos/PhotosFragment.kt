package com.example.gurushotsdemo.presentation.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gurushotsdemo.R
import com.example.gurushotsdemo.databinding.FragmentPhotosBinding
import kotlinx.coroutines.launch

class PhotosFragment : Fragment() {

    private var _binding: FragmentPhotosBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PhotosViewModel by activityViewModels()

    private var adapter: ListPhotoAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotosBinding.inflate(inflater, container, false)

        setupRecycler()
        setupViewModelCollectors()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        adapter = null
    }

    private fun setupRecycler() {
        adapter = ListPhotoAdapter(onItemClick = { photoId ->
            val action = PhotosFragmentDirections.actionPhotosFragmentToPhotoFragment(photoId)
            findNavController().navigate(action)
        })

        binding.recyclerView.adapter = adapter

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = binding.recyclerView.layoutManager as LinearLayoutManager

                if (layoutManager.findLastVisibleItemPosition() > layoutManager.itemCount - REMAINING_PHOTO) {
                    viewModel.loadMorePhoto()
                }
            }
        })
    }

    private fun setupViewModelCollectors() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.photoIds.collect {
                    adapter?.submitList(it)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.sideEffect.collect {
                    Toast.makeText(
                        context, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    companion object {
        const val REMAINING_PHOTO = 5
    }
}
