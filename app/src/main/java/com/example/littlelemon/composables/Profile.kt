package com.example.littlelemon.composables

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.R
import com.example.littlelemon.routes.Home
import com.example.littlelemon.ui.theme.LittleLemonTheme
import com.example.littlelemon.ui.theme.Yellow

@Composable
fun ProfileScreen(navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(id = R.string.logo_content),
            Modifier
                .width(150.dp)
                .height(70.dp),

            )
        var firstName = "Tilly"
        var name = "Doe"
        var email = "tillydoe@example.co"


        Column(modifier = Modifier
            .padding(0.dp, 20.dp, 0.dp, 20.dp)
            .fillMaxWidth(1F)
            .fillMaxHeight(0.6F), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {

            OutlinedTextField(value = firstName, onValueChange = {},modifier= Modifier.fillMaxWidth(0.95f),
                label={ Text(stringResource(id = R.string.first_name)) },enabled = false)
            OutlinedTextField(value = name, onValueChange = {},modifier= Modifier.fillMaxWidth(0.95f),label={ Text(stringResource(id = R.string.name)) },enabled = false)
            OutlinedTextField(value = email, onValueChange = {},modifier= Modifier.fillMaxWidth(0.95f),label={ Text(stringResource(id = R.string.email)) }, enabled = false)

        }
        Button(onClick = {
        },colors = ButtonDefaults.buttonColors(backgroundColor = Yellow), modifier = Modifier.fillMaxWidth(0.9f)) {
            Text(text = stringResource(id = R.string.logout))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    LittleLemonTheme {
        ProfileScreen(navController = rememberNavController())
    }
}
