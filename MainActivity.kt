package com.example.evansaysyeet

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.evansaysyeet.ui.theme.EvanSaysYeetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EvanSaysYeetTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Evan says YEET!", "https://evansaysyeet.com/")
                }
            }
        }
    }
}
@Composable
fun YeetButton(onClick: () -> Unit) {
    val localContext = LocalContext.current
    val audioPlayer = MediaPlayer.create(localContext, R.raw.yeet1)
    ElevatedButton(onClick = { audioPlayer.start() }) {
        Text("Y33t!")
    }
}
@Composable
fun Greeting(greeting: String, url: String, modifier: Modifier = Modifier) {

    Column (verticalArrangement = Arrangement.Center, modifier = modifier){

        Text(
            text = "$greeting",
            modifier = modifier,
            fontSize = 100.sp,
            lineHeight = 111.sp,
            textAlign = TextAlign.Center

        )
        YeetButton {

        }
        Text(
            text = "$url",
            modifier = Modifier.width(500.dp),
            fontSize = 24.sp,
            lineHeight = 10.sp,
            //Does not Center the text. are URLs treated differently?
            textAlign = TextAlign.Center,
            color = Color.Blue
            // For some reason the width modifier is needed for this block but not the prior?
            // if it works it works i guess

        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EvanSaysYeetTheme {
        //Greeting("Android")

    }
}
