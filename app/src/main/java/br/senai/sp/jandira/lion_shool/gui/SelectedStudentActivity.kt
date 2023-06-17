


package br.senai.sp.jandira.lion_shool.gui

import CircularProgressBar
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lion_shool.R
import br.senai.sp.jandira.lion_shool.gui.ui.theme.Lion_shoolTheme
import br.senai.sp.jandira.lion_shool.model.Disciplina
import br.senai.sp.jandira.lion_shool.model.Student
import br.senai.sp.jandira.lion_shool.model.StudentList
import br.senai.sp.jandira.lion_shool.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SelectedStudentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var matricula = intent.getStringExtra("matricula").toString()
        Log.i("ds2m", "${matricula}")
        setContent {
            Lion_shoolTheme {
                // A surface container using the 'background' color from the theme
                SelectedStudent(matricula)
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun SelectedStudent(matricula : String) {


//    var context = LocalContext.current
    var alunos by remember {
        mutableStateOf(Student())
    }

    var disciplinas by remember {
        mutableStateOf(listOf<Disciplina>())
    }

    // Chamada para a API
    val call = RetrofitFactory().getAunosService().getAlunoMatricula(matricula)

    call.enqueue(object : Callback<Student> {

        override fun onResponse(
            call: Call<Student>,
            response: Response<Student>
        ) {
//            alunos.nome = response.body()!!.nome
            alunos = response.body()!!
            disciplinas = response.body()!!.curso?.get(0)!!.disciplinas!!
            Log.i("ds2m", "onResponse: ${alunos}")
        }

        override fun onFailure(call: Call<Student>, t: Throwable) {
            Log.i(
                "ds2m",
                "onFailure: ${t.message} "
            )
        }

    })

    Lion_shoolTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            Column() {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                  Column(

                  ) {
                      Row(
                          verticalAlignment = Alignment.CenterVertically,
                          modifier = Modifier
                              .padding(top = 46.dp, end = 46.dp, start = 46.dp, bottom = 30.dp)
                      ) {

                          AsyncImage(
                              model = alunos.foto,
                              contentDescription = "${alunos.nome}",
                              modifier = Modifier.size(124.dp)
                          )

                          Text(
                              text = "${alunos.nome}".uppercase(),
                              fontSize = 20.sp,
                              textAlign = TextAlign.Center,
                              fontWeight = FontWeight.Bold
                          )
                      }

                      Column(
                          modifier = Modifier
                              .padding( end = 46.dp, start = 46.dp, bottom = 25.dp)
                      ) {

                          Row() {
                              Text(
                                  text = "Matricula:",
                                  fontSize = 15.sp,
                                  fontWeight = FontWeight.Bold
                              )
                              Text(
                                  text = "${alunos.matricula}",
                                  modifier = Modifier.padding(start = 5.dp),
                                  fontSize = 14.sp,
                                  fontWeight = FontWeight.Medium
                              )
                          }
                          Row() {
                              Text(
                                  text = "Status:",
                                  fontSize = 15.sp,
                                  textAlign = TextAlign.Start,
                                  fontWeight = FontWeight.Bold
                              )
                              Text(
                                  text = "${alunos.status}",
                                  modifier = Modifier.padding(start = 5.dp),
                                  fontSize = 14.sp,
                                  fontWeight = FontWeight.Medium
                              )
                          }
                  }



                    }
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    text = "MATÉRIAS",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    /////////////////////////////////
                    LazyColumn(){
                        items(disciplinas){

                        Card(
                            modifier = Modifier
                                .height(92.dp)
                                .width(342.dp),
                            shape = RoundedCornerShape(20.dp),
                            elevation = 3.dp
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                val media =
                                    remember { mutableStateOf(it.media.toFloat()) }// Set the progress value here
                                val progress = media.value / 100

                                val cor =  if (progress > 0.50) {
                                    Color(51, 71, 176)
                                } else if (progress < 0.50 ){
                                    Color(193, 16, 16)
                                } else {
                                    Color(252, 191, 64)
                                }
                                Row(
                                    modifier = Modifier.fillMaxHeight(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    CircularProgressBar(progress, 1.dp, cor)
                                    Column(
                                        modifier = Modifier.fillMaxHeight(),
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = "${it.nome}",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Medium
                                        )
                                        Text(
                                            text = "Matéria estudada",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Light
                                        )
                                    }
                                }
                                Card(
                                    modifier = Modifier
                                        .height(55.dp)
                                        .width(3.dp),
                                    backgroundColor = cor
                                ) {
                                }
                            }

                        }

                            Spacer(modifier = Modifier.height(18.dp))
                        }

                    }







                }
            }
        }
    }
}




//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun DefaultPreview() {
//    Lion_shoolTheme() {
//        SelectedStudent()
//    }
//}

//@Composable
//fun CircularProgressBar(progress: Float) {
//    CircularProgressIndicator(
//        progress = progress,
//        modifier = Modifier
//            .size(64.dp)
//            .padding(16.dp),
//        color = Color.Blue, // Customize the color here
//        strokeWidth = 3.dp // Customize the thickness here
//    )
//}


//package br.senai.sp.jandira.lion_shool.gui
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import br.senai.sp.jandira.lion_shool.gui.ui.theme.Lion_shoolTheme
//
//class SelectedStudentActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            Lion_shoolTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }
//    }
//}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    Lion_shoolTheme {
//        Greeting("Android")
//    }
//}