package com.drajer.cda.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ValidateErrorHandler implements ErrorHandler {

  public static final Logger logger = LoggerFactory.getLogger(ValidateErrorHandler.class);

  private boolean isException = false;

  public void warning(SAXParseException exception) throws SAXException {
    logMessage(exception);
  }

  public void fatalError(SAXParseException exception) throws SAXException {
    isException = true;
    logMessage(exception);
  }

  public void error(SAXParseException exception) throws SAXException {
    isException = true;
    logger.info("error method called in ValidateErrorHandler");
    logMessage(exception);
  }

  public boolean getIsException() {
    return isException;
  }

  private static void logMessage(SAXParseException exception) {
    logger.warn(
        "Message: Error validating XML Data at Line: {} Column: {} Message: {}",
        exception.getLineNumber(),
        exception.getColumnNumber(),
        exception.getMessage());
  }
}
