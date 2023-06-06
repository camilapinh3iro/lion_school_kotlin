package br.senai.sp.jandira.lion_shool.gui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lion_shool.R
import br.senai.sp.jandira.lion_shool.gui.ui.theme.Lion_shoolTheme
import br.senai.sp.jandira.lion_shool.model.Curso
import br.senai.sp.jandira.lion_shool.model.CursosList
import br.senai.sp.jandira.lion_shool.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
    var context = LocalContext.current
    var cursos by remember {
        mutableStateOf(listOf<br.senai.sp.jandira.lion_shool.model.Curso>())
    }

    // Chamada para a API
    val call = RetrofitFactory().getCourseService().getCursos()

    call.enqueue(object : Callback<CursosList> {

        override fun onResponse(
            call: Call<CursosList>,
            response: Response<CursosList>
        ) {
            cursos = response.body()!!.cursos
            Log.i("ds2m", "onResponse: ${cursos}")
        }

        override fun onFailure(call: Call<CursosList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message} "
            )
        }

    })

    Lion_shoolTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
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

                LazyColumn() {
                    items(cursos) {
                        Button(
                            onClick = {
                                val intent = Intent(context, SelectedCourse::class.java)
                                intent.putExtra("sigla", "${it.sigla}")
                                intent.putExtra("nome", "${it.nome}")
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
                                text = "${it.sigla}",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White

                            )
                        }
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }

            }

        }


    }

}
