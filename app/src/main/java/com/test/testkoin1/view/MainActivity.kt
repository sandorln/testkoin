package com.test.testkoin1.view

import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.test.testkoin1.R
import com.test.testkoin1.adapter.RandomPagingAdapter
import com.test.testkoin1.databinding.ActivityMainBinding
import com.test.testkoin1.viewmodel.RandomPagingViewModel
import org.koin.android.ext.android.inject


class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val randomPagingViewModel: RandomPagingViewModel by inject()

    val randomPagingAdapter: RandomPagingAdapter = RandomPagingAdapter()

    override fun getLayoutRes(): Int = R.layout.activity_main
    override fun getToolbar(): Toolbar? = binding.toolbar

    override fun initBindingSetting() {
        binding.act = this
        binding.randomPagingVM = randomPagingViewModel
    }

    override fun initObjectSetting() {
    }

    override fun initViewSetting() {
        binding.rvUser.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (recyclerView.scrollState == RecyclerView.SCROLL_STATE_SETTLING ||
                    recyclerView.scrollState == RecyclerView.SCROLL_STATE_DRAGGING
                )
                    binding.fab.hide()
                else
                    binding.fab.show()
            }
        })

        binding.fab.setOnClickListener {
            binding.rvUser.smoothScrollToPosition(0)
            binding.appbarLayout.setExpanded(true)
        }
    }

    override fun initObserverSetting() {
        randomPagingViewModel.randomUserDataList.observe(this, Observer {
            randomPagingAdapter.submitList(it)
            randomPagingAdapter.notifyDataSetChanged()
        })

        randomPagingViewModel.errorMsg.observe(this, Observer {
            if (it.isNotEmpty())
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.menu_refresh -> {
            randomPagingAdapter.submitList(null)
            randomPagingViewModel.refreshRandomUserData()
            super.onOptionsItemSelected(item)
        }
        else -> super.onOptionsItemSelected(item)
    }
}