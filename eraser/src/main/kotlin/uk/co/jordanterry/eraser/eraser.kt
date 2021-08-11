package uk.co.jordanterry.eraser

import android.animation.Animator
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

fun LifecycleOwner.erase(animator: Animator) {
    lifecycle.addObserver(EraserLifecycleObserver(animator))
}

@JvmInline
private value class EraserLifecycleObserver(private val animator: Animator) : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun cancelAnimator() {
        animator.cancel()
    }
}
