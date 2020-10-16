package org.nexio

import org.junit._
import Assert._
import java.io.FileNotFoundException
import org.nexio.exceptions.InvalidFormatException

@Test
class SudokuAnalyzerTest{

  @Test
  def testValid() {
    // Given
    val file = "src/test/resources/valid1.csv"

    // When
    val result = SudokuAnalyzer.analyze(file)

    // Then
    assertTrue(result)
  }

  @Test(expected = classOf[FileNotFoundException])
  def testMissingFileException() {
    // Given
    val file = "path/does/not/exist.csv"

    // When
    val result = SudokuAnalyzer.analyze(file)

    // Then
    assertTrue(result)
  }

  @Test(expected = classOf[InvalidFormatException])
  def testInvalidFormatException() {
    // Given
    val file = "src/test/resources/invalid_number_of_rows.csv"

    // When
    val result = SudokuAnalyzer.analyze(file)

    // Then
    assertTrue(result)
  }
  
  @Test(expected = classOf[InvalidFormatException])
  def testInvalidFormat2Exception() {
    // Given
    val file = "src/test/resources/invalid_row_length.csv"

    // When
    val result = SudokuAnalyzer.analyze(file)

    // Then
    assertTrue(result)
  }
}
