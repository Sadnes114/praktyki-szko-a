//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.google.gson.Gson

data class User(val name: String, val age: Int)

fun main() {
    val user = User("Jan", 25)

    val gson = Gson()
    val json = gson.toJson(user)

    println("Wygenerowany JSON:")
    println(json)
}
