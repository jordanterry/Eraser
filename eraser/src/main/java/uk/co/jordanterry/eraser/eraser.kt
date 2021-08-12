package uk.co.jordanterry.eraser

import android.animation.Animator
import android.graphics.drawable.AnimationDrawable
import android.view.View
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import uk.co.jordanterry.eraser.observers.AnimationDrawableLifecycleObserver
import uk.co.jordanterry.eraser.observers.AnimatorLifecycleObserver

private fun erase(lifecycle: Lifecycle, animator: Animator) {
    lifecycle.addObserver(AnimatorLifecycleObserver(animator))
}

/**
 * Handle the lifecycle functions of an [Animator] as per the lifecycle of an Activity.
 *
 * * When the Activity is paused, [Animator.pause] will be called
 * * When the Activity is resumed, [Animator.resume] will be called
 * * When the Activity is destroyed, [Animator.cancel] will be called all listeners will be remove from the animator
 *
 * @param animator that must be erased
 */
fun ComponentActivity.erase(animator: Animator) {
    erase(lifecycle, animator)
}

fun Fragment.erase(animator: Animator) {
    erase(viewLifecycleOwner.lifecycle, animator)
}

fun View.erase(animator: Animator) {
    erase(requireViewTreeLifecycleOwner().lifecycle, animator)
}

private fun erase(lifecycle: Lifecycle, animationDrawable: AnimationDrawable) {
    lifecycle.addObserver(AnimationDrawableLifecycleObserver(animationDrawable))
}

fun ComponentActivity.erase(animationDrawable: AnimationDrawable) {
    erase(lifecycle, animationDrawable)
}

fun Fragment.erase(animationDrawable: AnimationDrawable) {
    erase(viewLifecycleOwner.lifecycle, animationDrawable)
}

fun View.erase(animationDrawable: AnimationDrawable) {
    erase(requireViewTreeLifecycleOwner().lifecycle, animationDrawable)
}

private fun View.requireViewTreeLifecycleOwner(): LifecycleOwner {
    return findViewTreeLifecycleOwner()
        ?: throw IllegalStateException("View lifecycle must not be null.")
}