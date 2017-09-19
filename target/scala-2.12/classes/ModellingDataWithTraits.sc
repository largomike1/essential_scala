//Up to page 59

trait Feline {
  def colour: String
  def sound: String
}

trait BigCat extends Feline {
  val sound = "roar"
}

case class Cat (
   colour: String,
   sound: String = "meow",
   favoriteFood: String
) extends Feline

case class Lion (
     colour: String,
   maneSize: Int
) extends BigCat

//Up to page 62 - shaping up with traits