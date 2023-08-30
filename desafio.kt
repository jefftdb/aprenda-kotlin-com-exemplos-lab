enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val matricula:String, var nota:Int )

data class ConteudoEducacional(val nome: String, var duracao: Int = 60, val nivel:Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    val listIscritos:List<Usuario> = inscritos
     
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        
    }
    
    fun alunosDessaFormacao():List<Usuario>{
        return inscritos
        
    }
    
    fun conteudoDessaFormacao():List<ConteudoEducacional>{
        return conteudos
    }
}

fun main() {
    
    // Define o nível dos conteúdos
   	val basico = Nivel.BASICO
    val intermediario = Nivel.INTERMEDIARIO
    val avancado = Nivel.AVANCADO
   
    
    // Cadastra conteúdos
    
    val conteudoUm = ConteudoEducacional("Conteudo Um", 30,basico)
    val conteudoDois = ConteudoEducacional("Conteudo Dois", 45,intermediario)
    val conteudoTres = ConteudoEducacional("Conteudo Três", 65,avancado)
    
    val conteudos: MutableList<ConteudoEducacional> = mutableListOf(conteudoUm,conteudoDois,conteudoTres)
    
 
    
       
    //Cadastra Alunos
    
    val jefferson = Usuario("Jefferson","1",10)
    val neyder = Usuario("Neyder","2",8)
    val elias = Usuario("Elias","3",5)
    
    
    // Criando a Formação
    
    val primeiroSemestre = Formacao("1º Semestre", conteudos)
    
    // Matricula os alunos
    
    primeiroSemestre.matricular(jefferson)
    primeiroSemestre.matricular(neyder)
    primeiroSemestre.matricular(elias)
    
    // Vizualiza os alunos cadastrados
    println(primeiroSemestre.nome)
    println("Alunos matriculados")
    println("-----------------------------------")
    
    primeiroSemestre.alunosDessaFormacao().forEach {
        i -> println("Nome: ${i.nome}")
        println("Matricula: ${i.matricula}")
        println("Nota: ${i.nota} ")
        println("-----------------------------------")
    }
    
    
    println("|----------------Conteudos------------------|")
    primeiroSemestre.conteudoDessaFormacao().forEach{
        i -> println("Nome: ${i.nome}")
        println("Duração: ${i.duracao} horas")
        println("Nível: ${i.nivel} ")
        println("-----------------------------------")
    }
    
    
    
}