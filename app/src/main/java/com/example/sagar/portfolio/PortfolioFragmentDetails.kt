package com.example.sagar.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.sagar.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PortfolioFragmentDetails : BottomSheetDialogFragment() {

    private lateinit var imgPortfolio: ImageView
    private lateinit var title: TextView
    private lateinit var description: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imgPortfolio = view.findViewById(R.id.portfolio_details_img)
        title = view.findViewById(R.id.portfolio_details_title)
        description = view.findViewById(R.id.portfolio_details_desc)

        // Get the portfolio object from the bundle
        val bundle = arguments
        val item = bundle?.getSerializable("object") as? PortfolioItem

        // Load the portfolio data
        loadPortfolioData(item)
    }

    private fun loadPortfolioData(item: PortfolioItem?) {
        item?.let {
            Glide.with(requireContext()).load(it.imageResId).into(imgPortfolio)
            title.text = it.title
            description.text = it.description
        }
    }
}
