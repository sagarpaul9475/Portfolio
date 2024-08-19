package com.example.sagar.portfolio

import android.icu.text.CaseMap.Title
import java.io.Serializable

data class PortfolioItem(
    val imageResId: Int,
    val title: String,
    val description: String
) : Serializable
