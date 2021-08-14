package uk.co.jordanterry.eraser

import android.animation.Animator
import android.view.View
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
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
