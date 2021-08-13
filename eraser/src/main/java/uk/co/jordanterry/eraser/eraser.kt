package uk.co.jordanterry.eraser

import android.animation.Animator
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import android.view.View
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import uk.co.jordanterry.eraser.internal.erase
import uk.co.jordanterry.eraser.internal.requireViewTreeLifecycleOwner

/**
 * Sync the "lifecycle" of an [Animator] to the lifecycle of this [Activity]
 *
 * @param animator to be synchronised with the Activity
 */
fun ComponentActivity.erase(animator: Animator) = erase(lifecycle, animator)

/**
 * Sync the "lifecycle" of an [Animator] to the lifecycle of the [View] of this [Fragment].
 *
 * @param animator to be synchronised with the Fragment's View lifecycle
 */
fun Fragment.erase(animator: Animator) = erase(viewLifecycleOwner.lifecycle, animator)

/**
 * Sync the "lifecycle" of an [Animator] to the lifecycle of this [View]
 *
 * @param animator to be synchronised with the View
 */
fun View.erase(animator: Animator) = erase(requireViewTreeLifecycleOwner().lifecycle, animator)

/**
 * Sync the "lifecycle" of an [AnimationDrawable] to the lifecycle of this [Activity]
 *
 * @param animationDrawable to be synchronised with the Activity
 */
fun ComponentActivity.erase(animationDrawable: AnimationDrawable) =
    erase(lifecycle, animationDrawable)

/**
 * Sync the "lifecycle" of an [AnimationDrawable] to the lifecycle of the [View] of this [Fragment].
 *
 * @param animationDrawable to be synchronised with the Fragment's View lifecycle
 */
fun Fragment.erase(animationDrawable: AnimationDrawable) =
    erase(viewLifecycleOwner.lifecycle, animationDrawable)

/**
 * Sync the "lifecycle" of an [AnimationDrawable] to the lifecycle of this [View]
 *
 * @param animationDrawable to be synchronised with the View
 */
fun View.erase(animationDrawable: AnimationDrawable) =
    erase(requireViewTreeLifecycleOwner().lifecycle, animationDrawable)

/**
 * Sync the "lifecycle" of an [AnimatedVectorDrawable] to the lifecycle of this [Activity]
 *
 * @param animatedVectorDrawable to be synchronised with the Activity
 */
@RequiresApi(Build.VERSION_CODES.M)
fun ComponentActivity.erase(animatedVectorDrawable: AnimatedVectorDrawable) =
    erase(lifecycle, animatedVectorDrawable)

/**
 * Sync the "lifecycle" of an [AnimatedVectorDrawable] to the lifecycle of the [View] of this [Fragment].
 *
 * @param animatedVectorDrawable to be synchronised with the Fragment's View lifecycle
 */
@RequiresApi(Build.VERSION_CODES.M)
fun Fragment.erase(animatedVectorDrawable: AnimatedVectorDrawable) =
    erase(viewLifecycleOwner.lifecycle, animatedVectorDrawable)

/**
 * Sync the "lifecycle" of an [AnimatedVectorDrawable] to the lifecycle of this [View]
 *
 * @param animatedVectorDrawable to be synchronised with the View
 */
@RequiresApi(Build.VERSION_CODES.M)
fun View.erase(animatedVectorDrawable: AnimatedVectorDrawable) =
    erase(requireViewTreeLifecycleOwner().lifecycle, animatedVectorDrawable)

/**
 * Sync the "lifecycle" of an [AnimatedVectorDrawableCompat] to the lifecycle of this [Activity]
 *
 * @param animatedVectorDrawableCompat to be synchronised with the Activity
 */
fun ComponentActivity.erase(animatedVectorDrawableCompat: AnimatedVectorDrawableCompat) =
    erase(lifecycle, animatedVectorDrawableCompat)

/**
 * Sync the "lifecycle" of an [AnimatedVectorDrawableCompat] to the lifecycle of the [View] of this [Fragment].
 *
 * @param animatedVectorDrawableCompat to be synchronised with the Fragment's View lifecycle
 */
fun Fragment.erase(animatedVectorDrawableCompat: AnimatedVectorDrawableCompat) =
    erase(viewLifecycleOwner.lifecycle, animatedVectorDrawableCompat)

/**
 * Sync the "lifecycle" of an [AnimatedVectorDrawableCompat] to the lifecycle of this [View]
 *
 * @param animatedVectorDrawableCompat to be synchronised with the View
 */
fun View.erase(animatedVectorDrawableCompat: AnimatedVectorDrawableCompat) =
    erase(requireViewTreeLifecycleOwner().lifecycle, animatedVectorDrawableCompat)
