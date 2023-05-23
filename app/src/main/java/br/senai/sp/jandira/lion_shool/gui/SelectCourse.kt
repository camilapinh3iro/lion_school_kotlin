package br.senai.sp.jandira.lion_shool.gui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lion_shool.R
import br.senai.sp.jandira.lion_shool.gui.ui.theme.Lion_shoolTheme

class SelectCourse : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lion_shoolTheme {
                // A surface container using the 'background' color from the theme

                SelectCourseScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SelectCourseScreen() {
    Lion_shoolTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(id = R.string.welcome).uppercase(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(50.dp))
                Row() {
                    Text(
                        text = stringResource(id = R.string.choose_one),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = stringResource(id = R.string.course),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.primary_color)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = stringResource(id = R.string.to_manage),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(50.dp))
                Image(
                    painterResource(id = R.drawable.classe_image),
                    contentDescription = "Logo Lion School",
                    modifier = Modifier
                        .width(300.dp)
                        .height(200.dp)
                )
                Spacer(modifier = Modifier.height(50.dp))

                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .width(190.dp)
                        .height(45.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.secondary_color)),
                    shape = RoundedCornerShape(30.dp)

                )
                {
                    Text(
                        text = stringResource(id = R.string.classes_button),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White

                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .width(190.dp)
                        .height(45.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.secondary_color)),
                    shape = RoundedCornerShape(30.dp)

                )
                {
                    Text(
                        text = stringResource(id = R.string.classes_button),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White

                    )
                }
            }
            
        }
    }

}
