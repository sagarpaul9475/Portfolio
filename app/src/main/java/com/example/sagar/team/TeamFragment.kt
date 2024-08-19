package com.example.sagar.team

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
class TeamFragment : Fragment() {
    private lateinit var rvTeam: RecyclerView
    private lateinit var adapter: TeamAdapter
    private lateinit var mdata: MutableList<TeamItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvTeam = view.findViewById(R.id.rv_team)

        // Create list of team items
        val item = TeamItem("John Doe", getString(R.string.lorem_text2), R.drawable.user)
        val item2 = TeamItem("Ahmed Ali", getString(R.string.lorem_text2), R.drawable.uservoyager)
        val item3 = TeamItem("Islam Ahmed", getString(R.string.lorem_text2), R.drawable.userspace)

        mdata = mutableListOf(item, item2, item3)

        // Setup adapter and RecyclerView
        rvTeam.layoutManager = LinearLayoutManager(context)
        adapter = TeamAdapter(mdata)
        rvTeam.adapter = adapter
    }
}
