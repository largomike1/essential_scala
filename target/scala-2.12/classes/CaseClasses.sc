//When you create a "case class", a companion object is automatically
//created. And you don't need to prepend arguments with "val"

case class Person(firstName: String, lastName: String) {
  def name = firstName + " " + lastName
}

Person("michael", "Stein").name

Person("michael", "Stein").firstName

val aPerson = new Person("Dave","Jones")
aPerson

val newPerson = aPerson.copy()
aPerson eq aPerson

newPerson eq aPerson

val otherPerson = aPerson.copy(firstName = "louis")

val x = 1
val y = 1

x == y

//case object is used when there are no arguments

case object Nail {
  def length = "2 inches"
  def material = "iron"

}

Nail.length

case class Cat (colour: String, food: String)

Cat("brown","kibbles and bits").colour

//rework of film and director classes using case classes
//Seems that if you want to create a "static" method - not related to a particular
//instance of the class, then you should create an object and put that method on there.
case class Director (firstName: String, lastName:String, yearOfBirth: Int) {
  val name = firstName + " " + lastName
}


object Director {
  def older (director1: Director, director2: Director ): Director =
    if (director1.yearOfBirth < director2.yearOfBirth) director1 else director2
}



case class Film (name:String,
             yearOfRelease:Int,
             imdbRating: Double,
             director: Director) {

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

object Film {
  def highestRating (film1: Film, film2: Film): Film = {
    if (film1.imdbRating > film2.imdbRating) film1 else film2
  }

  def oldestDirectorAtTheTime (film1: Film, film2: Film): Director = {
    if (film1.directorsAge > film2.directorsAge) film1.director else film2.director
  }
}


val eastwoodCO = Director("Clint", "Eastwood", 1930)
val mcTiernanCO = Director("John", "McTiernan", 1951)
val highPlainsDrifterCO = Film("High Plains Drifter", 1973, 7.7, eastwoodCO)
val predatorCO = Film("Predator", 1987, 7.9, mcTiernanCO)
"x" + Director.older(eastwoodCO, mcTiernanCO).name + "y"
//Film.highestRating(highPlainsDrifterCO, predatorCO).name
//Film.oldestDirectorAtTheTime(highPlainsDrifterCO, predatorCO).name

//Pattern matching excercise Get Off My Lawn 3.5.3.2
object Dad {
  def rate (film: Film): Double = {
    film match {
      case Film(_,_,_,Director("Clint","Eastwood",_)) => 10.0
      case Film(_,_,_,Director("John", "McTiernan",_)) => 7.0
      case Film(_,_,_,Director(_,_,_)) => 3.0
    }
  }
}

Dad.rate(highPlainsDrifterCO)
Dad.rate(predatorCO)




