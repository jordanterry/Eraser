package uk.co.jordanterry.eraser

import android.animation.Animator
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import uk.co.jordanterry.eraser.observers.AnimatorLifecycleObserver

/**
 * Handle the lifecycle functions of an [Animator] as per the lifecycle of an Activity.
 *
 * * When the Activity is paused, [Animator.pause] will be called
 * * When the Activity is resumed, [Animator.resume] will be called
 * * When the Activity is destroyed, [Animator.cancel] will be called all listeners will be remove from the animator
 *
 * @param animator that must be erased
 */
fun ComponentActivity.erase(animator: Animator) {
    lifecycle.addObserver(AnimatorLifecycleObserver(animator))
}


fun Animator.eraseWith(lifecycleOwner: LifecycleOwner) {
    lifecycleOwner.lifecycle.addObserver(AnimatorLifecycleObserver(this))
}

/**
 * Handle the lifecycle functions of an [Animator] as per the lifecycle of a Fragment's View.
 *
 * * When the Fragment is paused, [Animator.pause] will be called
 * * When the Fragment is resumed, [Animator.resume] will be called
 * * When the Fragment's View is destroyed, [Animator.cancel] will be called all listeners will be remove from the animator
 *
 * @param animator that must be erased
 */
fun Fragment.erase(animator: Animator) {
    viewLifecycleOwner.lifecycle.addObserver(AnimatorLifecycleObserver(animator))
}
