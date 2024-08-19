package com.example.sagar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sagar.cv.CVFragment
import com.example.sagar.home.HomeFragment
import com.example.sagar.portfolio.PortfolioFragment
import com.example.sagar.sidemenu.Callback
import com.example.sagar.sidemenu.MenuAdapter
import com.example.sagar.sidemenu.MenuItem
import com.example.sagar.sidemenu.MenuUtil
import com.example.sagar.team.TeamFragment

class MainActivity : AppCompatActivity(), Callback {
    private lateinit var menuRv: RecyclerView
    private lateinit var menuItems: List<MenuItem>
    private lateinit var adapter: MenuAdapter
    private var selectedMenuPos: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        // setup side menu
        setupSideMenu()

        // set the default fragment when activity launches
        setHomeFragment()
    }

    private fun setupSideMenu() {
        menuRv = findViewById(R.id.rv_side_menu)

        // get menu list items from a static data class
        menuItems = MenuUtil.menuList
        adapter = MenuAdapter(menuItems, this)
        menuRv.layoutManager = LinearLayoutManager(this)
        menuRv.adapter = adapter
    }

    private fun setPortfolioFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.container, PortfolioFragment()).commit()
    }

    private fun setTeamFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.container, TeamFragment()).commit()
    }

    private fun setCVFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.container, CVFragment()).commit()
    }

    private fun setHomeFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()
    }

    override fun onSideMenuItemClick(i: Int) {
        when (menuItems[i].code) {
            MenuUtil.HOME_FRAGMENT_CODE -> setHomeFragment()
            MenuUtil.CV_FRAGMENT_CODE -> setCVFragment()
            MenuUtil.TEAM_FRAGMENT_CODE -> setTeamFragment()
            MenuUtil.PORTFOLIO_FRAGMENT_CODE -> setPortfolioFragment()
            else -> setHomeFragment()
        }

        // highlight the selected menu item
        menuItems[selectedMenuPos].isSelected = false
        menuItems[i].isSelected = true
        selectedMenuPos = i
        adapter.notifyDataSetChanged()
    }
}
