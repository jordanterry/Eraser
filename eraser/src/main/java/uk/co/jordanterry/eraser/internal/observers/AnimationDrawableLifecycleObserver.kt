package uk.co.jordanterry.eraser.internal.observers

import android.graphics.drawable.AnimationDrawable
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

/**
 * Observes lifecycle events and calls lifecycle methods on a provided [AnimationDrawable].
 *
 * An [AnimationDrawable] provides two "lifecycle" methods.
 *
 * - [AnimationDrawable.start] - this starts the drawable from it's initial frame
 * - [AnimationDrawable.stop] - stops the animation on it's current frame and resets the animation
 *
 * Pausing and resuming a [AnimationDrawable] from the same place is not possible. The behaviour of
 * this observer is as follows:
 *
 * - when the [Lifecycle] is paused, the [AnimationDrawable] will be stopped
 *     - [AnimationDrawable.isOneShot] is true, the observer will remove itself
 * - when the [Lifecycle] is resumed, the [AnimationDrawable] will be started from it's initial frame
 *
 * @property animationDrawable to be changed as the lifecycle being observed moves through different states
 */
internal class AnimationDrawableLifecycleObserver(
    private val animationDrawable: AnimationDrawable
) : DefaultLifecycleObserver {

    /**
     * Indicates if the [animationDrawable] was running when paused. If this was the case, the
     * animation should be restarted when the lifecycle is resumed.
     */
    private var wasAnimatorRunningWhenPaused: Boolean = false

    override fun onResume(owner: LifecycleOwner) {
        animationDrawable.start()
    }

    override fun onPause(owner: LifecycleOwner) {
        wasAnimatorRunningWhenPaused = animationDrawable.isRunning
        animationDrawable.stop()
        val canRemoveObserverBecauseAnimationIsCompleted =
            !wasAnimatorRunningWhenPaused && animationDrawable.isOneShot
        if (canRemoveObserverBecauseAnimationIsCompleted) {
            owner.lifecycle.removeObserver(this)
        }
    }
}

