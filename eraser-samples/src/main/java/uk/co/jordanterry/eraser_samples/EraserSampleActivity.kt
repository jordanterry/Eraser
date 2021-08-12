package uk.co.jordanterry.eraser_samples

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import uk.co.jordanterry.eraser.eraseWith

class EraserSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eraser_sample)

        val objectAnimator = ObjectAnimator
            .ofFloat(findViewById(R.id.box_one), "alpha", 0.0f, 1.0f).apply {
                repeatCount = ObjectAnimator.INFINITE
                repeatMode = ObjectAnimator.REVERSE
                eraseWith(this@EraserSampleActivity)
                addPauseListener(object : Animator.AnimatorPauseListener {
                    override fun onAnimationPause(animation: Animator?) {
                        Log.d(TAG, "Animation is paused")
                    }

                    override fun onAnimationResume(animation: Animator?) {
                        Log.d(TAG, "Animation is resumed")
                    }
                })
            }
        objectAnimator.start()
    }

    companion object {
        private const val TAG: String = "EraserSampleActivity"
    }
}

