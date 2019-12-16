package br.com.beblue.bluerecords.core.usecase.disco.command

data class CadastrarDiscoCommand(
    val nome: String,
    val idGenero : Int,
    val valor : Double
)