package uk.co.jordanterry.eraser.internal

import android.animation.Animator
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import uk.co.jordanterry.eraser.internal.observers.AnimatedVectorDrawableCompatLifecycleObserver
import uk.co.jordanterry.eraser.internal.observers.AnimatedVectorDrawableLifecycleObserver
import uk.co.jordanterry.eraser.internal.observers.AnimationDrawableLifecycleObserver
import uk.co.jordanterry.eraser.internal.observers.AnimatorLifecycleObserver


internal fun erase(lifecycle: Lifecycle, animator: Animator) {
    erase(lifecycle, AnimatorLifecycleObserver(animator))
}

internal fun erase(lifecycle: Lifecycle, animationDrawable: AnimationDrawable) {
    erase(lifecycle, AnimationDrawableLifecycleObserver(animationDrawable))
}

@RequiresApi(Build.VERSION_CODES.M)
internal fun erase(lifecycle: Lifecycle, animatedVectorDrawable: AnimatedVectorDrawable) {
    erase(lifecycle, AnimatedVectorDrawableLifecycleObserver(animatedVectorDrawable))
}

internal fun erase(
    lifecycle: Lifecycle,
    animatedVectorDrawableCompat: AnimatedVectorDrawableCompat
) {
    erase(lifecycle, AnimatedVectorDrawableCompatLifecycleObserver(animatedVectorDrawableCompat))
}

internal fun erase(lifecycle: Lifecycle, lifecycleObserver: LifecycleObserver) {
    lifecycle.addObserver(lifecycleObserver)
}

/**
 * Retrieve the lifecycle owner of this current View. The View must be attached to the view hierarchy.
 *
 * @return the [LifecycleOwner] associated with this current view hierarchy
 */
internal fun View.requireViewTreeLifecycleOwner(): LifecycleOwner {
    return findViewTreeLifecycleOwner()
        ?: throw IllegalStateException("View lifecycle must not be null.")
}