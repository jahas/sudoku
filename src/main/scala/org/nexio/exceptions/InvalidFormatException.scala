package org.nexio.exceptions

/**
  * Exception thrown when passed csv file has wrong dimensions.
  *
  * @param message Custom message parameter. Should be used to input additional debug information.
  */
class InvalidFormatException(message: String)
    extends Exception(message) {}
