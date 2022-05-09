package com.tutorialsbuzz.androidflowsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.tutorialsbuzz.androidflowsample.databinding.ActivityMainBinding
import com.tutorialsbuzz.androidflowsample.model.Tiles
import com.tutorialsbuzz.androidflowsample.utils.Constanst

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    lateinit var gridAdapter: GridAdapter

    val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        gridAdapter = GridAdapter()

        binding.recyclerView.apply {
            adapter = gridAdapter
            layoutManager = GridLayoutManager(this@MainActivity, Constanst.columnSpan)
        }


        binding.button.setOnClickListener {
            val count = binding.inputTiles.text.toString()
            gridAdapter.updateItems(mainActivityViewModel.getTilesList(count.toInt()))
        }

    }


    // n =  10 , Col = any // RC > Grilayout
    // count = 10 , colspan =3 isEven = false
    // 1 , 2, 3 (br)  iseven= true
    // 4  5  6 (reverse) (br) isevent=false list > getlist >  rever .addAll()
    //

    // 1 2 3 4 5 6 7 8 9  ->  // 1 2 3 , 6 5 4 , 7 8 9 , 12 11 10 {modifies to recyclerView}

    // 1 2 3 (break , condition )
    // 6 5 4 {start=3 , end =5 , swap}
    // 7 8 9
    //     10


}