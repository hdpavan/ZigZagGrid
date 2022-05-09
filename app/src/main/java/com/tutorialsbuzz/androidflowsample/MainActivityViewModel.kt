package com.tutorialsbuzz.androidflowsample

import android.util.Log
import androidx.lifecycle.ViewModel
import com.tutorialsbuzz.androidflowsample.model.Tiles
import com.tutorialsbuzz.androidflowsample.utils.Constanst

class MainActivityViewModel : ViewModel() {

    private val TAG = "MainActivityViewModel"

    fun getTilesList(count: Int): List<Tiles> {

        val tilesList = mutableListOf<Tiles>()

        val reversedTilesList = mutableListOf<Tiles>()

        val range = (0..count).toMutableList()

        range.forEach {

            if (it != count)
                if ((it / Constanst.columnSpan) % 2 == 0) {
                    Log.d(TAG, "odd row")
                    if (!reversedTilesList.isEmpty()) {
                        tilesList.addAll(reversedTilesList.reversed())
                        reversedTilesList.clear()
                    }
                    tilesList.add(Tiles((it + 1).toString()))

                } else {
                    Log.d(TAG, "even row")
                    // reverse
                    reversedTilesList.add(Tiles((it + 1).toString()))

                }
        }

        Log.d(
            TAG,
            "shouldReverse: " + reversedTilesList.isEmpty() + "  " + reversedTilesList.toString()
        )

        if (!reversedTilesList.isEmpty()) {
            tilesList.addAll(reversedTilesList.reversed())
            reversedTilesList.clear()
        }
        return tilesList
    }

    fun reverse(arr: MutableList<Int>, n: Int, k: Int): MutableList<Int> {
        var i = 0
        while (i < n) {

            var left = i

            // to handle case when k is not multiple
            // of n
            var right = Math.min(i + k - 1, n - 1)
            var temp: Int

            // reverse the sub-array [left, right]
            while (left < right) {
                temp = arr[left]
                arr[left] = arr[right]
                arr[right] = temp
                left += 1
                right -= 1
            }
            i += k

        }

        return arr
    }


}