package uk.co.jordanterry.eraser_samples

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class EraserSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eraser_sample)

        val objectAnimator = ObjectAnimator
            .ofFloat(findViewById(R.id.box_one), "alpha", 0.0f, 1.0f)

        erase(objectAnimator)

        objectAnimator.start()

    }
}

class TestFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        erase()
    }
}