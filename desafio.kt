// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
    }
}

fun exibirInscritos(formacao: Formacao) {
    val inscritos = formacao.inscritos
    print("-".repeat(40))
    println()
    inscritos.let { it.forEach { i -> println("Nome: ${i.nome} | Email: ${i.email}") } }
    print("-".repeat(40))
    println()
    println()
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    val formacaoKotlin = Formacao(
        "Kotlin",
        mutableListOf(
            ConteudoEducacional("Variáveis", nivel = Nivel.BASICO),
            ConteudoEducacional("Funções", nivel = Nivel.INTERMEDIARIO),
            ConteudoEducacional("Funções", nivel = Nivel.AVANCADO),
        )
    )

    val formacaoJava = Formacao(
        "Java",
        mutableListOf(
            ConteudoEducacional("Spring Boot", duracao = 120, Nivel.INTERMEDIARIO),
            ConteudoEducacional("API Restful", duracao = 120, Nivel.AVANCADO)
        )
    )

    println("Matriculando os alunos...")
    formacaoKotlin.matricular(Usuario("Jose da Silva", "jose@gmail.com"))
    formacaoJava.matricular(Usuario("Manoel da Nobrega", "manoel@gmail.com"))
    formacaoJava.matricular(Usuario("Maria da Fonseca", "maria@hotmail.com.br"))
    formacaoKotlin.matricular(Usuario("Manoela Santos", "manoela@hotmail.com.br"))
    formacaoJava.matricular(Usuario("Roberta Matos", "roberta@hotmail.com.br"))

    println("Quantidade de alunos matriculados na formação Kotlin: ${formacaoKotlin.inscritos.size}")
    exibirInscritos(formacaoKotlin)
    println("Quantidade de alunos matriculados na formação Java: ${formacaoJava.inscritos.size}")
    exibirInscritos(formacaoJava)
}