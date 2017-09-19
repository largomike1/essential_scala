case class Counter (count: Int = 0) {
  def dec: Counter = dec()
  def inc: Counter = inc()
  def dec(amount: Int = 1): Counter = new Counter(count - amount)
  def inc(amount: Int = 1): Counter = new Counter(count + amount)


}

Counter(0)
Counter().inc
Counter().inc.dec

case class Person(firstName: String, lastName: String) {
  def name = firstName + " " + lastName
}

object Person {
  def apply (name: String) = {
    val parts = name.split(" ")
    new Person(parts(0), parts(1))
  }
}

Person("joe","walsh").name
Person("Mike Stein").name
