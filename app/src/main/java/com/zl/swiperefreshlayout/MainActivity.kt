package com.zl.swiperefreshlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


class MainActivity : AppCompatActivity() {
    private var myAdapter: RecyclerViewAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private lateinit var refreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private val listData: MutableList<Int> = ArrayList()
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setData()
        init()
    }

    private fun init() {

        layoutManager = LinearLayoutManager(this)
        refreshLayout = findViewById(R.id.refreshLayout)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.setLayoutManager(layoutManager)
        recyclerView.setItemAnimator(DefaultItemAnimator())

        myAdapter = RecyclerViewAdapter(this, listData)
        recyclerView.setAdapter(myAdapter)

        refreshLayout.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {
            override fun onRefresh() {
                // do something, such as re-request from server or other
                //设置刷新状态，false代表停止执行
                refreshLayout.isRefreshing = false
                setData()
            }

        })
        //可以改变下拉刷新时的颜色
        refreshLayout.setColorSchemeColors(getColor(R.color.colorAccent))
        //设置下拉进度的背景颜色
        refreshLayout.setProgressBackgroundColorSchemeColor(getColor(R.color.colorPrimaryDark))



    }

    private fun setData() {
        for (i in 0..2) {
            count += 1
            listData.add(count)
        }
    }


}