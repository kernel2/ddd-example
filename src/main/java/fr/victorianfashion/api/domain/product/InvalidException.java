package fr.victorianfashion.api.domain.product;

public class InvalidException extends Exception {
  public InvalidException() {
    super();
  }

  public InvalidException(String message) {
    super(message);
  }
}
