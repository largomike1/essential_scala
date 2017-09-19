trait Shape {
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

case class Rectangle(width: Int, height: Int) extends Rectangular

Rectangle(2,3).perimeter
Rectangle(2,3).area

case class Square(val size: Int ) extends Rectangular {
  val width = size
  val height = size
}

Square(3).width
Square(3).height
Square(3).perimeter
Square(3).someValue
/*
case class Circle(radius: Double) extends Shape {
  val sides = 1
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius
}


//Circle(2).perimeter
*/