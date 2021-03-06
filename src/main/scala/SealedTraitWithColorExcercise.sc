
sealed trait Color {
  // We decided to store RGB values as doubles between 0.0 and 1.0.
  //
  // It is always good practice to define abstract members as `defs`
  // so we can implement them with `defs`, `vals` or `vars`.
  def red: Double
  def green: Double
  def blue: Double

  // We decided to define a "light" colour as one with
  // an average RGB of more than 0.5:
  def isLight = (red + green + blue) / 3.0 > 0.5
  def isDark = !isLight

}

final case object Red extends Color {
  // Here we have implemented the RGB values as `vals`
  // because the values cannot change:
  val red = 1.0
  val green = 0.0
  val blue = 0.0
}
final case object Yellow extends Color {
  // Here we have implemented the RGB values as `vals`
  // because the values cannot change:
  val red = 1.0
  val green = 1.0
  val blue = 0.0
}

final case object Pink extends Color {
  // Here we have implemented the RGB values as `vals`
  // because the values cannot change:
  val red = 1.0
  val green = 0.0
  val blue = 1.0
}

// The arguments to the case class here generate `val` declarations
// that implement the RGB methods from `Color`:
final case class CustomColor(
                              red: Double,
                              green: Double,
                              blue: Double) extends Color

sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
  def color: Color
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

final case class Square(val size: Int, color: Color ) extends Rectangular {
  val width = size
  val height = size
}

final case class Circle(radius: Double, color: Color) extends Shape {
  val sides = 1
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius
}

final case class Rectangle(width: Int, height: Int, color: Color) extends Rectangular

object Draw {
  def apply(shape:Shape) : String = shape match {
    case Circle(radius, color) =>
      s"A ${Draw(color)} circle of radius ${radius}cm"
    case Square(size, color) =>
      s"A ${Draw(color)} square of size ${size}cm"
    case Rectangle(width, height, color) =>
      s"A ${Draw(color)} rectangle of width ${width}cm and height ${height}cm"

  }

  def apply(color:Color): String = color match {
    // We deal with each of the predefined Colors with special cases:
    case Red => "red"
    case Yellow => "yellow"
    case Pink => "pink"
    case color => if(color.isLight) "light" else "dark"

  }

}



Draw(Circle(5, Pink))

//Up to page 65