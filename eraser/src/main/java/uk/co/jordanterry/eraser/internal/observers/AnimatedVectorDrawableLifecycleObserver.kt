package uk.co.jordanterry.eraser.internal.observers

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

/**
 * Observes lifecycle events and syncs them with the "lifecycle" methods on a provided [AnimatedVectorDrawable].
 *
 * Methods considered lifecycle events:
 *
 * * [AnimatedVectorDrawable.start], will be synced with a transition to [Lifecycle.State.PAUSED]
 * * [AnimatedVectorDrawable.stop], will be synced with a transition to [Lifecycle.State.RESUMED], if the animation was running when paused
 *
 * Methods important for cleaning up after ourselves:
 * * [AnimatedVectorDrawable.clearAnimationCallbacks], when transition into the [Lifecycle.State.DESTROYED] state, all listeners will be removed
 *
 * We ensure that we *only* resume a paused animation if it was running when we paused it.
 *
 * @property animatedVectorDrawable to be changed as the lifecycle being observed moves through different states
 */
@RequiresApi(Build.VERSION_CODES.M)
internal class AnimatedVectorDrawableLifecycleObserver(
    private val animatedVectorDrawable: AnimatedVectorDrawable
) : DefaultLifecycleObserver {

    /**
     * Indicates if [animatedVectorDrawable] was running when paused. If this was the case, the
     * animation should be restarted when the lifecycle is resumed.
     */
    private var wasRunningWhenPaused: Boolean = false

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        wasRunningWhenPaused = animatedVectorDrawable.isRunning
        animatedVectorDrawable.stop()
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        if (wasRunningWhenPaused) {
            animatedVectorDrawable.start()
        }
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        animatedVectorDrawable.clearAnimationCallbacks()
    }
}
