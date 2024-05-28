package com.example.modifiersdemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.modifiersdemo.ui.theme.ModifiersDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModifiersDemoTheme {
                ModifierExample()
            }
        }
    }
}

@Composable
fun ModifierExample() {
    Column(modifier = Modifier.padding(10.dp)) {
        val context = LocalContext.current
        TextWithModifiers("Modifier with max width and padding", Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .padding(20.dp))

        Spacer(modifier = Modifier.size(5.dp))

        TextWithModifiers("Modifier with padding", Modifier
            .background(Color.Cyan)
            .padding(20.dp))

        Spacer(modifier = Modifier.size(5.dp))

        TextWithModifiers("Modifier with Click", Modifier
            .background(Color.Cyan)
            .padding(20.dp)
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(context, "Modifier with Click", Toast.LENGTH_LONG)
                    .show()
            })

        Spacer(modifier = Modifier.size(5.dp))

        TextWithModifiers("Modifier with fixed size", Modifier
            .background(Color.Cyan)
            .padding(20.dp)
            .size(width = 120.dp, height = 60.dp))

        Spacer(modifier = Modifier.size(5.dp))

        TextWithModifiers("Modifier with padding from baseline", Modifier
            .background(Color.Cyan)
            .padding(20.dp)
            .paddingFromBaseline(80.dp))

        Spacer(modifier = Modifier.size(5.dp))

        TextWithModifiers("Modifier with offset", Modifier
            .background(Color.Cyan)
            .padding(20.dp)
            .offset(x = 30.dp))

        Spacer(modifier = Modifier.size(5.dp))

        Row {

            TextWithModifiers("Modifier \nwith weight 2f", Modifier
                .background(Color.Cyan)
                .padding(20.dp)
                .weight(2f))

            Spacer(modifier = Modifier.size(5.dp))

            TextWithModifiers("Modifier \nwith weight 1f", Modifier
                .background(Color.Cyan)
                .padding(20.dp)
                .weight(1f))
        }

        val reusableModifier = Modifier
            .background(Color.Cyan)
            .padding(20.dp)

        TextWithModifiers("Reusable Modifier", reusableModifier)

        Spacer(modifier = Modifier.size(5.dp))

        TextWithModifiers("Modifier with Border", Modifier
            .border(2.dp, Color.Black)
            .background(Color.Cyan)
            .padding(20.dp))

        Spacer(modifier = Modifier.size(5.dp))

    }
}

@Composable
fun TextWithModifiers(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        color = Color.Blue,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    ModifiersDemoTheme {
        ModifierExample()
    }
}