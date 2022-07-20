package com.matrix87.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.matrix87.adapter.ProductsAdapter
import com.matrix87.practicalapp.R
import com.matrix87.repository.Repository
import com.matrix87.room.Product
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


    lateinit var adapter: ProductsAdapter
    lateinit var repository: Repository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repository = Repository(requireContext())



        try {

            repository.addCustomer(
                Product(
                    1,
                    "https://png.pngtree.com/png-vector/20201128/ourmid/pngtree-casual-shoes-png-image_2394294.jpg",
                    "Shoes",
                    "My Shoes"
                )
            )
            repository.addCustomer(
                Product(
                    2,
                    "https://i.pinimg.com/originals/f5/d1/8b/f5d18bb853c6f62199435444ecd4cf82.png",
                    "Sport",
                    "My Sort ", detail = " hkjskfjklsfjldskjf"
                )
            )

            Toast.makeText(requireContext(), "adddddd", Toast.LENGTH_SHORT).show()


        } catch (e: Exception) {

            Log.d("MyTag", e.message.toString())
        }


        rView.layoutManager = LinearLayoutManager(context)

        adapter = ProductsAdapter()
        adapter.products = repository.getAllCustomers()

        rView.adapter = adapter

        adapter.onclick = { product->

            Toast.makeText(requireContext(), product.detail.toString(), Toast.LENGTH_SHORT).show()

        }

    }


}