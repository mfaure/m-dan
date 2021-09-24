package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class TitleExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView = inflater.inflate(R.layout.buttongeneric, null) as LinearLayout

        val scale: Float = context.getResources().getDisplayMetrics().density
        val dpAsPixels = (15 * scale + 0.5f).toInt() //padding de 15dp

        val dpAsPixels2 = (5 * scale + 0.5f).toInt() //padding de 5dp

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        /* AXS YES */
        val exAxsDescription = TextView(context)
        exAxsDescription.setText(context.getString(R.string.criteria_title_ex1_axsDesc))
        exAxsDescription.setPadding(dpAsPixels, dpAsPixels2, dpAsPixels, dpAsPixels2)

        val buttonAvessibilityYes = myView.findViewById<View>(R.id.btngeneric) as Button
        buttonAvessibilityYes.setText(R.string.criteria_title_ex1_axsButton)
        /* buttonAvessibilityYes.setOnClickListener {
             mOnNewFragment.setTemplateTitle(getString(R.string.example).toString() + " 1/1", true)
             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                 getView().announceForAccessibility(
                     getString(R.string.criteria_title_ex1_announceaxsyes).toString() + " " + getString(
                         R.string.example
                     ) + " 1/1"
                 )
             }
         }*/

        val lyAxs = LinearLayout(context)
        lyAxs.orientation = LinearLayout.VERTICAL
        lyAxs.layoutParams = layoutParams
        lyAxs.addView(exAxsDescription)
        lyAxs.addView(myView)

        return lyAxs
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView2 = inflater.inflate(R.layout.buttongeneric, null) as LinearLayout

        val scale: Float = context.getResources().getDisplayMetrics().density
        val dpAsPixels = (15 * scale + 0.5f).toInt() //padding de 15dp

        val dpAsPixels2 = (5 * scale + 0.5f).toInt() //padding de 5dp

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        val exNotAxsDescription = TextView(context)
        exNotAxsDescription.setText(context.getString(R.string.criteria_title_ex1_notAxsDesc))
        exNotAxsDescription.setPadding(dpAsPixels, dpAsPixels2, dpAsPixels, dpAsPixels2)

        val buttonAvessibilityNo = myView2.findViewById<View>(R.id.btngeneric) as Button
        buttonAvessibilityNo.setText(R.string.criteria_title_ex1_notAxsButton)
        /* buttonAvessibilityNo.setOnClickListener {
             mOnNewFragment.setTemplateTitle(" ", true)
             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                 getView().announceForAccessibility(getString(R.string.criteria_title_ex1_announceaxsno))
             }
         }*/

        val lyNotAxs = LinearLayout(context)
        lyNotAxs.orientation = LinearLayout.VERTICAL
        lyNotAxs.layoutParams = layoutParams
        lyNotAxs.addView(exNotAxsDescription)
        lyNotAxs.addView(myView2)

        return lyNotAxs
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_title_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_title_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_title_ex1_description)
    }

    override fun hasUseOption(): Boolean {
        return true
    }
}

