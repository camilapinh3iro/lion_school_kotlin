package br.senai.sp.jandira.lion_shool.gui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lion_shool.R
import br.senai.sp.jandira.lion_shool.model.Curso
import br.senai.sp.jandira.lion_shool.model.CursosList
import br.senai.sp.jandira.lion_shool.service.RetrofitFactory
import br.senai.sp.jandira.lion_shool.ui.theme.Lion_shoolTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lion_shoolTheme {

                Lion_schoolScreen()
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun Lion_schoolScreen() {
    var context = LocalContext.current

    Lion_shoolTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.primary_color)
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(top = 220.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painterResource(id = R.drawable.logo_image),
                        contentDescription = "Logo Lion School",
                        modifier = Modifier
                            .width(65.dp)
                            .height(85.dp)
                    )
                    Text(
                        text = stringResource(R.string.school_name).uppercase(),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .width(110.dp)
                            .padding(start = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.height(220.dp))

                Button(
                    onClick = {
                        val intent = Intent(context, SelectCourse::class.java)
                        context.startActivity(intent)

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
