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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
fun YeetButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    val localContext = LocalContext.current
    //onClick = (0..3).random()
    var randomNumber by remember { mutableStateOf( 0) }
    var audioPlayer : MediaPlayer

    ElevatedButton(
        onClick = { randomNumber = (0..3).random() },

    ) {
        Text("Y33t!")
    }
    if (randomNumber == 0 ){
        audioPlayer = MediaPlayer.create(localContext, R.raw.yeet1)
    }
    else if (randomNumber == 1 ){
        audioPlayer = MediaPlayer.create(localContext, R.raw.yeet2)
    }
    else if (randomNumber == 2 ){
        audioPlayer = MediaPlayer.create(localContext, R.raw.yeet3)
    }
    else {
        audioPlayer = MediaPlayer.create(localContext, R.raw.yeet4)
    }
    audioPlayer.start()

}
@Composable
fun Greeting(greeting: String, url: String, modifier: Modifier = Modifier) {

    Column (verticalArrangement = Arrangement.Center, modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally){

        Text(
            text = "$greeting",
            modifier = modifier,
            fontSize = 100.sp,
            lineHeight = 111.sp,
            textAlign = TextAlign.Center,
            color = Color.Green

        )
        YeetButton(onClick = {  })
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
