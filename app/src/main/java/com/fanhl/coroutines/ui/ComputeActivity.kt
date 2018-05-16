package com.fanhl.coroutines.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.fanhl.coroutines.R
import kotlinx.android.synthetic.main.activity_compute.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.toast

class ComputeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compute)

        btn_compute.setOnClickListener {
            launch(UI) {
                toast("start")
                val x = getCoroutinesX()
                val y = getCoroutinesX()
                toast("${x + y}")
            }
        }
    }

    private suspend fun getCoroutinesX(): Int {
        delay(2000)
        return 1
    }
}
