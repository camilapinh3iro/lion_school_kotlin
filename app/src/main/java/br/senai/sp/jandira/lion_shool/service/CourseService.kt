package br.senai.sp.jandira.lion_shool.service

import br.senai.sp.jandira.lion_shool.model.CursosList
import br.senai.sp.jandira.lion_shool.model.Student
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CourseService {
    @GET("cursos")
    fun  getCursos(): Call<CursosList>


}