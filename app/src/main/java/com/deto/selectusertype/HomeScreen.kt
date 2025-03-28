package com.deto.selectusertype

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.deto.selectusertype.ui.theme.SelectUserTypeTheme

fun getCards(): List<CardInfo>{
    val cardList = listOf(
        CardInfo(
            R.string.author_card_title,
            R.drawable.history_edu_24px,
            1,
            "Creates written content such as articles, blogs, or documentation."
        ),
        CardInfo(
            R.string.editor_card_title,
            R.drawable.border_color_24px,
            2,
            "Reviews and refines content to ensure clarity, consistency, and accuracy."
        ),
        CardInfo(
            R.string.moderator_card_title,
            R.drawable.manage_accounts_24px,
            3,
            "Manages online communities and ensures respectful and safe interactions."
        ),
        CardInfo(
            R.string.accountant_card_title,
            R.drawable.assignment_ind_24px,
            4,
            "Handles financial records, budgeting, and accounting operations."
        ),
        CardInfo(
            R.string.designer_card_title,
            R.drawable.stylus_note_24px,
            5,
            "Creates visual designs and user interfaces for digital products."
        ),
        CardInfo(
            R.string.developer_card_title,
            R.drawable.code_24px,
            6,
            "Builds software applications and maintains system functionality."
        )

    )

    return cardList
}

class CardInfo(val title: Int, val icon: Int, val id: Int, val description: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    var select by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0, 16, 42, 255),
        topBar = {
            TopAppBar(
                title = {
                    Button(
                        onClick = {},
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
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0, 16, 42, 255)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(
                        modifier = Modifier
                            .padding(PaddingValues(end = 10.dp))
                            .fillMaxWidth(.7f),
                        onClick = {},
                        colors = ButtonColors(
                            contentColor = Color.White,
                            containerColor = Color(26, 40, 65, 255),
                            disabledContentColor = Color.White,
                            disabledContainerColor = Color.Transparent
                        )
                    ) {
                        Text(stringResource(R.string.enter_guest))
                    }

                    Button(
                        onClick = { if( select ==0 ) {} else navController.navigate(SecondPage(select))},
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "Back",
                            modifier = Modifier.padding(0.dp)
                        )
                    }
                }
            }
        }

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(.9f)
            ) {
                Text(
                    text = stringResource(R.string.select),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                Text(
                    text = stringResource(R.string.please),
                    color = Color(111, 125, 150, 255),
                    fontSize = 15.sp
                )
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(20.dp),
                modifier = Modifier.fillMaxWidth()

            ) {
                items(getCards()) {
                    Card(
                        colors = CardColors(
                            containerColor = if (select == it.id) Color.Red else Color(
                                26,
                                40,
                                65,
                                255
                            ),
                            contentColor = Color.White,
                            disabledContentColor = Color.White,
                            disabledContainerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable { select = it.id }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(horizontal = 20.dp, vertical = 35.dp),
                            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Icon(
                                painter = painterResource(it.icon),
                                contentDescription = "Account Box",
                                modifier = Modifier.size(50.dp)
                            )
                            Text(
                                text = stringResource(it.title),
                                color = Color.White,
                                modifier = Modifier.padding(top = 10.dp)
                            )
                        }
                    }
                }

            }


        }

    }

}
