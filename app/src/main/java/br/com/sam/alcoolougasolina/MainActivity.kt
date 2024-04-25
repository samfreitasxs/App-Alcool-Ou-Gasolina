package br.com.sam.alcoolougasolina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.sam.alcoolougasolina.ui.theme.AlcoolOuGasolinaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlcoolOuGasolinaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

//Comentar varias linhas ctrl + /
//Run app ctrl + fn + f10
//ctrl + Alt + l: formata o codigo selecionado
//verticalArrangement = Arrangement.Center (centraliza no app)
//horizontalAlignment = Alignment.CenterHorizontally (centraliza no app)

// Incluir espacamento entre os campos : Spacer(modifier = Modifier.size(16.dp))
//Ou fazer para todos de uma vez passando uma column:
// Column (
//            verticalArrangement = Arrangement.spacedBy(16.dp)


@Composable
fun App() {

    var valorGasolina by remember {
        mutableStateOf("")
    }
    var valorAlcool by remember {
        mutableStateOf("")
    }
    Column(
        Modifier
            .background(color = Color(0xFF673AB7))
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Alcool ou Gasolina?",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            AnimatedVisibility(visible = valorAlcool.isNotBlank() && valorGasolina.isNotBlank()) {
                if (valorAlcool.isNotBlank() && valorGasolina.isNotBlank()){
                    val ehGasolina = valorAlcool.toDouble() / valorGasolina.toDouble() > 0.7
                    val alcoolOuGasolina = if (ehGasolina) {
                        "Gasolina"
                    } else {
                        "Alcool"
                    }
                    val cor = if (ehGasolina) {
                        Color.White
                    } else {
                        Color.Green
                    }
                    Text(
                        text = alcoolOuGasolina, style = TextStyle(
                            color = cor, fontSize = 40.sp, fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

            TextField(
                value = valorGasolina,
                onValueChange = {
                    valorGasolina = it
                },
                label = {
                    Text(text = "Gasolina")
                }
            )
            TextField(
                value = valorAlcool,
                onValueChange = {
                    valorAlcool = it
                },
                label = {
                    Text(text = "Alcool")
                })

            Box(Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(Color.White)
            )
            Box(Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(Color.White)
            )
            Box(Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(Color.White)
            )

        }
    }
}

@Preview
@Composable
fun AppPreview() {
    AlcoolOuGasolinaTheme {
        App()
    }
}