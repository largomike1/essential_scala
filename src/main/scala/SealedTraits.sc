 sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
}

 trait Rectangular extends Shape {
   def width: Int
   def height: Int
   val sides = 4
   //Make sure use use def when defining a value based on a calculation.
   //Otherwise the value doesn't get calculated.
   //The alternative is to use lazy val (see someValue below)
   override def perimeter: Double = ((width * 2) + (height * 2)).toDouble
   override def area: Double = (width * height).toDouble
   lazy val someValue: Double = width * 2;
 }

 case class Square(val size: Int ) extends Rectangular {
   val width = size
   val height = size
 }

case class Circle(radius: Double) extends Shape {
  val sides = 1
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius
}

 case class Rectangle(width: Int, height: Int) extends Rectangular

object Draw {
  def apply(shape:Shape) : String = shape match {
    case Rectangle(width, height) =>
      s"A rectangle of width ${width}cm and height ${height}cm"
    case Square(size) =>
      s"A square of size ${size}cm"
    // Because the case statement below is commented out
    //and the Shape is a sealed trait, all classes that are based
    //on the Shape trait must be included in the pattern match.
    case Circle(radius) =>
      s"A circle of radius ${radius}cm"
  }

}



Draw(Circle(5))