package com.weixin.wuyezhiguhun.ydandroid.ydjoke.activity

import android.databinding.DataBindingUtil
import android.databinding.DataBindingUtil.setContentView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.recyclerview.R.attr.layoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.weixin.wuyezhiguhun.ydandroid.R
import com.weixin.wuyezhiguhun.ydandroid.ydjoke.adapter.YDJokeAdapter
import com.weixin.wuyezhiguhun.ydandroid.ydjoke.data.YDJokeInfo
import com.weixin.wuyezhiguhun.ydandroid.ydjoke.viewmodel.YDJokeViewModel
import com.weixin.wuyezhiguhun.ydandroid.databinding.ActivityYdJokeBinding

class YDJokeActivity : AppCompatActivity() {

    val jokeViewModel: YDJokeViewModel = YDJokeViewModel()
    val dataArray: ArrayList<YDJokeInfo> = jokeViewModel.dataList
    val  mAdapter by lazy {
        YDJokeAdapter(this, R.layout.item_yd_joke, dataArray)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_yd_joke)
        val binding = DataBindingUtil.setContentView<ActivityYdJokeBinding>(this, R.layout.activity_yd_joke)
        binding.apply {
            jokeRecyclerView.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(this@YDJokeActivity)
            }
        }
        jokeViewModel.setJokeXiaohuaData(1, 20)

    }

    fun buttonTouch(view: View) {
        when (view.id) {

            R.id.navigation_back -> {
                println("wuyezhiguhun" + " *---* " + "返回")
                finish()
            }

            else -> {
                println("wuyezhiguhun" + " *---* ")
            }
        }
    }
}