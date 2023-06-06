package br.senai.sp.jandira.lion_shool.gui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lion_shool.R
import br.senai.sp.jandira.lion_shool.gui.ui.theme.ui.theme.Lion_shoolTheme
import br.senai.sp.jandira.lion_shool.model.CursosList
import br.senai.sp.jandira.lion_shool.model.StudentList
import br.senai.sp.jandira.lion_shool.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SelectedCourse : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var siglaCurso = intent.getStringExtra("sigla").toString()
        var nomeCurso = intent.getStringExtra("nome").toString()
        Log.i("ds2m", "${siglaCurso}")
        setContent {
            Lion_shoolTheme {
                // A surface container using the 'background' color from the theme
                SelectedCourseScreen(siglaCurso, nomeCurso)
            }
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun SelectedCourseScreen(sigla: String, nome: String) {
    var context = LocalContext.current
    var alunos by remember {
        mutableStateOf(listOf<br.senai.sp.jandira.lion_shool.model.Student>())
    }

    // Chamada para a API
    val call = RetrofitFactory().getAunosService().getAlunos(sigla)

    call.enqueue(object : Callback<StudentList> {

        override fun onResponse(
            call: Call<StudentList>,
            response: Response<StudentList>
        ) {
            alunos = response.body()!!.alunos
            Log.i("ds2m", "onResponse: ${alunos}")
        }

        override fun onFailure(call: Call<StudentList>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message} "
            )
        }

    })

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
                                text = nome,
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

                LazyColumn() {
                    items(alunos) {
                        Card(
                            modifier = Modifier
                                .height(78.dp)
                                .fillMaxWidth().clickable {
                                    val intent = Intent(context, SelectedStudentActivity::class.java)
                                    intent.putExtra("matricula", "${it.matricula}")
                                    context.startActivity(intent)
                                    

                                },
                            backgroundColor = Color.White

                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxHeight(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    AsyncImage(
                                        model = it.foto,
                                        contentDescription = "${it.nome}",
                                        modifier = Modifier
                                            .width(60.dp)
                                            .height(60.dp)
                                    )

                                    Spacer(modifier = Modifier.width(15.dp))

                                    Column() {
                                        Text(
                                            "${it.nome}"
                                        )
                                        Text(
                                            "${it.status}",
                                            color = Color(red = 93, green = 92, blue = 92),
                                            fontSize = (14.sp)
                                        )
                                    }
                                }
                            }
                        }
                    }

//                Column() {
//                    Card(
//                        modifier = Modifier
//                            .height(78.dp)
//                            .fillMaxWidth(),
//                        backgroundColor = Color.White
//
//                    ) {
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(start = 10.dp, end = 10.dp),
//                            verticalAlignment = Alignment.CenterVertically,
//                            horizontalArrangement = Arrangement.SpaceBetween
//                        ) {
//                            Row(modifier = Modifier.fillMaxHeight(),
//                            verticalAlignment = Alignment.CenterVertically) {
//                                Image(
//                                    painterResource(id = R.drawable.student_boy),
//                                    contentDescription = "Student",
//                                    modifier = Modifier
//                                        .width(60.dp)
//                                        .height(60.dp)
//                                )
//                                Spacer(modifier = Modifier.width(15.dp))
//
//                                Column() {
//                                    Text(text = stringResource(id = R.string.student_name))
//                                    Text(text = stringResource(id = R.string.status_studying),
//                                    color = Color(red = 93, green = 92, blue = 92),
//                                    fontSize = (14.sp))
//                                }
//                            }
//
//
//                            Card(
//                                modifier = Modifier
//                                    .height(15.dp)
//                                    .width(15.dp),
//                                shape = RoundedCornerShape(15.dp),
//                                backgroundColor = Color(red = 51, green = 71, blue = 176)
//                            ) {
//
//                            }
//
//                        }
//                    }
//                    Card(
//                        modifier = Modifier
//                            .height(78.dp)
//                            .fillMaxWidth(),
//                        backgroundColor = Color.White
//
//                    ) {
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(start = 10.dp, end = 10.dp),
//                            verticalAlignment = Alignment.CenterVertically,
//                            horizontalArrangement = Arrangement.SpaceBetween
//                        ) {
//                            Row(modifier = Modifier.fillMaxHeight(),
//                                verticalAlignment = Alignment.CenterVertically) {
//                                Image(
//                                    painterResource(id = R.drawable.student_boy),
//                                    contentDescription = "Student",
//                                    modifier = Modifier
//                                        .width(60.dp)
//                                        .height(60.dp)
//                                )
//                                Spacer(modifier = Modifier.width(15.dp))
//
//                                Column() {
//                                    Text(text = stringResource(id = R.string.student_name))
//                                    Text(text = stringResource(id = R.string.status_finished),
//                                        color = Color(red = 93, green = 92, blue = 92),
//                                        fontSize = (14.sp))
//                                }
//                            }
//
//
//                            Card(
//                                modifier = Modifier
//                                    .height(15.dp)
//                                    .width(15.dp),
//                                shape = RoundedCornerShape(15.dp),
//                                backgroundColor = Color(red = 255, green = 193, blue = 62)
//                            ) {
//
//                            }
//
//                        }
//                    }
//                }


                }
            }
        }
    }
}