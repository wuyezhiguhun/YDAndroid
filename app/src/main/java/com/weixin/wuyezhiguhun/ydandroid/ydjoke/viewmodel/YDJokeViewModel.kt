package com.weixin.wuyezhiguhun.ydandroid.ydjoke.viewmodel

import com.weixin.wuyezhiguhun.ydandroid.ydjoke.data.YDJokeInfo
import java.util.*

class YDJokeViewModel {

    val dataList: ArrayList<YDJokeInfo> = ArrayList()

    init {
        addDataList()
    }

    fun addDataList() : ArrayList<YDJokeInfo> {
        val textArray: ArrayList<String> = ArrayList()
        textArray.add("你站在桥上看风景，看风景的人在桥上看你；明月装饰了你的窗子，你装饰了别人的梦！")
        textArray.add("死生契阔，与子成说。执子之手，与子偕老。")
        textArray.add("有美人兮，见之不忘，一日不见兮，思之如狂。")
        textArray.add("君若扬路尘，妾若浊水泥，浮沈各异势，会合何时谐？")
        textArray.add("如何让你遇见我，在我最美丽的时刻为这，我已在佛前求了五百年，求他让我们结一段尘缘。")
        textArray.add("自君之出矣，明镜暗不治。思君如流水，何有穷已时。")


        for (i in 1..20) {
            val homeInfo: YDJokeInfo = YDJokeInfo()
            val random: Int = Random().nextInt(6)
            homeInfo.content = textArray.get(random)
            val number: Int = Random().nextInt(13) + 1
            homeInfo.image_name = "anime_" + number.toString()
            dataList.add(homeInfo)
        }
        return dataList
    }

    //网络请求数据
    fun setJokeData(pageIndex: Int,pageSize: Int) {

    }

}