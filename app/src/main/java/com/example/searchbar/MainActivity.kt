package com.example.searchbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.mancj.materialsearchbar.MaterialSearchBar
import android.widget.Toast.makeText as makeText1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //REFERENCE MATERIALSEARCHBAR AND LISTVIEW
        val lv = findViewById(R.id.mListView) as ListView
        val searchBar = findViewById(R.id.pencarian) as MaterialSearchBar
        searchBar.setHint("Search..")
        searchBar.setSpeechMode(true)

        var galaxies = arrayOf("Gunung Gede","Gunung Salak","Gunung Pangrango","Gunung Guntur","Gunung Ciremai")

        //ADAPTER
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,galaxies)
        lv.setAdapter(adapter)

        //SEARCH TEXT CHANGE LISTENER
        searchBar.addTextChangeListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                //SEARCH FILTER
                adapter.getFilter().filter(s)
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

            //LISTVIEW ITEM CLICKED
        lv.setOnItemClickListener(object : AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
            Toast.makeText(this@MainActivity,adapter.getItem(position)!!.toString(),Toast.LENGTH_SHORT).show()
            }
        })

    }
}
