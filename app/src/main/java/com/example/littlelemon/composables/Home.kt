package com.example.littlelemon.composables

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.room.Room
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.LittleLemonDatabase
import com.example.littlelemon.MenuItemRoom
import com.example.littlelemon.R
import com.example.littlelemon.routes.Profile
import com.example.littlelemon.ui.theme.LittleLemonTheme
import com.example.littlelemon.ui.theme.Primary
import com.example.littlelemon.ui.theme.Secondary
import com.example.littlelemon.ui.theme.Yellow

@Composable
fun HomeScreen(navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally , modifier = Modifier.fillMaxSize(1F)) {
        header(navController)
        about()
        val database = LittleLemonDatabase.getInstance(LocalContext.current)
        val databaseMenuItems =  database.menuItemDao().getAll().observeAsState(emptyList())

        MenuItemsList(items = databaseMenuItems.value)

    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun MenuItemsList(items: List<MenuItemRoom>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 20.dp)
    ) {
        items(
            items = items,
            itemContent = { menuItem ->
                Card() {
                    Row(modifier = Modifier.fillMaxWidth(1f).padding(8.dp)){
                        Column(Modifier.fillMaxWidth(0.75f)) {

                            Text(text="${menuItem.title}" , modifier =  Modifier.padding(0.dp,5.dp,0.dp,5.dp), fontSize = 14.sp)
                            Text(text="${menuItem.description}" , fontSize = 12.sp)
                            Text(text="$ ${menuItem.price}" , fontSize = 12.sp)
                        }
                        GlideImage(
                            model = menuItem.image,
                            contentDescription = "${menuItem.title}",
                            modifier = Modifier.size(80.dp),
                        )
                    }
                }
                Divider(
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    color = Yellow,
                    thickness = 1.dp,
                )
            }
        )
    }
}
@Composable
fun header(navController: NavController){
    Row(horizontalArrangement = Arrangement.SpaceAround){
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
                .width(80.dp)
                .height(80.dp)
                .clickable {
                    try {
                        navController.navigate(Profile.route)
                    } catch (ex: Exception) {
                        ex.printStackTrace()
                    }
                }

        )
    }
}

@Composable
fun about(){
    Column(modifier = Modifier
        .background(Secondary)
        .padding(10.dp, 10.dp)) {
        Text(text = stringResource(R.string.restaurant_name) , color = Yellow , fontSize = 18.sp , fontWeight = FontWeight.Bold)
        Text(text =stringResource(R.string.location),color = Color.White , fontSize = 14.sp ,)
        Text(text = stringResource(R.string.description),color = Color.White , fontSize = 14.sp, modifier = Modifier.padding(0.dp,10.dp,0.dp,0.dp))
    }
}
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    LittleLemonTheme {
        HomeScreen(navController = rememberNavController())
    }
}