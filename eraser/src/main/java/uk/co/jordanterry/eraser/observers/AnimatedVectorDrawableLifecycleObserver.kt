package uk.co.jordanterry.eraser.observers

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

/**
 * Observes lifecycle events and calls lifecycle methods on a provided [AnimatedVectorDrawable].
 *
 * An [AnimatedVectorDrawable] provides three "lifecycle" methods.
 *
 * - [AnimatedVectorDrawable.start] - this starts the drawable animation
 * - [AnimatedVectorDrawable.stop] - stops the drawable animation
 *
 * - when the [Lifecycle] is paused, the [AnimatedVectorDrawable] will be stopped
 *     - [AnimationDrawable.isOneShot] is true, the observer will remove itself
 * - when the [Lifecycle] is resumed, the [AnimatedVectorDrawable] will be started from it's initial frame
 *
 * @property animatedVectorDrawable to be changed as the lifecycle being observed moves through different states
 */
internal class AnimatedVectorDrawableLifecycleObserver(
    private val animatedVectorDrawable: AnimatedVectorDrawable
) : DefaultLifecycleObserver {

    /**
     * Indicates if [animatedVectorDrawable] was running when paused. If this was the case, the
     * animation should be restarted wheen is is resumed.
     */
    private var wasRunningWhenPaused: Boolean = false

    override fun onPause(owner: LifecycleOwner) {
        animatedVectorDrawable.stop()
    }

    override fun onResume(owner: LifecycleOwner) {
        if (wasRunningWhenPaused) {
            animatedVectorDrawable.start()
        }
    }
}