package org.nexio
import java.io.File
import scala.io.Source
import scala.collection.mutable.ListBuffer
import scala.collection.immutable.Set
import org.nexio.exceptions.InvalidFormatException

/**
  * Scala object responsible for analyzing the data in the csv file.
  * Validates if the numbers repeats in rows, columns and boxes.
  */
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

  /**
    * Translates path to file into operable table.
    *
    * @param file path to the file.
    * @return content of a file in 2d structure.
    */
  private def loadFile(file: String): ListBuffer[Array[Int]] = {
    val rows = ListBuffer[Array[Int]]()
    for (line <- Source.fromFile(file).getLines) {
      val row =
        line
          .split(",")
          .map(x => if (x.strip().length() > 0) Integer.parseInt(x) else 0)
      // println(row.mkString(","))
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

  /**
    * Extracts box from full sudoku table
    *
    * @param rows full sudoku table
    * @param i horizontal index of box (between 0 and 2)
    * @param j vertical index of box (between 0 and 2)
    * @return array with all elements from a box
    */
  private def getBox(
      rows: ListBuffer[Array[Int]],
      i: Int,
      j: Int
  ): IndexedSeq[Int] =
    for (k <- 0 to 8) yield rows(i * 3 + k / 3)(j * 3 + k % 3)

  /**
    * Validate box from a given sudoku table
    *
    * @param rows full sudoku table
    * @param i horizontal index of box (between 0 and 2)
    * @param j vertical index of box (between 0 and 2)
    * @return True if the box has no repetitions and False in opposite.
    */
  private def validateBox(
      rows: ListBuffer[Array[Int]],
      i: Int,
      j: Int
  ): Boolean = {
    val box: Array[Int] = getBox(rows, i, j).toArray
    return validateArray(box)
  }

  /**
    * Checks if in array are any repetitions of non-zero numbers
    *
    * @param row array with numbers
    * @return true if there are no repetitions or false when opposite
    */
  private def validateArray(row: Array[Int]): Boolean = {
    val filteredRow = row.filter(p => p > 0)
    return Set(filteredRow: _*).size == filteredRow.length
  }

}
