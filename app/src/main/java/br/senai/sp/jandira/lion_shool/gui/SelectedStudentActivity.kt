


package br.senai.sp.jandira.lion_shool.gui

import CircularProgressBar
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import br.senai.sp.jandira.lion_shool.model.Student
import br.senai.sp.jandira.lion_shool.model.StudentList
import br.senai.sp.jandira.lion_shool.service.RetrofitFactory
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
    var context = LocalContext.current
    var alunos by remember {
        mutableStateOf(listOf<br.senai.sp.jandira.lion_shool.model.Student>())
    }

    // Chamada para a API
    val call = RetrofitFactory().getAunosService().getAlunoMatricula(matricula)

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
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            Column() {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(46.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.student_boy),
                            contentDescription = "oi",
                            modifier = Modifier.size(124.dp)
                        )
                        Text(
                            text = "Jose Matheus da Silva Miranda",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    text = "MATÉRIAS",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
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
                            Row(
                                modifier = Modifier.fillMaxHeight(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                val progress =
                                    remember { mutableStateOf(0.82f) } // Set the progress value here
                                CircularProgressBar(progress.value, 1.dp, color = Color.Blue)
                                Column(
                                    modifier = Modifier.fillMaxHeight(),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = "SOP",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                    Text(
                                        text = "Sistemas Operacionais",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Light
                                    )
                                }
                            }
                            Card(
                                modifier = Modifier
                                    .height(55.dp)
                                    .width(3.dp),
                                backgroundColor = Color.Blue
                            ) {
                            }
                        }

                    }
                    Spacer(modifier = Modifier.height(18.dp))
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
                            Row(
                                modifier = Modifier.fillMaxHeight(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                val progress =
                                    remember { mutableStateOf(0.23f) } // Set the progress value here
                                CircularProgressBar(
                                    progress.value,
                                    1.dp,
                                    color = Color(193, 16, 16)
                                )
                                Column(
                                    modifier = Modifier.fillMaxHeight(),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = "IPR",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                    Text(
                                        text = "Ipr AAAAA",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Light
                                    )
                                }
                            }
                            Card(
                                modifier = Modifier
                                    .height(55.dp)
                                    .width(3.dp),
                                backgroundColor = Color(193, 16, 16),

                                ) {
                            }
                        }

                    }
                    Spacer(modifier = Modifier.height(18.dp))
                    Card(
                        modifier = Modifier
                            .height(92.dp)
                            .width(342.dp),
                        shape = RoundedCornerShape(20.dp),
                        elevation = 3.dp,
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                modifier = Modifier.fillMaxHeight(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                val progress =
                                    remember { mutableStateOf(0.55f) } // Set the progress value here
                                CircularProgressBar(progress.value, 1.dp, Color(229, 182, 87))
                                Column(
                                    modifier = Modifier.fillMaxHeight(),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = "LIMA",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                    Text(
                                        text = "Linguagem de Marcação",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Light
                                    )
                                }
                            }
                            Card(
                                modifier = Modifier
                                    .height(55.dp)
                                    .width(3.dp),
                                backgroundColor = Color(229, 182, 87)
                            ) {
                            }
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