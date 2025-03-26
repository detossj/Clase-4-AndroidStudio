package com.deto.selectusertype
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deto.selectusertype.ui.theme.SelectUserTypeTheme

class MainActivity : ComponentActivity() {

    val cardList = listOf(
        CardInfo(R.string.author_card_title,R.drawable.history_edu_24px),
        CardInfo(R.string.editor_card_title, R.drawable.border_color_24px),
        CardInfo(R.string.moderator_card_title, R.drawable.manage_accounts_24px),
        CardInfo(R.string.accountant_card_title, R.drawable.assignment_ind_24px),
        CardInfo(R.string.designer_card_title, R.drawable.stylus_note_24px),
        CardInfo(R.string.developer_card_title, R.drawable.code_24px)

    )

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SelectUserTypeTheme {
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
                    }

                ) { innerPadding ->

                    Column(
                        modifier = Modifier.padding(innerPadding).padding(20.dp).fillMaxWidth()
                    ) {


                        Spacer(modifier = Modifier.height(10.dp))

                        SelectUserType()

                        PleaseChoose()

                        Spacer(modifier = Modifier.height(20.dp))

                        Row( modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)  ) {

                            CustomCard("Author", Modifier.weight(1f))
                            CustomCard("Editor", Modifier.weight(1f))

                        }

                        Row( modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)  ) {
                            CustomCard("Moderator", Modifier.weight(1f))
                            CustomCard("Accountant", Modifier.weight(1f))

                        }

                        Row( modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)  ) {
                            CustomCard("Designer", Modifier.weight(1f))
                            CustomCard("Developer", Modifier.weight(1f))

                        }

                        Row( modifier = Modifier
                            .fillMaxWidth() ) {
                            Text(
                                modifier = Modifier.background(color = Color(44, 52, 94)).padding(20.dp),
                                text = "Enter as a guest",
                                color = Color.Gray,

                            )

                            Spacer(Modifier.width(40.dp))

                            Button( onClick = {}, colors = ButtonColors( contentColor = Color.White, containerColor = Color(50, 233, 219), disabledContentColor = Color.Gray, disabledContainerColor = Color.Blue)) {
                                Icon(

                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Icon",
                                    tint = Color.White
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun ButtonBack(  ){
    Button( onClick = { }, colors = ButtonColors( contentColor = Color.White, containerColor = Color(50, 233, 219), disabledContentColor = Color.Gray, disabledContainerColor = Color.Blue)  ) {



        Text(
            text = "Back"
        )
    }
}


@Composable
fun SelectUserType(modifier: Modifier = Modifier) {
    Text(
        text = "Select User Type",
        fontSize = 32.sp,
        color = Color.White,
        modifier = modifier
    )
}

@Composable
fun PleaseChoose(modifier: Modifier = Modifier) {
    Text(
        text = "Please Choose your profession",
        fontSize = 16.sp,
        color = Color.Gray,
        modifier = modifier
    )
}

@Composable
fun CustomCard(name: String, modifier: Modifier = Modifier ){
    Card(
        //modifier = Modifier.fillMaxWidth(.3f).fillMaxHeight(.3f),
        modifier = modifier.padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(44, 52, 94)
        )
    ) {

        Text(
            text = "$name",
            color = Color.White,
            modifier = Modifier.padding(5.dp)
        )
    }
}

class CardInfo( val title: Int, val icon: Int )




