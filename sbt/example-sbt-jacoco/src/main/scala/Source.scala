class Accessor(val x: Int)

case class Source(a: Int) extends T {
  override def foo = super.foo * a * a
  def uncovered = foo

  implicit class InClass(a: Any)
  private def priv = 0
  () =>
    "yippee"
  lazy val xxx = 33
  new AnyRef {
    def foo = 0
  }
}

object Source {
  def uncovered2 = "!!!!".reverse
  implicit class InObject(a: Any)
  new Source(0).priv
}

trait T {
  def uncoveredT = 0
  def foo = 0
  implicit class InTrait(a: Any) {
    def uncoveredInTrait_!! = foo
  }
}

trait U {
  def uncoveredU = 0
  def foo = 0
  def !!! = 0
}

class UU extends U

object Test {
  val source = new Source(0) // not calling the factory Source(0)
  println(source.foo)
  new UU().foo
  new Source.InObject(0) // not calling the factory Source.InObject(0)
  new source.InClass(0) // not calling the factory source.InClass(0)
  new source.InTrait(0) // not calling the factory source.InTrait(0)
  Source

//  source.uncovered
//  source.uncoveredT
//  Source.uncovered2
//  new UU().uncoveredU
  new Accessor(0)
}