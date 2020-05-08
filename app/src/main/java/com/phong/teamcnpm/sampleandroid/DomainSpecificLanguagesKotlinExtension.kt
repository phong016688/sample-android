package com.phong.teamcnpm.sampleandroid

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class DomainSpecificLanguagesKotlinExtension : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.domain_specific_language)

        dialogBuilder {
            with { this@DomainSpecificLanguagesKotlinExtension }
            titleText { "titleText" }
            negativeText { "negativeText" }
            positiveText { "positiveText" }
            onPositiveClickAction { Unit }
            onNegativeClickAction { Unit }
            onBackgroundClickAction { Unit }
        }
    }
}

fun dialogBuilder(lambada: DialogBuilder.() -> Unit) =
    DialogBuilder().apply(lambada).build()

class DialogBuilder {
    var mContext: Context? = null
    var mViewToBlur: View? = null
    var mTitleText: String = ""
    var mNegativeText: String = ""
    var mPositiveText: String = ""
    var mOnBackgroundClickAction: () -> Unit = {}
    var mOnNegativeClickAction: () -> Unit = {}
    var mOnPositiveClickAction: () -> Unit = {}

    inline fun with(context: () -> Context) {
        this.mContext = context()
    }

    inline fun viewToBlur(viewToBlur: () -> View) {
        this.mViewToBlur = viewToBlur()
    }

    inline fun titleText(title: () -> String) {
        this.mTitleText = title()
    }

    inline fun negativeText(negativeText: () -> String) {
        this.mNegativeText = negativeText()
    }

    inline fun positiveText(positiveText: () -> String) {
        this.mPositiveText = positiveText()
    }

    fun onNegativeClickAction(onNegativeClickAction: () -> Unit) {
        this.mOnNegativeClickAction = onNegativeClickAction
    }

    fun onPositiveClickAction(onPositiveClickAction: () -> Unit) {
        this.mOnPositiveClickAction = onPositiveClickAction
    }

    fun onBackgroundClickAction(onBackgroundClickAction: () -> Unit) {
        this.mOnBackgroundClickAction = onBackgroundClickAction
    }

    fun build() = AlertDialog.Builder(mContext!!)
}
