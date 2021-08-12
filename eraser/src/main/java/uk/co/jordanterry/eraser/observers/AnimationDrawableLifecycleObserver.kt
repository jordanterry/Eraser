package uk.co.jordanterry.eraser.observers

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

    override fun onResume(owner: LifecycleOwner) {
        if (!animationDrawable.isOneShot) {
            animationDrawable.start()
        }
    }

    override fun onPause(owner: LifecycleOwner) {
        animationDrawable.stop()
        if (animationDrawable.isOneShot) {
            owner.lifecycle.removeObserver(this)
        }
    }
}

