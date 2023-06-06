package br.senai.sp.jandira.lion_shool.service

import br.senai.sp.jandira.lion_shool.model.CursosList
import retrofit2.Call
import retrofit2.http.GET

interface CourseService {
    @GET("cursos")
    fun  getCursos(): Call<CursosList>
}