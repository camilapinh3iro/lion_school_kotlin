package br.senai.sp.jandira.lion_shool.gui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lion_shool.R
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
//    var results by remember {
//        mutableStateOf(listOf<br.senai.sp.jandira.rickandmorty.model.Character>())
//    }

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
                        Row(
                            modifier = Modifier
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

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
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
                            Spacer(modifier = Modifier.width(15.dp))
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

                }
                Spacer(modifier = Modifier.height(35.dp))

                Column() {
                    Card(
                        modifier = Modifier
                            .height(78.dp)
                            .fillMaxWidth(),
                        backgroundColor = Color.White

                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, end = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(modifier = Modifier.fillMaxHeight(),
                            verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painterResource(id = R.drawable.student_boy),
                                    contentDescription = "Student",
                                    modifier = Modifier
                                        .width(60.dp)
                                        .height(60.dp)
                                )
                                Spacer(modifier = Modifier.width(15.dp))

                                Column() {
                                    Text(text = stringResource(id = R.string.student_name))
                                    Text(text = stringResource(id = R.string.status_studying),
                                    color = Color(red = 93, green = 92, blue = 92),
                                    fontSize = (14.sp))
                                }
                            }


                            Card(
                                modifier = Modifier
                                    .height(15.dp)
                                    .width(15.dp),
                                shape = RoundedCornerShape(15.dp),
                                backgroundColor = Color(red = 51, green = 71, blue = 176)
                            ) {

                            }

                        }
                    }
                    Card(
                        modifier = Modifier
                            .height(78.dp)
                            .fillMaxWidth(),
                        backgroundColor = Color.White

                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, end = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(modifier = Modifier.fillMaxHeight(),
                                verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painterResource(id = R.drawable.student_boy),
                                    contentDescription = "Student",
                                    modifier = Modifier
                                        .width(60.dp)
                                        .height(60.dp)
                                )
                                Spacer(modifier = Modifier.width(15.dp))

                                Column() {
                                    Text(text = stringResource(id = R.string.student_name))
                                    Text(text = stringResource(id = R.string.status_finished),
                                        color = Color(red = 93, green = 92, blue = 92),
                                        fontSize = (14.sp))
                                }
                            }


                            Card(
                                modifier = Modifier
                                    .height(15.dp)
                                    .width(15.dp),
                                shape = RoundedCornerShape(15.dp),
                                backgroundColor = Color(red = 255, green = 193, blue = 62)
                            ) {

                            }

                        }
                    }
                }


            }
        }
    }
}