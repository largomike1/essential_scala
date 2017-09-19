/*

for declaring methods
def name(parameter: type, ...): resultType = {
  bodyExpression
}
and for declaring fields
val name = valueExpression
var name = valueExpression

declaring objects
object name {
declarationOrExpression ...
}
 */

/*
object Test7 {
  val simpleField = {
    println("Evaluating simpleField")
    42
  }
  def noParameterMethod = {
    println("Evaluating noParameterMethod")
    42

    val somefield = 10
  }
}

object calc {
  def square (numberToSquare: Double): Double = {
    numberToSquare * numberToSquare
  }

  def cube (numberToCube: Double): Double = {
    numberToCube * square(numberToCube)
  }
}

calc.square(5)
calc.cube(3)

object calc2 {
  def square (numberToSquare: Double): Double = {
    numberToSquare * numberToSquare
  }

  def cube (numberToCube: Double): Double = {
    numberToCube * square(numberToCube)
  }

  //overload to allow ints
  def square (numberToSquare: Int): Int = {
    numberToSquare * numberToSquare
  }

  def cube (numberToCube: Int): Int = {
    numberToCube * square(numberToCube)
  }
}

calc2.square(3)
calc2.square(3.2)
*/

/*
object argh {
  def a = {
    println("a")
    1
  }
  val b = {
    println("b")
    a + 2
  }
  def c = {
    println("c")
    a
    b + "c"
  }
}
argh.c + argh.b + argh.a
*/

/*
object person {
  val firstName = "Mike";
  val lastName = "Stein";
}

object alien {
  def greet (aPerson: person.type) = {
    "Greetings " + person.firstName
  }
}

alien.greet(person)

object calc {
  def square(x: Double) = x * x
}
val someField = calc.square(5)


def square(in: Double): Double =
  in * in

assert(square(2.0) == 4.0)
assert(square(3.0) == 9.0)
assert(square(-2.0) == 4.0)
*/
/*page 42ep
class Person (val first: String = "nofirst",val last: String = "no lastname") {
  def name = first + " " + last
}

val noel = new Person (last = "stein")
noel.name
*/

//excercise - cats pate 46
/*
class Cat (val name: String, val color: String, val food: String) {

}

val oswald = new Cat("Oswald", "Black", "Milk")
val henderson = new Cat("Henderson","Ginger","Chips")
oswald.name

object ChipShop {
  def WillServe (cat : Cat) : Boolean = {
    if (cat.food == "Chips") {
      true
    }
    else
      false
  }

}

ChipShop.WillServe(henderson)
*/
//excercise 3.1.6.3
class Director (val firstName: String, val lastName:String, val yearOfBirth: Int) {
  val name = firstName + " " + lastName
}

object Director {
  def apply (firstName: String, lastName:String, yearOfBirth: Int): Director = {
    new Director (firstName, lastName, yearOfBirth)
  }

  def older (director1: Director, director2: Director ): Director = {
    if (director1.yearOfBirth < director2.yearOfBirth) director1 else director2
  }
}

class Film (val name:String,
            val yearOfRelease:Int,
            val imdbRating: Double,
            val director: Director) {

  def directorsAge = yearOfRelease - director.yearOfBirth

  def isDirectedBy (theDirector: Director): Boolean = {
    if (director == theDirector) true else false
  }

  def copy (name:String = this.name,
            yearOfRelease:Int = this.yearOfRelease,
            imdbRating: Double = this.imdbRating,
            director: Director = this.director): Film = {
    new Film(name, yearOfRelease, imdbRating, director)
  }
}

object Film  {
  def apply (name:String,
             yearOfRelease:Int,
             imdbRating: Double,
             director: Director): Film = {

    new Film (name, yearOfRelease,imdbRating,director)
  }

  def highestRating (film1: Film, film2: Film): Film = {
    if (film1.imdbRating > film2.imdbRating) film1 else film2
  }

  def oldestDirectorAtTheTime (film1: Film, film2: Film): Director = {
    if (film1.directorsAge > film2.directorsAge) film1.director else film2.director
  }
}

//test out new companion objects
val eastwoodCO = Director("Clint", "Eastwood", 1930)
val mcTiernanCO = Director("John", "McTiernan", 1951)
val highPlainsDrifterCO = Film("High Plains Drifter", 1973, 7.7, eastwoodCO)
val predatorCO = Film("Predator", 1987, 7.9, mcTiernanCO)
Director.older(eastwoodCO, mcTiernanCO).name
Film.highestRating(highPlainsDrifterCO, predatorCO).name
Film.oldestDirectorAtTheTime(highPlainsDrifterCO, predatorCO).name

val eastwood = new Director("Clint", "Eastwood", 1930)
val mcTiernan = new Director("John", "McTiernan", 1951)
val nolan = new Director("Christopher", "Nolan", 1970)
val someBody = new Director("Just", "Some Body", 1990)

val memento = new Film("Memento", 2000, 8.5, nolan)
val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
val inception = new Film("Inception", 2010, 8.8, nolan)

val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
val invictus = new Film("Invictus", 2009, 7.4, eastwood)

val predator = new Film("Predator", 1987, 7.9, mcTiernan)
val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

eastwood.yearOfBirth
dieHard.director.name
invictus.isDirectedBy(nolan) // should be false

val newMovie = highPlainsDrifter.copy(name = "L'homme des hautes plaines")
newMovie.name
newMovie.director.name
newMovie.imdbRating
// returns Film("L'homme des hautes plaines", 1973, 7.7, /* etc */)
inception.copy().copy()






