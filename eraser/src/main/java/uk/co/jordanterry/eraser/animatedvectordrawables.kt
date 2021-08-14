package uk.co.jordanterry.eraser

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Build
import android.view.View
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import uk.co.jordanterry.eraser.internal.erase
import uk.co.jordanterry.eraser.internal.requireViewTreeLifecycleOwner

/**
 * Sync the "lifecycle" of an [AnimatedVectorDrawable] to the lifecycle of this [Activity]
 *
 * @param animatedVectorDrawable to be synchronised with the Activity
 */
@RequiresApi(Build.VERSION_CODES.M)
fun ComponentActivity.erase(animatedVectorDrawable: AnimatedVectorDrawable) =
    erase(lifecycle, animatedVectorDrawable)

/**
 * Sync the "lifecycle" of an [AnimatedVectorDrawable] to the lifecycle of the [View] of this
 * [Fragment].
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
    erase(
        requireViewTreeLifecycleOwner().lifecycle,
        animatedVectorDrawable
    )
