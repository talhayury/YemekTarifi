package com.talhayurt.yemektarifi

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.talhayurt.yemektarifi.ui.theme.YemekTarifiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YemekTarifiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Sayfa()
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun Sayfa() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Yemek Tarifi")},
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = colorResource(id = R.color.purple_500),
                        titleContentColor = colorResource(id = R.color.yellow)
                    )
                )
            },
            content = {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
                    Image(painter = painterResource(id = R.drawable.yemekresim), contentDescription = "")
                    Row (modifier = Modifier.fillMaxWidth()){
                        Button(onClick = { Log.e("Button","Begenildi")}, modifier = Modifier.weight(50f), colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.purple_500),
                            contentColor = colorResource(id = R.color.yellow)
                        )) {
                            Text(text = "Beğen")
                        }

                        Button(onClick = { Log.e("Button","yorumYapildi")}, modifier = Modifier.weight(50f), colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.purple_500),
                            contentColor = colorResource(id = R.color.yellow)
                        )) {
                            Text(text = "Yorum Yap")
                        }

                    }
                    Text(text = "Köfte",color = colorResource(id = R.color.black), fontWeight = FontWeight.Bold, modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), fontSize = 30.sp)
                    
                    Row (modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                        Text(text = "Izgaraya Uygun ")
                        Text(text = "7 haziran")
                    }
                    
                    Text(text = "Köfte harcını hazırlamak için, soğanları rendeleyin ve maydanozları ince ince kıyın. İsterseniz, bir diş sarımsak da ekleyebilirsiniz", modifier = Modifier.padding(15.dp).fillMaxWidth(), maxLines = Int.MAX_VALUE, softWrap = true)
                }
            }
        )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YemekTarifiTheme {
        Sayfa()
    }
}