package com.example.ejercicio_2

import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private var mediaPlayer:MediaPlayer?=null
    private var position: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.btcheck).setOnClickListener {
            startActivity(Intent(this, dialogo::class.java))
        }
        Log.i("lifeCycle", "OnCreate")
    }

    override fun onStart() {
        super.onStart()
        mediaPlayer= MediaPlayer.create(this, R.raw.ai_2)

        Log.i("lifeCycle", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
        Log.i("lifeCycle", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
        if (mediaPlayer !=null)
            position=mediaPlayer!!.currentPosition
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer=null
        Log.i("lifeCycle", "OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("lifeCycle", "OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("lifeCycle", "OnDestroy")
    }
}