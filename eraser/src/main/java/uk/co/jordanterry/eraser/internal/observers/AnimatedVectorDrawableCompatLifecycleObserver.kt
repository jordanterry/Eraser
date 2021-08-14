package uk.co.jordanterry.eraser.internal.observers

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

/**
 * Observes lifecycle events and syncs them with the "lifecycle" methods on a provided
 * [AnimatedVectorDrawableCompat].
 *
 * Methods considered lifecycle events:
 *
 * * [AnimatedVectorDrawableCompat.start], will be synced with a transition to
 * [Lifecycle.State.PAUSED]
 * * [AnimatedVectorDrawableCompat.stop], will be synced with a transition to
 * [Lifecycle.State.RESUMED], if the animation was running when paused
 *
 * Methods important for cleaning up after ourselves:
 * * [AnimatedVectorDrawableCompat.clearAnimationCallbacks], when transition into the
 * [Lifecycle.State.DESTROYED] state, all listeners will be removed
 *
 * We ensure that we *only* resume a paused animation if it was running when we paused it.
 *
 * @property animatedVectorDrawableCompat to be changed as the lifecycle being observed moves
 * through different states
 */
internal class AnimatedVectorDrawableCompatLifecycleObserver(
    private val animatedVectorDrawableCompat: AnimatedVectorDrawableCompat
) : DefaultLifecycleObserver {

    /**
     * Indicates if [animatedVectorDrawableCompat] was running when paused. If this was the case, the
     * animation should be restarted when the lifecycle is resumed.
     */
    private var wasRunningWhenPaused: Boolean = false

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        wasRunningWhenPaused = animatedVectorDrawableCompat.isRunning
        animatedVectorDrawableCompat.stop()
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        if (wasRunningWhenPaused) {
            animatedVectorDrawableCompat.start()
        }
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        animatedVectorDrawableCompat.clearAnimationCallbacks()
    }
}
