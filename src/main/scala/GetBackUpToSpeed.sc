"Test".toUpperCase()

1 + 2

"this is a string"

null

println("x")

object Test {
  def makeUpper(stringVar: String): String = {
    stringVar.toUpperCase()
  }

  val color: String = "blue"
}

Test.makeUpper("howdy")

Test.color

object cat1 {
  val name: String = "Oswald"
  val color: String = "Black"
  val food: String = "Milk"
}

cat1.name

assert(cat1.name == "Oswald")

