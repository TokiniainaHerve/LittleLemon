package com.example.littlelemon.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.R
import com.example.littlelemon.routes.Profile
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun HomeScreen(navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize(1F)) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(id = R.string.logo_content),
            Modifier
                .width(250.dp)
                .height(100.dp),

            )
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = stringResource(id = R.string.profile_content),
            modifier = Modifier
                .width(150.dp)
                .height(150.dp).clickable {
                    try{
                        navController.navigate(Profile.route)
                    }catch (ex:Exception){
                        ex.printStackTrace()
                    }
                }

            )
    }
}
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    LittleLemonTheme {
        HomeScreen(navController = rememberNavController())
    }
}