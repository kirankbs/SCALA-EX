var mapRow: Map[String, List[String]] = Map()
mapRow += "AA" -> Nil
mapRow += "BB" -> Nil
mapRow += "CC" -> Nil

val cd = List(("AA","one"),("BB","two"),("AA","three"),("CC","four"))

updateMap(cd, mapRow)


// First approach
def updateMap(row: List[(String, String)], mapR: Map[String, List[String]]) = {
  def loop(row: List[(String, String)], mapR: Map[String, List[String]]): Map[String, List[String]] = row match {
    case Nil => mapR
    case x::xs => loop(xs, mapR.updated(x._1, (mapR.get(x._1).get ++ List(x._2))))
  }
  loop(row, mapR)
}

//second approach
val result = cd.foldLeft(mapRow)((acc, h) => { acc.updated(h._1, (acc.get(h._1).get ++ List(h._2))) })