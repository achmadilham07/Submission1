package com.example.hp.submission1

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    var items : MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        verticalLayout {
            lparams(matchParent, matchParent)
            orientation = LinearLayout.VERTICAL

            recyclerView {
                lparams(matchParent, matchParent)
                layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?
                adapter = RecyclerViewAdapter(items){
                    startActivity<SecondActivity>(SecondActivity.POSITIONEXTRA to it)
                    val toast = Toast.makeText(context, it.name, Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
        }

    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val ket = resources.getStringArray(R.array.club_info)

        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0), ket[i]))
        }

        //Recycle the typed array
        image.recycle()
    }
}
