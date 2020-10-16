package org.nexio

import java.io.File

/**
  * Command Line Input configuration. 
  * Contains all the parameters that can be used with the tool.
  *
  * @param input Parameter of File type, which indicates file to be validated.
  */
case class CliConfig(
    input: File = new File(".")
)
