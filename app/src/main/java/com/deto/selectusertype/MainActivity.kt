package com.deto.selectusertype
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deto.selectusertype.ui.theme.SelectUserTypeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SelectUserTypeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize().padding(10.dp),
                    containerColor = Color(26, 31, 61),
                    topBar = { ButtonBack() }
                ) { innerPadding ->

                    Column() {

                        SelectUserType(
                            modifier = Modifier.padding(innerPadding)
                        )

                        Row(

                        ) {

                            CustomCard("Author")
                            CustomCard("Editor")

                        }

                        Row(

                        ) {
                            CustomCard("Moderator")
                            CustomCard("Accountant")

                        }

                        Row(

                        ) {
                            CustomCard("Designer")
                            CustomCard("Developer")

                        }
                    }

                }
            }
        }
    }
}

@Composable
fun ButtonBack( ){
    Button( onClick = { } ) {

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
fun CustomCard(name: String){
    Card(
        modifier = Modifier.fillMaxWidth(.3f).fillMaxHeight(.3f),
        elevation = CardDefaults.cardElevation( defaultElevation = 8.dp ),
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




