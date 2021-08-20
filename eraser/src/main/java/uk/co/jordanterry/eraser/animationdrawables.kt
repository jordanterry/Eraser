@file:JvmMultifileClass
@file:JvmName("EraserKt")

package uk.co.jordanterry.eraser

import android.graphics.drawable.AnimationDrawable
import android.view.View
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import uk.co.jordanterry.eraser.internal.erase
import uk.co.jordanterry.eraser.internal.requireViewTreeLifecycleOwner

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
    erase(
        requireViewTreeLifecycleOwner().lifecycle,
        animationDrawable
    )
