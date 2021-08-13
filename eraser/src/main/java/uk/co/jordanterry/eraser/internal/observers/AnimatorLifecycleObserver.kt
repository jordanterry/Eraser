package uk.co.jordanterry.eraser.internal.observers

import android.animation.Animator
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * Observes lifecycle events and syncs them with the "lifecycle" methods on a provided [Animator].
 *
 * Methods considered lifecycle events:
 *
 * * [Animator.pause], will be synced with a transition to [Lifecycle.State.PAUSED]
 * * [Animator.resume], will be synced with a transition to [Lifecycle.State.RESUMED], if the animation was running when paused
 * * [Animator.cancel], will be synced with a transition to [Lifecycle.State.DESTROYED], if the lifecycle is destroyed we assume all animations will be recreated
 *
 * Methods important for cleaning up after ourselves:
 * * [Animator.removeAllListeners], when transition into the [Lifecycle.State.DESTROYED] state, all listeners will be removed
 *
 * We ensure that we *only* resume a paused animation if it was running when we paused it.
 *
 * @property animator to be changes as the lifecycle being observed moves through different states
 */
internal class AnimatorLifecycleObserver(
    private val animator: Animator
) : DefaultLifecycleObserver {

    /**
     * Indicates if the [animator] was running when paused. If this was the case, the
     * animation should be restarted when the lifecycle is resumed.
     */
    private var wasAnimatorRunningWhenPaused: Boolean = false

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        if (wasAnimatorRunningWhenPaused) {
            animator.resume()
            wasAnimatorRunningWhenPaused = false
        }
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        wasAnimatorRunningWhenPaused = animator.isRunning
        animator.pause()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        animator.cancel()
        animator.removeAllListeners()
        owner.lifecycle.removeObserver(this)
    }
}
