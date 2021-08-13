package uk.co.jordanterry.eraser_samples

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.addListener
import uk.co.jordanterry.eraser.erase

class EraserSampleActivity : AppCompatActivity() {

    private val startButton: Button by lazy {
        findViewById<Button>(R.id.start_animation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eraser_sample)
        startButton.setOnClickListener {
            startObjectAnimator()
        }
    }

    private fun startObjectAnimator() {
        ObjectAnimator
            .ofFloat(findViewById(R.id.box_one), "alpha", 0.0f, 1.0f).apply {
                repeatCount = 10
                repeatMode = ObjectAnimator.REVERSE
                addPauseListener(object : Animator.AnimatorPauseListener {
                    override fun onAnimationPause(animation: Animator?) {
                        Log.d(TAG, "Animation is paused")
                    }

                    override fun onAnimationResume(animation: Animator?) {
                        Log.d(TAG, "Animation is resumed")
                    }
                })
                addListener(onStart = {
                    startButton.isEnabled = false
                }, onEnd = {
                    startButton.isEnabled = true
                })
            }.apply {
                erase(this)
                start()
            }
    }

    companion object {
        private const val TAG: String = "EraserSampleActivity"
    }
}

