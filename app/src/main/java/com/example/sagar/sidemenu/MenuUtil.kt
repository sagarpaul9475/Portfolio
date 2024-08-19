package com.example.sagar.sidemenu

import com.example.sagar.R

object MenuUtil {
    const val HOME_FRAGMENT_CODE: Int = 0
    const val CV_FRAGMENT_CODE: Int = 1
    const val PORTFOLIO_FRAGMENT_CODE: Int = 2
    const val TEAM_FRAGMENT_CODE: Int = 3

    val menuList: List<MenuItem>
        get() {
            val list: MutableList<MenuItem> = ArrayList()
            // first menu item is selected
            list.add(MenuItem(R.drawable.ic_baseline_home_24, HOME_FRAGMENT_CODE, true))
            list.add(MenuItem(R.drawable.ic_baseline_school_24, CV_FRAGMENT_CODE, false))
            list.add(MenuItem(R.drawable.ic_baseline_group_24, TEAM_FRAGMENT_CODE, false))
            list.add(MenuItem(R.drawable.ic_baseline_dashboard_24, PORTFOLIO_FRAGMENT_CODE, false))

            return list
        }
}
