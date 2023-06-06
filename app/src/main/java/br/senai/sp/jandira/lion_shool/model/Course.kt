package br.senai.sp.jandira.lion_shool.model

data class Curso(
    val nome: String,
    val sigla: String,
    val disciplinas: List<Disciplina>
)