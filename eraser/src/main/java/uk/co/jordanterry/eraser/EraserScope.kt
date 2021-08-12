package uk.co.jordanterry.eraser

import android.animation.Animator
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.AnimationDrawable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import uk.co.jordanterry.eraser.observers.AnimatedDrawableLifecycleObserver
import uk.co.jordanterry.eraser.observers.AnimatedVectorDrawableLifecycleObserver
import uk.co.jordanterry.eraser.observers.AnimatorLifecycleObserver

interface EraserScope

interface EraserBuilder {
    fun addAnimation(animator: Animator)
    fun addAnimation(animatedVectorDrawable: AnimatedVectorDrawable)
    fun addAnimation(animationDrawable: AnimationDrawable)
    fun clearAnimations()
}


private class EraserBuilderImpl(
    private val onObserverAdded: OnObserverAdded
) : EraserBuilder {

    private val observers: MutableSet<LifecycleObserver> = hashSetOf()

    override fun addAnimation(animator: Animator) {
        observers.add(AnimatorLifecycleObserver(animator))
    }

    override fun addAnimation(animatedVectorDrawable: AnimatedVectorDrawable) {
        observers.add(AnimatedVectorDrawableLifecycleObserver(animatedVectorDrawable))
    }

    override fun addAnimation(animationDrawable: AnimationDrawable) {
        observers.add(AnimatedDrawableLifecycleObserver(animationDrawable))
    }

    override fun clearAnimations() {
        observers.clear()
    }

    fun interface OnObserverAdded {
        fun invoke(lifecycleObserver: LifecycleObserver)
    }
}

private fun EraserScope.launch(lifecycle: Lifecycle, block: (EraserBuilder) -> Unit) {
    val eraserBuilder = EraserBuilderImpl { lifecycleObserver ->
        lifecycle.addObserver(lifecycleObserver)
    }
    block(eraserBuilder)
}
