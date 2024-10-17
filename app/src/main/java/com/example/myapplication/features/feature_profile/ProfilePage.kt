package com.example.myapplication.features.feature_profile

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity

@Composable
fun ProfilePage() {

    val PROFILE_CONTENT = "Lorem ipsum odor amet, consectetuer adipiscing elit. Venenatis accumsan dapibus quam at eleifend lectus arcu platea id. Vel nascetur sem varius, gravida ex mollis bibendum curae fermentum. Primis magnis curabitur duis egestas himenaeos amet. Donec eu habitant libero tellus malesuada euismod curabitur taciti. Leo habitant dictum etiam facilisi elementum id augue vehicula commodo. Est vitae integer finibus malesuada in varius torquent!\n" +
            "\n" +
            "Facilisis etiam dapibus aptent sem suspendisse eget bibendum. Congue risus sed viverra lacus magna convallis elementum eros. Phasellus leo sapien nibh tortor suspendisse dignissim facilisis elementum. Habitant luctus dis rhoncus vitae inceptos elit at sagittis egestas. Penatibus vehicula etiam risus venenatis ridiculus a proin? Fringilla vel iaculis elementum ante luctus sit dolor. Tempor duis himenaeos pharetra quis habitasse nisl taciti aenean dui.\n" +
            "\n" +
            "Morbi feugiat bibendum auctor fusce ridiculus sagittis duis. Tincidunt penatibus consequat quis dui viverra amet primis tellus. Non praesent morbi vulputate nascetur phasellus proin fermentum sapien. Placerat senectus porttitor dis aenean quis ultricies nulla per. Nisi hac in finibus velit consequat risus mi conubia. Efficitur fermentum nisl hac lectus aptent commodo accumsan ut."

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color(0xFFC93030))
            .verticalScroll(rememberScrollState())
            .padding(bottom = 100.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = PROFILE_CONTENT,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 26.sp,
            fontFamily = FontFamily.Monospace,
            color = Color(0xFFFFFFFF)
        )
    }
}