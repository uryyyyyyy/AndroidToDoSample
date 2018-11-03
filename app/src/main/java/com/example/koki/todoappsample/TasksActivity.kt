package com.example.koki.todoappsample

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import com.example.koki.todoappsample.databinding.TasksActivityBinding
import java.util.*


class TasksActivity : AppCompatActivity(), TasksNavigator {

    override fun addNewTask() {
        val intent = Intent(this, AddEditTaskActivity::class.java)
        startActivityForResult(intent, 1)
    }

    private var mDrawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<TasksActivityBinding>(this, R.layout.tasks_activity)
        val vm = TasksViewModel(this)
        binding.viewmodel = vm
        setupToolbar()
        setupNavigationDrawer()
        setupListView()
    }

    private fun setupListView() {
        val recyclerView = findViewById<RecyclerView>(R.id.tasks_list)
        val lm = LinearLayoutManager(this)
        val adap = TasksAdapter(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"))
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = lm
            adapter = adap
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Open the navigation drawer when the home icon is selected from the toolbar.
                mDrawerLayout!!.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar
        ab!!.setHomeAsUpIndicator(R.drawable.ic_menu)
        ab.setDisplayHomeAsUpEnabled(true)
    }


    private fun setupNavigationDrawer() {
        this.mDrawerLayout = findViewById(R.id.drawer_layout)
        this.mDrawerLayout!!.setStatusBarBackground(R.color.colorPrimaryDark)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        if (navigationView != null) {
            setupDrawerContent(navigationView)
        }
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.list_navigation_menu_item -> {
                    Log.i("myapp", "intent to menu")
                }
                R.id.statistics_navigation_menu_item -> {
//                    val intent = Intent(this@TasksActivity, StatisticsActivity::class.java)
//                    startActivity(intent)
                    Log.i("myapp", "intent to statistics")
                }
                else -> {
                }
            }// Do nothing, we're already on that screen
            // Close the navigation drawer when an item is selected.
            menuItem.isChecked = true
            this.mDrawerLayout!!.closeDrawers()
            true
        }
    }

}
