package org.nexio
import java.io.File
import scala.io.Source
import scala.collection.mutable.ListBuffer

object SudokuAnalyzer {
  def analyze(file: File): Boolean = {
    println("File to analyze = %s".format(file))
    val rows = ListBuffer[Array[Int]]()
    for (line <- Source.fromFile(file.getAbsolutePath()).getLines) {
      println(line)
      rows += line.split(",").map(x => if (x.length() > 0) Integer.parseInt(x) else 0)
    }
    println(rows)
    true
  }
}
