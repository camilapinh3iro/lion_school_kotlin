package br.senai.sp.jandira.lion_shool.service

import br.senai.sp.jandira.lion_shool.model.StudentList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    private val URL_BASE = "https://backlion-school-production.up.railway.app/v1/lion-school/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCourseService(): CourseService {
        return retrofitFactory.create(CourseService::class.java)
    }

    fun getAunosService(): StudentService{
        return retrofitFactory.create(StudentService::class.java)
    }

}