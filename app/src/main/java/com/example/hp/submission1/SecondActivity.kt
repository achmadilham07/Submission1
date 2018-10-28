package com.example.hp.submission1

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

@SuppressLint("ParcelCreator")
class SecondActivity() : AppCompatActivity() {

    companion object {
        val idKet = 3
        val POSITIONEXTRA = "position_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        val list = intent.getParcelableExtra<Item>(POSITIONEXTRA)

        SecondActivityUI(list).setContentView(this)

    }

    internal class SecondActivityUI(var list: Item) : AnkoComponent<SecondActivity> {

        override fun createView(ui: AnkoContext<SecondActivity>) = with(ui) {
            var position = 0
            scrollView {
                lparams(matchParent, matchParent)


                linearLayout {
                    orientation = LinearLayout.VERTICAL
                    lparams(matchParent, matchParent)

                    linearLayout {
                        orientation = LinearLayout.HORIZONTAL
                        lparams(matchParent, wrapContent)

                        imageView() {
                            list.image?.let { Picasso.get().load(it).into(this) }
                            id = ListUI.imageId
                            padding = dip(10)
                            this@linearLayout.gravity = Gravity.LEFT
                        }.lparams(dip(120), dip(120))

                        textView {
                            id = ListUI.nameId
                            text = list.name
                            textSize = dip(10).toFloat()
                            gravity = Gravity.LEFT
                            padding = dip(10)
                        }.lparams(matchParent, wrapContent) {
                            gravity = Gravity.CENTER_VERTICAL
                        }
                    }

                    textView {
                        id = idKet
                        text = list.ket
                        textSize = dip(8).toFloat()
                        gravity = Gravity.LEFT
                        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                        padding = dip(10)
                    }
                }
            }
        }
    }
}