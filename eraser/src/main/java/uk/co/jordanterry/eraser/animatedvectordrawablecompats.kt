package uk.co.jordanterry.eraser

import android.view.View
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import uk.co.jordanterry.eraser.internal.erase
import uk.co.jordanterry.eraser.internal.requireViewTreeLifecycleOwner

/**
 * Sync the "lifecycle" of an [AnimatedVectorDrawableCompat] to the lifecycle of this [Activity]
 *
 * @param animatedVectorDrawableCompat to be synchronised with the Activity
 */
fun ComponentActivity.erase(animatedVectorDrawableCompat: AnimatedVectorDrawableCompat) =
    erase(lifecycle, animatedVectorDrawableCompat)

/**
 * Sync the "lifecycle" of an [AnimatedVectorDrawableCompat] to the lifecycle of the [View] of this
 * [Fragment].
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
