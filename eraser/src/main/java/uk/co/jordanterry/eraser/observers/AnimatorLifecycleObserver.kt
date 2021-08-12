package uk.co.jordanterry.eraser.observers

import android.animation.Animator
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * Observes lifecycle events and calls lifecycle methods on a provided [Animator].
 *
 * @property animator to be changes as the lifecycle being observed moves through different states
 */
internal class AnimatorLifecycleObserver(
    private val animator: Animator
) : DefaultLifecycleObserver {

    override fun onResume(owner: LifecycleOwner) {
        animator.resume()
    }

    override fun onPause(owner: LifecycleOwner) {
        animator.pause()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        animator.cancel()
        animator.removeAllListeners()
        owner.lifecycle.removeObserver(this)
    }
}
