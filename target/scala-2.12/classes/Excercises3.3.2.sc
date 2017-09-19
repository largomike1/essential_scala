class Person (val firstName: String, val lastName: String) {

}

object Person {
  def apply(name: String): Person = {
    val parts = name.split(" ")
    new Person(parts(0), parts(1))
  }
}

val aPerson = Person("Michael Stein")
aPerson.firstName + " - " + aPerson.lastName

//up to page 51