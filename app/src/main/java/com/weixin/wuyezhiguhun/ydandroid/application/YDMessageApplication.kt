package com.weixin.wuyezhiguhun.ydandroid.application

import android.app.Application
import android.content.Context
import com.alibaba.sdk.android.push.CommonCallback
import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory


class YDMessageApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initCloudChannel(this)
        println("wuyezhiguhun" + "注册阿里云")
    }

    /**
     * 初始化云推送通道
     * @param applicationContext
     */
    private fun initCloudChannel(applicationContext: Context) {
        PushServiceFactory.init(applicationContext)
        val pushService = PushServiceFactory.getCloudPushService()
        pushService.register(applicationContext, object : CommonCallback {
            override fun onSuccess(response: String) {
                println("wuyezhiguhun" + "注册阿里云成功回调" + response)
            }

            override fun onFailed(errorCode: String, errorMessage: String) {
                println("wuyezhiguhun" + "注册阿里云失败回调" + errorMessage)
            }
        })
    }
}