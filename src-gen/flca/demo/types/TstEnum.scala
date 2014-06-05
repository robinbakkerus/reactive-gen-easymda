package flca.demo.types
 
object TstEnum extends Enumeration() {
  type TstEnum = Value
  val AAA = Value("AAA")
  val BBB = Value("BBB")
  val CCC = Value("CCC")
  val DDD = Value("DDD")	
 
  def parse(name: String) = {
    TstEnum .values.filter(_.toString == name).headOption
  }
  def parse(name: Option[String]) = {
    TstEnum .values.filter(_.toString == name.get).headOption
  }
}
