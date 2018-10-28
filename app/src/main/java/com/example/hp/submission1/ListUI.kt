package com.example.hp.submission1


import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ListUI : AnkoComponent<ViewGroup> {

    companion object {
        val imageId = 1
        val nameId = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui){
        linearLayout {
            orientation = LinearLayout.HORIZONTAL
            lparams(matchParent, wrapContent)
            padding = dip(12)

            imageView{
                id = imageId
                imageResource = R.drawable.img_chelsea

            }.lparams(dip(60), dip(60))

            textView {
                id = nameId
                text = "Chelsea FC"
                textSize = dip(10).toFloat()
            }.lparams(matchParent, wrapContent){
                margin = dip(12)
                gravity = Gravity.CENTER_VERTICAL
            }

        }
    }

}