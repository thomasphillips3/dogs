package com.thomasphillips3.dogs.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.thomasphillips3.dogs.R
import com.thomasphillips3.dogs.model.DogBreed
import com.thomasphillips3.dogs.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private val dogsListAdapter = DogsListAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        dogsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dogsListAdapter
        }

        refreshLayout.setOnRefreshListener {
            dogsList.visibility = View.GONE
            listError.visibility = View.GONE
            loadingView.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    fun observeViewModel() {
        viewModel.dogs.observe(this, Observer {dogs ->
            dogs?.let {
                dogsList.visibility = View.VISIBLE
                dogsListAdapter.updateDogList(dogs)
            }
        })

        viewModel.dogsLoadError.observe(this, Observer {isError ->
            isError?.let {
                listError.visibility = if(it) View.VISIBLE else View.GONE
            }
        })

        viewModel.loading.observe(this, Observer {isLoading ->
            isLoading?.let {
                loadingView.visibility = if(it) View.VISIBLE else View.GONE

                if(it) {
                    dogsList.visibility = View.GONE
                    listError.visibility = View.GONE
                }
            }
        })
    }
}
