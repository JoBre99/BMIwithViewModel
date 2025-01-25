package com.example.bmiwithviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmicalculator.BmiViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiScreen()
        }
    }
}


@Composable
fun BmiScreen(viewModel: BmiViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // title
        Text(
            text = "BMI calculator",
            fontSize = 22.sp,
            style = MaterialTheme.typography.titleLarge
        )

        // enter width
        OutlinedTextField(
            value = viewModel.height,
            onValueChange = { viewModel.updateHeight(it) },
            label = { Text("Height") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // enter weight
        OutlinedTextField(
            value = viewModel.weight,
            onValueChange = { viewModel.updateWeight(it) },
            label = { Text("Weight") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // BMI result
        Text(
            text = "Your BMI is ${viewModel.bmi}",
            fontSize = 18.sp,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
