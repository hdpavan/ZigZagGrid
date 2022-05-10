package com.tutorialsbuzz.androidflowsample

import com.tutorialsbuzz.androidflowsample.model.Tiles

sealed class Result{
    class Success(val listOfTiles:List<Tiles>):Result()
    class Error(val error:String):Result()
}
