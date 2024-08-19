package com.example.sagar.cv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sagar.R

/**
 * A simple [Fragment] subclass.
 */
class CVFragment : Fragment() {

    private lateinit var rvCv: RecyclerView
    private lateinit var adapter: CVAdapter
    private lateinit var items: MutableList<CVItem>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCv = view.findViewById(R.id.recyclerview_cv)

        // create a list of cv items
        items = mutableListOf(
            CVItem("20 April 2023", getString(R.string.lorem_text1)),
            CVItem("20 May 2024", getString(R.string.lorem_text3)),
            CVItem("25 July 2024", getString(R.string.lorem_text4)),
            CVItem("20 April 2024", getString(R.string.lorem_text5)),
            CVItem("20 August 2024", getString(R.string.lorem_text6))
        )

        adapter = CVAdapter(items)
        rvCv.layoutManager = LinearLayoutManager(context)
        rvCv.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cv, container, false)
    }
}
