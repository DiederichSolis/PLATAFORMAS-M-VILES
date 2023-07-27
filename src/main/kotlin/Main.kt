//Diederich Solis #22952
//LAB 3
fun main() {
    //TAREA 1
    println("TAREA 1:  ")
    val listaNumeros = listOf(20, 25, 30, 28, 24, 23, 32, 21, 20, 38)
    val promedio = calcularPromedio(listaNumeros)
    println("Promedio: $promedio")

    //TAREA 2
    println(" ")
    println("TAREA 2:  ")
    val listaNumeros1 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numerosImpares = filterNumerosImpares(listaNumeros1)
    println("Números impares: $numerosImpares")

    //TAREA 3
    println(" ")
    println("TAREA 3:  ")
    val cadena1 = "reconocer"
    val cadena2 = "hola"
    println("¿'$cadena1' es un palíndromo? ${isPalindrome(cadena1)}")
    println("¿'$cadena2' es un palíndromo? ${isPalindrome(cadena2)}")

    //TAREA 4
    println(" ")
    println("TAREA 4:  ")
    val nombres = listOf("Alicia", "Thomas", "Danilo")
    val saludos = addSaludoNombres(nombres)
    println(saludos)

    //TAREA 5
    println(" ")
    println("TAREA 5:  ")
    val resultadoSuma = performOperation(5, 3) { x, y -> x + y }
    println("Suma: $resultadoSuma")

    val resultadoResta = performOperation(10, 6) { x, y -> x - y }
    println("Resta: $resultadoResta")


    //
    println(" ")
    println("TAREA 6:  ")
    val personas = listOf(
        Person("Diederich", 25, "Masculino"),
        Person("Dania", 30, "Femenino"),
        Person("Josue", 22, "Masculino")
    )

    val estudiantes = personas.map { mapPersonToStudent(it) }
    estudiantes.forEach { println("El Estudiante ${it.name} tiene ${it.age} años") }
}



//TAREA 1
fun calcularPromedio(lista: List<Int>): Double {
    // Usamos la función reduce para sumar todos los elementos de la lista
    val suma = lista.reduce { acc, num -> acc + num }
    return suma.toDouble() / lista.size
}

//TAREA 2
fun filterNumerosImpares(lista: List<Int>): List<Int> {
    return lista.filter { it % 2 != 0 }
}


//TAREA 3
fun isPalindrome(cadena: String): Boolean {
    val reversed = cadena.reversed()
    return cadena == reversed
}

//TAREA 4
fun addSaludoNombres(nombres: List<String>): List<String> {
    return nombres.map { "¡Hola, $it!" }
}

//TAREA 5
fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

//TAREA 6
data class Person(val name: String, val age: Int, val gender: String)
data class Student(val name: String, val age: Int, val gender: String, val studentId: String)

fun mapPersonToStudent(person: Person): Student {
    return Student(person.name, person.age, person.gender, "")
}
