package br.senai.sp.jandira.lion_shool.gui

import CircularProgressBar
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lion_shool.R
import br.senai.sp.jandira.lion_shool.gui.ui.theme.Lion_shoolTheme


class ContactUsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lion_shoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    ContactUs()
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ContactUs() {
    Surface() {
        Column() {
            Column(
                modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.contact_us_image),
                    contentDescription = stringResource(
                        id = R.string.facebook_description
                    ),
                    modifier = Modifier.width(332.dp).height(200.dp)
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                text = "CONTATE-NOS",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Column(
                modifier = Modifier.padding(horizontal = 42.dp)
            ) {
                Text(
                    text = "" +
                            "Entre em contato em qualquer hora e em qualquer lugar. Nós estamos prontos para tirar todas suas dúvidas e resolver todos os seus problemas."
                )
                Column(
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    Text(text = "(11) 4774-4700", fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "lionschool@gmail.com", fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Rua tcc, 211,  Centro, Jandira", fontSize = 14.sp)
                }
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                text = "REDES SOCIAIS",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier = Modifier
                        .height(80.dp)
                        .width(120.dp),
                    shape = RoundedCornerShape(20.dp),
                    elevation = 4.dp
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = stringResource(
                                id = R.string.facebook_description
                            ),
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            text = "Facebook",
                            modifier = Modifier.padding(start = 6.dp),
                            color = Color.Blue
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .height(80.dp)
                        .width(120.dp),
                    shape = RoundedCornerShape(20.dp),
                    elevation = 4.dp
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.instagram),
                            contentDescription = stringResource(
                                id = R.string.facebook_description
                            ),
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            text = "Instagram",
                            modifier = Modifier.padding(start = 6.dp),
                            color = Color.Blue
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier = Modifier
                        .height(80.dp)
                        .width(120.dp),
                    shape = RoundedCornerShape(20.dp),
                    elevation = 4.dp
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.twitter),
                            contentDescription = stringResource(
                                id = R.string.twitter_description
                            ),
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            text = "Twitter",
                            modifier = Modifier.padding(start = 6.dp),
                            color = Color.Blue
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .height(80.dp)
                        .width(120.dp),
                    shape = RoundedCornerShape(20.dp),
                    elevation = 4.dp
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.youtube),
                            contentDescription = stringResource(
                                id = R.string.youtube_description
                            ),
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            text = "Youtube",
                            modifier = Modifier.padding(start = 6.dp),
                            color = Color.Blue
                        )
                    }
                }
            }
        }
    }
}