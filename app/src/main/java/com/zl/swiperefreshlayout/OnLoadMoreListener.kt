package com.zl.swiperefreshlayout

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*


abstract class OnLoadMoreListener: RecyclerView.OnScrollListener() {
    private var countItem = 0
    private var lastItem = 0
    private var isScrolled = false //是否可以滑动

    private var isAllScreen = false //是否充满全屏

    private var layoutManager: RecyclerView.LayoutManager? = null

    /**
     * 加载接口
     *
     * @param countItem 总数量
     * @param lastItem  最后显示的position
     */
    protected abstract fun onLoading(countItem: Int, lastItem: Int)

    fun onScrollStateChanged(newState: Int) {
        if (newState == SCROLL_STATE_IDLE) {
            Log.d("test", "SCROLL_STATE_IDLE,空闲")
        } else if (newState == SCROLL_STATE_DRAGGING) {
            Log.d("test", "SCROLL_STATE_DRAGGING,拖拽")
        } else if (newState == SCROLL_STATE_SETTLING) {
            Log.d("test", "SCROLL_STATE_SETTLING,固定")
        } else {
            Log.d("test", "其它")
        }
        //拖拽或者惯性滑动时isScolled设置为true
        if (newState == SCROLL_STATE_DRAGGING || newState == SCROLL_STATE_SETTLING) {
            isScrolled = true
            isAllScreen = true
        } else {
            isScrolled = false
        }
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        if (recyclerView.layoutManager is LinearLayoutManager) {
            layoutManager = recyclerView.layoutManager
            countItem = layoutManager!!.itemCount
            lastItem = (layoutManager as LinearLayoutManager?)!!.findLastCompletelyVisibleItemPosition()
        }
        if (isScrolled && countItem != lastItem && lastItem == countItem - 1) {
            onLoading(countItem, lastItem)
        }
    }

    fun isAllScreen(): Boolean {
        return isAllScreen
    }
}