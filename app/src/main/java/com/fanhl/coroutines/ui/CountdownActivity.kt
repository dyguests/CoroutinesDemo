package com.fanhl.coroutines.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fanhl.coroutines.R
import kotlinx.android.synthetic.main.activity_countdown.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

/**
 * 倒计时
 */
class CountdownActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countdown)

        launch(UI) {
            for (i in 10 downTo 1) { // countdown from 10 to 1
                hello.text = "Countdown $i ..." // update text
                delay(500) // wait half a second
            }
            hello.text = "Done!"
        }
    }

    suspend fun doSomething(i: Int): Int {
        Thread.sleep(1000)
        return i * 2
    }
}
