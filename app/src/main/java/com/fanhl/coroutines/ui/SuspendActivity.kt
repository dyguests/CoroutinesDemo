package com.fanhl.coroutines.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.fanhl.coroutines.R
import kotlinx.android.synthetic.main.activity_suspend.*
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.doAsync
import kotlin.concurrent.thread

class SuspendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suspend)

        btn_suspend.setOnClickListener {
            //            doSomething(1) //error

            async {
                doSomething(1)

                (0..1).forEach {
                    doSomething(1)
                }

                thread {
                    //                    doSomething(1) //error
                }

                Derived().foo() //error
            }
        }
    }

    suspend fun doSomething(i: Int): Int {
        return i * 2
    }
}

interface Base {
    suspend fun foo(): Int
}

class Derived : Base {
    override suspend fun foo(): Int {
        return 233
    }
}