package com.diederich.labdiedell4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.runtime.*

import androidx.compose.ui.unit.dp

import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diederich.labdiedell4.ui.theme.LABDIEDELL4Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import com.diederich.labdiedell4.ui.theme.ColorRGB
import com.diederich.labdiedell4.ui.theme.verdesito
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
//import coil.compose.AsyncImage

class CardItem(var recipe: String, var image :String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LABDIEDELL4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  Mycomponent()                }
            }
        }
    }
}

@Composable
fun Mycomponent() {
    espacio()

    MyTT()

}

@Composable
fun espacio(){
    Text(text = " ")
}


@Composable
fun MyTT() {
    Row(modifier = Modifier

        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween)
    {
        Image(painter = painterResource(id = R.drawable.uvglogo),contentDescription = null, modifier = Modifier
            .weight(2.1f)
            .offset(0.dp, 175.dp)
            .size(100.dp))

        Spacer(modifier = Modifier.height(10.dp))


    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center )
    {
        var text1 by remember { mutableStateOf(" ") }

        var text2 by remember { mutableStateOf(" ") }

        var recipes by rememberSaveable { mutableStateOf(emptyList<CardItem>()) }


        Text(
            text = "Favor de ingresar el nombre de la receta:",
            color = Color.Black,
            fontSize = 15.sp,
            modifier = Modifier
                .offset(0.dp)
                .wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = text1,
            onValueChange = { newText -> text1 = newText },
            label = { Text("Etiqueta", color = Color.White) }, modifier = Modifier.background(
                ColorRGB))

        Spacer(modifier = Modifier.height(10.dp))

        Text(        text = "Ingresa el URL:",
            color = Color.Black,
            fontSize = 15.sp,
            modifier = Modifier
                .offset(0.dp)
                .wrapContentSize(Alignment.Center)
        )



        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = text2,
            onValueChange = { newText -> text2 = newText },
            label = { Text("URL", color = Color.White) }, modifier = Modifier.background(ColorRGB))

        Button(
            onClick = {   if (text1.isNotEmpty() && text2.isNotEmpty()) {
                val nuevorecipe = CardItem(text1, text2)

                val recipeExists = recipes.any { it.recipe == nuevorecipe.recipe }

                if (!recipeExists) {
                    recipes = recipes + nuevorecipe
                }

                text1 = ""
                text2 = ""
            }
                      },
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer(
                    scaleX = 0.8f, // Cambia el ancho del botón
                    scaleY = 0.8f // Cambia la altura del botón
                )
                .padding(16.dp)
                .clip(shape = CircleShape),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = verdesito, // Cambia el color de fondo del botón
                contentColor = Color.White // Cambia el color del texto del botón
            )
        ) {
            Text(text = "AGREGAR", style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White)
            )
        }

        LazyColumn(
            modifier = Modifier.padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Recetas ingresadas:",
                    modifier = Modifier.fillMaxWidth(),
                )
            }

            //Recorremos lista y mandamos parametro para eliminar elementos
            items(recipes) { recipe ->
                RecipeCard(recipe = recipe) {
                    recipes = recipes.filterNot { it == recipe }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RecipeCard(recipe: CardItem, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        onClick = onDelete


    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
         //   AsyncImage(
       ////       model = recipe.imageUrl,
           //     contentDescription = null,
             //   modifier = Modifier.size(50.dp)
            //)

            Spacer(modifier = Modifier.width(10.dp))
            //Text(text = recipe.name)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewComponent() {
    val scrollState= rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        Mycomponent()
    }

}

