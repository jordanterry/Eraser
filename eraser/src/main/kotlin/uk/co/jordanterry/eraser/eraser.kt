package uk.co.jordanterry.eraser

import android.animation.Animator
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

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
    lifecycle.addObserver(EraserLifecycleObserver(animator))
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
    viewLifecycleOwner.lifecycle.addObserver(EraserLifecycleObserver(animator))
}

/**
 * Observes lifecycle events and calls lifecycle methods on a provided [Animator].
 *
 * @property animator to be changes as the lifecycle being observed moves through different states
 */
@JvmInline
private value class EraserLifecycleObserver(
    private val animator: Animator
) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resumeAnimator() {
        animator.resume()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pauseAnimator() {
        animator.pause()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun cancelAnimator() {
        animator.cancel()
        animator.removeAllListeners()
    }
}
