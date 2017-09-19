case class Person(firstName: String, lastName: String)

object Stormtrooper {
  def inspect(person: Person): String =
    person match {
      case Person("Luke", "Skywalker") => "Stop, rebel scum!"
      case Person("Han",_) => "Stop, rebel scum!"
      case Person(first,_) => s"Move along, $first "
    }
}

val tom = Person("Tom","Jones")
val luke = Person("Luke","Skywalker")

Stormtrooper.inspect(tom)
Stormtrooper.inspect(luke)
Stormtrooper.inspect(Person("Han","Jones"))

case class Cat (name: String, color: String, food: String) {

}

//here's how I did it
object ChipShop {
  def willServe (cat: Cat) : Boolean = {
    cat.food match {
      case "chips" => true
      case _ => false
    }
  }
}

//here's how the book said to do it
object ChipShop2 {
  def willServe (cat: Cat) : Boolean = {
    cat match {
      case Cat(_,_,"chips") => true
      case Cat(_,_,_) => false
    }
  }
}

ChipShop.willServe(Cat("felix","black","chips"))
ChipShop.willServe(Cat("felix","black","ice cream"))
ChipShop2.willServe(Cat("felix","black","chips"))
ChipShop2.willServe(Cat("felix","black","ice cream"))