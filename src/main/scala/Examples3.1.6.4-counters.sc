//counter class 3.1.6.4 A Simple Counter
class Counter (val count: Int) {
  def dec: Counter = dec()
  def inc: Counter = inc()
  def dec(amount: Int = 1): Counter = new Counter(count - amount)
  def inc(amount: Int = 1): Counter = new Counter(count + amount)

  def adjust(adder: Adder) = new Counter(adder(count))
}

class Adder(amount: Int) {
  def apply(in: Int) = in + amount
}


//Because we created 2 versions of inc - one with no params (which
//calls the one with params (overloading) we can call the function
//with or without params
//new Counter(10).inc.dec(2).count
new Counter(10).adjust(new Adder(2)).count

val add3 = new Adder(3)
add3(2)

class Timestamp(val seconds: Long)
object Timestamp {
  def apply(hours: Int, minutes: Int, seconds: Int): Timestamp =
    new Timestamp(hours*60*60 + minutes*60 + seconds)
}
Timestamp(1, 1, 1).seconds
// res: Long = 3661

Timestamp

object SingletonObj {
  def sayHi(): String = {
    "hi"
  }
}

SingletonObj.sayHi().toUpperCase();







