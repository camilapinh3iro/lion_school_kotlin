package br.senai.sp.jandira.lion_shool.model

data class AlunoCurso(
    val nome: String? = null,
    val sigla: String? = null,
    val carga: String? = null,
    val icone: String? = null,
    val conclusao: String? = null,
    var disciplinas: List<Disciplina>? = null

)

