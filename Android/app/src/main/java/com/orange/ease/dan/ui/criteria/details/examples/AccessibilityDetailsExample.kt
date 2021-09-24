package com.orange.ease.dan.ui.criteria.details.examples

import android.content.Context
import android.view.View

interface AccessibilityDetailsExample {
    fun getAccessibleExample(context: Context) : View
    fun getNotAccessibleExample(context: Context) : View
    fun getTitleRessource(context: Context) : String
    fun getCellNameRessource(context: Context) : String
    fun getDescriptionRessource(context: Context) : String
    fun hasUseOption(): Boolean
}

