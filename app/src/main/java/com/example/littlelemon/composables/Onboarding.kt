package com.example.littlelemon.composables

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.littlelemon.R
import com.example.littlelemon.routes.Home
import com.example.littlelemon.ui.theme.Black
import com.example.littlelemon.ui.theme.LittleLemonTheme
import com.example.littlelemon.ui.theme.Secondary
import com.example.littlelemon.ui.theme.Yellow


@Composable
fun OnboardingScreen(navController: NavController) {

    Column( horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(id = R.string.logo_content),
            Modifier
                .width(150.dp)
                .height(70.dp),

        )
        Row(
            Modifier
                .background(Secondary)
                .padding(0.dp, 20.dp, 0.dp, 20.dp)){
            Text(stringResource(id = R.string.get_to_know),
                Modifier.fillMaxWidth(1F),
                color= Color.White, textAlign = TextAlign.Center)
        }
        var firstName = remember{ mutableStateOf("") }
        var name = remember{ mutableStateOf("") }
        var email = remember{ mutableStateOf("") }

        fun validateData(){
            if(firstName.value.isBlank()||name.value.isBlank()||email.value.isBlank()){
                Toast.makeText(context,context.getString(R.string.data_not_filled),Toast.LENGTH_LONG).show()

            }else{
                navController.navigate(Home.route)
            }


        }
        Column(modifier = Modifier
            .padding(0.dp, 20.dp, 0.dp, 20.dp)
            .fillMaxWidth(1F)
            .fillMaxHeight(0.6F), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {

            OutlinedTextField(value = firstName.value, onValueChange = {text -> firstName.value=text},modifier= Modifier.fillMaxWidth(0.95f),
            label={Text(stringResource(id = R.string.first_name))})
            OutlinedTextField(value = name.value, onValueChange = {text -> name.value=text},modifier= Modifier.fillMaxWidth(0.95f),label={Text(stringResource(id = R.string.name))})
            OutlinedTextField(value = email.value, onValueChange = {text -> email.value=text},modifier= Modifier.fillMaxWidth(0.95f),label={Text(stringResource(id = R.string.email))})

        }
        Button(onClick = {
            validateData()
        },colors = ButtonDefaults.buttonColors(backgroundColor = Yellow), modifier = Modifier.fillMaxWidth(0.9f)) {
            Text(text = stringResource(id = R.string.register))
        }


    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LittleLemonTheme {
//        OnboardingScreen(null)
    }
}