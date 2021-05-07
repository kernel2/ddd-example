package fr.victorianfashion.api.use_cases.sales;

public class RessourceNotFoundException extends Exception {
  public RessourceNotFoundException() {
    super();
  }

  public RessourceNotFoundException(String message) {
    super(message);
  }
}
