package com.deto.selectusertype

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondPageScreen( navController: NavController, id: Int){

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0, 16, 42, 255),
        topBar = {
            TopAppBar(
                title = {
                    Button(
                        onClick = {
                            val popped = navController.popBackStack()
                            if(!popped){
                                navController.navigate("Home")
                            }
                        },
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 0.dp),
                        colors = ButtonColors(
                            contentColor = Color.White,
                            containerColor = Color(34, 199, 223, 255),
                            disabledContentColor = Color.White,
                            disabledContainerColor = Color.Transparent

                        )

                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                        Text("Back")
                    }

                },
                colors = TopAppBarColors(
                    containerColor = Color(0, 16, 42, 255),
                    scrolledContainerColor = Color(0, 16, 42, 255),
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        }


    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding).padding(20.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            for ( card in getCards()){

                if( card.id == id){
                    Card(
                        colors = CardColors(
                            containerColor = Color(26, 40, 65, 255),
                            contentColor = Color.White,
                            disabledContentColor = Color.White,
                            disabledContainerColor = Color.Transparent
                        )
                    ) {
                        Text(
                            text = card.description,
                            color = Color.White,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }

            }

        }

    }

}


