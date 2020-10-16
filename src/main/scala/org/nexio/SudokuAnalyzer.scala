package org.nexio
import java.io.File
import scala.io.Source
import scala.collection.mutable.ListBuffer
import scala.collection.immutable.Set
import org.nexio.exceptions.InvalidFormatException

object SudokuAnalyzer {
  def analyze(file: String): Boolean = {
    val rows: ListBuffer[Array[Int]] = loadFile(file)
    for (row: Array[Int] <- rows if !validateArray(row)) return false
    for (i: Int <- 0 to 8 if !validateArray(rows.map(_(i)).toArray))
      return false

    for (
      (i: Int, j: Int) <- Range(0, 3).zip(Range(0, 3))
      if !validateBox(rows, i, j)
    )
      return false

    return true

  }

  private def loadFile(file: String): ListBuffer[Array[Int]] = {
    val rows = ListBuffer[Array[Int]]()
    for (line <- Source.fromFile(file).getLines) {
      val row =
        line
          .split(",")
          .map(x => if (x.strip().length() > 0) Integer.parseInt(x) else 0)
      println(row.mkString(","))
      if (row.length != 9) {
        throw new InvalidFormatException(
          "Row has different size than 9, it is %s".format(row.length)
        )
      }
      rows += row
    }
    if (rows.length != 9) {
      throw new InvalidFormatException(
        "There is a wrong number of rows. Should be 9 and is %s".format(
          rows.length
        )
      )
    }
    rows
  }

  private def getBox(
      rows: ListBuffer[Array[Int]],
      i: Int,
      j: Int
  ): IndexedSeq[Int] =
    for (k <- 0 to 8) yield rows(i * 3 + k / 3)(j * 3 + k % 3)

  private def validateBox(
      rows: ListBuffer[Array[Int]],
      i: Int,
      j: Int
  ): Boolean = {
    val box: Array[Int] = getBox(rows, i, j).toArray
    return validateArray(box)
  }

  private def validateArray(row: Array[Int]): Boolean = {
    val filteredRow = row.filter(p => p > 0)
    return Set(filteredRow: _*).size == filteredRow.length
  }

}
