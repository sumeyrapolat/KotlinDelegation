package com.sumeyra.delegationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

//class ımda birden fazla sınıfan inheritance alamıyorum onun yerine interface kullanabilirim
//bu şekilde interface in functions override etmeme gerek yok işimi LifecycleLoggerImplementation a delege ettim.
class MainActivity : AppCompatActivity(), LifecycleLogger by LifecycleLoggerImplementation(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerLifecycleOwner(this@MainActivity)
    }
}


// bir interface oluşturuyorum
interface LifecycleLogger{
    fun registerLifecycleOwner(owner: LifecycleOwner)
}

class LifecycleLoggerImplementation : LifecycleLogger, LifecycleEventObserver{
    override fun registerLifecycleOwner(owner: LifecycleOwner) {
        owner.lifecycle.addObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event){
            Lifecycle.Event.ON_CREATE -> println("ON CREATE")
            Lifecycle.Event.ON_RESUME -> println("ON RESUME")
            Lifecycle.Event.ON_PAUSE -> println("ON PAUSE")
            Lifecycle.Event.ON_START -> println("ON START")
            Lifecycle.Event.ON_ANY   -> println("ON ANY")
            Lifecycle.Event.ON_STOP -> println("ON STOP")
            Lifecycle.Event.ON_DESTROY -> println("ON DESTROY")
            else -> Unit
        }
    }

}