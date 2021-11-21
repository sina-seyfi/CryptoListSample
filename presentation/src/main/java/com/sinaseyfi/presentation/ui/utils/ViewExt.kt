package com.sinaseyfi.presentation.ui.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewPropertyAnimator

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.setVisibility(visible: Boolean) {
    if (visible) show() else hide()
}

fun View.setInvisibility(invisible: Boolean) {
    if(invisible) invisible() else show()
}

fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}

fun View.isVisible() = visibility == View.VISIBLE

fun View.isInvisible() = visibility == View.INVISIBLE

fun View.isGone() = visibility == View.GONE

val View.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(this.context)

fun List<View>.setOnClickListener(action: (View) -> Unit) {
    this.forEach { view -> view.setOnClickListener { action(it) } }
}

fun List<View>.setOnClickListener(listener: View.OnClickListener?) {
    this.forEach { view ->
        view.setOnClickListener(listener)
    }
}

fun List<View?>.setVisibility(visible: Boolean) {
    forEach { view -> view?.setVisibility(visible) }
}

fun List<View?>.setEnabled(enabled: Boolean) {
    forEach { view -> view?.isEnabled = enabled }
}

fun View.getNavigationBarHeight(): Int {
    val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
    return if (resourceId > 0) {
        resources.getDimensionPixelSize(resourceId)
    } else 0
}

fun List<View?>.animate(chain: ViewPropertyAnimator.() -> Unit) {
    this.forEach { view -> view?.animate()?.chain() }
}