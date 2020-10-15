package org.nexio

import scopt.OParser
import java.io.File

/**
  * @author ${user.name}
  */
object App {

  def foo(x: Array[String]) = x.foldLeft("")((a, b) => a + b)

  def main(args: Array[String]) {
    val builder = OParser.builder[CliConfig]
    val cliparser = {
      import builder._
      OParser.sequence(
        programName("Sudoku Analyzer"),
        head("by Adam", "1.0"),
        opt[File]('i', "input")
          .required()
          .valueName("<file>")
          .action((x, c) => c.copy(input = x))
          .text("input is a required file property")
      )
    }
    OParser.parse(cliparser, args, CliConfig()) match {
      case Some(config) => SudokuAnalyzer.analyze(config.input)
      case _ => new Exception("Wrong argument!")
    }
  }

}
