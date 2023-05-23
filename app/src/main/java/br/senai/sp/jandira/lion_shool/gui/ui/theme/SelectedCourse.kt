package br.senai.sp.jandira.lion_shool.gui.ui.theme

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lion_shool.R
import br.senai.sp.jandira.lion_shool.gui.SelectCourse
import br.senai.sp.jandira.lion_shool.gui.SelectCourseScreen
import br.senai.sp.jandira.lion_shool.gui.ui.theme.ui.theme.Lion_shoolTheme

class SelectedCourse : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lion_shoolTheme {
                // A surface container using the 'background' color from the theme
                SelectedCourseScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SelectedCourseScreen() {
    Lion_shoolTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(155.dp),
                shape = RoundedCornerShape(bottomStart = 70.dp), 
                backgroundColor = Color(red = 51, green = 71, blue = 176)
            ) {
                Column() {
                    
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(59.dp)
                    .padding(start = 25.dp, top = 19.dp),
                ) {
                    Image(
                        painterResource(id = R.drawable.menu_image),
                        contentDescription = "Menu",
                        modifier = Modifier
                            .width(21.dp)
                            .height(16.dp)
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = stringResource(R.string.course_name).uppercase(),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,

                        )
                }

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .width(110.dp)
                            .height(40.dp),

                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.primary_color)),
                        shape = RoundedCornerShape(30.dp),
                        border = BorderStroke(1.dp, Color.White)

                    )
                    {
                        Text(
                            text = stringResource(id = R.string.status_finished),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White

                        )
                    }
                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .width(110.dp)
                            .height(40.dp),

                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.primary_color)),
                        shape = RoundedCornerShape(30.dp),
                        border = BorderStroke(1.dp, Color.White)

                    )
                    {
                        Text(
                            text = stringResource(id = R.string.status_studying),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White

                        )
                    }
                }

            }

            LazyColumn() {
//                items(trips) {
//                    Card(modifier = Modifier.fillMaxWidth().padding(16.dp),
//                        backgroundColor = Color.Cyan) {
//                        Column(modifier = Modifier.padding(8.dp)) {
//                            Image(painter = painterResource(id = R.drawable.no_photography_24), contentDescription = "")
//                            Text(text = "${it.location}, ${it.startDate.year}")
//                            Text(text = "${it.description}")
//                            Text(
//                                text = "${it.startDate} - ${it.endDate}",
//                                modifier = Modifier.fillMaxWidth(),
//                                textAlign = TextAlign.End
//                            )
//                        }
//                    }
//                }
            }
        }
    }
    }
}