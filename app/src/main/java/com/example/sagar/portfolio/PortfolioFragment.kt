package com.example.sagar.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sagar.R

class PortfolioFragment : Fragment(), PortfolioCallback {

    private lateinit var mdata: MutableList<PortfolioItem>
    private lateinit var rvPortfolio: RecyclerView
    private lateinit var portfolioAdapter: PortfolioAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvPortfolio = view.findViewById(R.id.rv_portfolio)
        // Create a list of portfolio items
        mdata = mutableListOf(
            PortfolioItem(R.drawable.project7, "Project 7", "Project 7 Description"),
            PortfolioItem(R.drawable.project3, "Project 3", "Project 3 Description"),
            PortfolioItem(R.drawable.project5, "Project 5", "Project 5 Description"),
            PortfolioItem(R.drawable.project5, "Project 5", "Project 5 Description"),
            PortfolioItem(R.drawable.project0, "Project 0", "Project 0 Description"),
            PortfolioItem(R.drawable.project2, "Project 2", "Project 2 Description"),
            PortfolioItem(R.drawable.project3, "Project 3", "Project 3 Description"),
            PortfolioItem(R.drawable.project7, "Project 7", "Project 7 Description"),
            PortfolioItem(R.drawable.project1, "Project 1", "Project 1 Description")
        )

        portfolioAdapter = PortfolioAdapter(mdata, this)

        // Setup grid RecyclerView
        rvPortfolio.layoutManager = GridLayoutManager(activity, 3)
        rvPortfolio.adapter = portfolioAdapter
    }

    override fun onPortfolioItemClick(pos: Int) {
        // Handle click listener event when portfolio item is clicked

        // Create a fragment bottom sheet instance
        val portfolioFragmentDetails = PortfolioFragmentDetails()

        // Send portfolio item to portfolio dialog fragment
        val bundle = Bundle()
        bundle.putSerializable("object", mdata[pos])
        portfolioFragmentDetails.arguments = bundle

        // Open the portfolio bottom sheet fragment
        portfolioFragmentDetails.show(requireActivity().supportFragmentManager, "tagname")
    }
}
