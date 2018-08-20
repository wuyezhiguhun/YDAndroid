package com.weixin.wuyezhiguhun.ydandroid.ydjoke.activity

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.DataBindingUtil.setContentView
import android.os.Bundle
import android.support.v7.recyclerview.R.attr.layoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.weixin.wuyezhiguhun.ydandroid.R
import com.weixin.wuyezhiguhun.ydandroid.ydjoke.adapter.YDJokeAdapter
import com.weixin.wuyezhiguhun.ydandroid.ydjoke.data.YDJokeInfo
import com.weixin.wuyezhiguhun.ydandroid.ydjoke.viewmodel.YDJokeViewModel
import com.weixin.wuyezhiguhun.ydandroid.databinding.ActivityYdJokeBinding


class YDJokeActivity : Activity() {



    val jokeViewModel: YDJokeViewModel = YDJokeViewModel()
    val dataArray: ArrayList<YDJokeInfo> = jokeViewModel.dataList
    val  mAdapter by lazy {
        YDJokeAdapter(this, R.layout.item_yd_joke, jokeViewModel.dataList)
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


//        val viewModelBack = YDViewModelBack()
//
//        jokeViewModel.viewModelBack = viewModelBack

//        jokeViewModel.setListeren {
//            println("wuyezhiguhun *-----* Block回调")
//            mAdapter.notifyDataSetChanged()
//        }


        jokeViewModel.setListeren(object : YDJokeViewModel.YDJokeViewModelBack {
            override fun networkingFailure() {
                println("wuyezhiguhun *---back---* " + "网络请求失败！")
            }

            override fun networkingSuccess() {
                println("wuyezhiguhun *---back---* " + "网络请求成功！")

                runOnUiThread {
                    println("wuyezhiguhun *------* " + "更新UI")
                    for (jokeInfo in jokeViewModel.dataList) {
                        println("wuyezhiguhun *---* " + jokeInfo.content)
                    }
                    mAdapter.notifyDataSetChanged()
//                    mAdapter.notifyItemChanged(1)
                }
            }
        })
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