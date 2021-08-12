package uk.co.jordanterry.eraser.observers

import android.animation.Animator
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * Observes lifecycle events and calls lifecycle methods on a provided [Animator].
 *
 * @property animator to be changes as the lifecycle being observed moves through different states
 */
internal class AnimatorLifecycleObserver(
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
