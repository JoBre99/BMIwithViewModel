package com.example.bmicalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {

    var height by mutableStateOf("")
        private set

    var weight by mutableStateOf("")
        private set

    val bmi: String
        get() {
            val h = height.toFloatOrNull()
            val w = weight.toFloatOrNull()
            return if (h != null && w != null && h > 0) {
                String.format("%.2f", w / (h * h))
            } else {
                ""
            }
        }

    fun updateHeight(newHeight: String) {
        height = newHeight
    }

    fun updateWeight(newWeight: String) {
        weight = newWeight
    }
}

