package com.kiranbahalaskar.navigationdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tchmk_2.*
import com.kiranbahalaskar.navigationdrawer.theme.JetnewsTheme
import com.kiranbahalaskar.navigationdrawer.ui.theme.NavigationDrawerTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState) },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        }
    ) {
        Navigation(navController = navController)
    }

}

@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState){
    JetnewsTheme {
        TopAppBar(
            title = { Text(text = "Navigation Drawer", fontSize = 18.sp) },
            navigationIcon = {
                IconButton(onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }) {
                    Icon(Icons.Filled.Menu, "")
                }
            },
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = Color.Black
        )

    }
}

@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController){

    JetnewsTheme {
        val items = listOf(
            NavigationItem.Home,
            NavigationItem.Profile,
            NavigationItem.Settings,
            NavigationItem.Share,
            NavigationItem.Contact,
            NavigationItem.Features
        )

        Column(
            modifier = Modifier
                .background(color = Color.White)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(MaterialTheme.colors.background),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "",
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .padding(10.dp)
                )

            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
            )

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { items ->
                DrawerItem(item = items, selected = currentRoute == items.route, onItemClick = {

                    navController.navigate(items.route){
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route){
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                    scope.launch {
                        scaffoldState.drawerState.close()
                    }

                })
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Maxim Sysoev",
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.CenterHorizontally)
            )

        }
    }

}

@Composable
fun DrawerItem(item: NavigationItem, selected: Boolean, onItemClick: (NavigationItem) -> Unit){
    val background = if(selected) R.color.grey else android.R.color.transparent
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(item) }
            .height(45.dp)
            .background(colorResource(id = background))
            .padding(start = 10.dp)
    ) {

        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            colorFilter = ColorFilter.tint(Color.Black),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = item.title,
            fontSize = 16.sp,
            color = Color.Black
        )

    }

}

@Composable
fun EuclidScreen(){
    JetnewsTheme {
        Column {
            AppBar()

            Spacer(modifier = Modifier.height(16.dp))

            WorkField()
        }
    }
}

@Composable
fun EylerScreen(){
    JetnewsTheme {
        Column {
            AppBar()

            Spacer(modifier = Modifier.height(16.dp))

            EylerAlgoritm()
        }
    }
}

@Composable
fun LeghandreScreen(){
    JetnewsTheme {
        Column {
            AppBar()

            Spacer(modifier = Modifier.height(16.dp))

            LegandreAlgoritm()
        }
    }
}

@Composable
fun YakobiScreen(){
    JetnewsTheme {
        Column {
            AppBar()

            Spacer(modifier = Modifier.height(16.dp))

            YakobiAlgoritm()
        }
    }
}

@Composable
fun KvVichetScreen(){
    JetnewsTheme {
        Column {
            AppBar()

            Spacer(modifier = Modifier.height(16.dp))

            KvVichetAlgoritm()
        }
    }
}

@Composable
fun KbVichetScreen(){
    JetnewsTheme {
        Column {
            AppBar()

            Spacer(modifier = Modifier.height(16.dp))

            KbVichetAlgoritm()
        }
    }
}

@Composable
private fun AppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Palette,
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        },
        title = {
            Text(text = stringResource(R.string.app_title))
        },
        backgroundColor = MaterialTheme.colors.primarySurface
    )
}

@Composable
fun Navigation(navController: NavHostController){

    NavHost(navController, startDestination = NavigationItem.Home.route){

        composable(NavigationItem.Home.route){
            EuclidScreen()
        }

        composable(NavigationItem.Profile.route){
            EylerScreen()
        }

        composable(NavigationItem.Settings.route){
            LeghandreScreen()
        }

        composable(NavigationItem.Share.route){
            YakobiScreen()
        }

        composable(NavigationItem.Contact.route){
            KvVichetScreen()
        }

        composable(NavigationItem.Features.route){
            KbVichetScreen()
        }

    }

}





