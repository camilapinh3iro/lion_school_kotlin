package br.senai.sp.jandira.lion_shool.service

import br.senai.sp.jandira.lion_shool.model.StudentList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StudentService {
    @GET("alunos")
    fun  getAlunos(@Query("curso") curso: String): Call<StudentList>
}