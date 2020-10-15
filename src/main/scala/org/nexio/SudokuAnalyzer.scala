package org.nexio
import java.io.File
import scala.io.Source

object SudokuAnalyzer {
  def analyze(file: File): Boolean = {
    println("File to analyze = %s".format(file))
    val rows = List[List[Int]]()
    for (line <- Source.fromFile(file.getAbsolutePath()).getLines) {
      println(line)
      rows += List(line.split(","))
    }
    true
  }
}
