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

  @Test
  def testInvalidBecauseOfRow() {
    // Given
    val file = "src/test/resources/duplication_in_row.csv"

    // When
    val result = SudokuAnalyzer.analyze(file)

    // Then
    assertFalse(result)
  }

  @Test
  def testInvalidBecauseOfColumn() {
    // Given
    val file = "src/test/resources/duplication_in_column.csv"

    // When
    val result = SudokuAnalyzer.analyze(file)

    // Then
    assertFalse(result)
  }

  @Test
  def testInvalidBecauseOfBox() {
    // Given
    val file = "src/test/resources/duplication_in_box.csv"

    // When
    val result = SudokuAnalyzer.analyze(file)

    // Then
    assertFalse(result)
  }

  @Test
  def testThatEmptyIsValid() {
    // Given
    val file = "src/test/resources/empty.csv"

    // When
    val result = SudokuAnalyzer.analyze(file)

    // Then
    assertTrue(result)
  }
  
  @Test
  def testThatCorrectlySolvedIsValid() {
    // Given
    val file = "src/test/resources/solved.csv"

    // When
    val result = SudokuAnalyzer.analyze(file)

    // Then
    assertTrue(result)
  }
}
