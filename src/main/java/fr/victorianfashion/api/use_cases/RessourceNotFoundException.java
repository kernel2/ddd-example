package fr.victorianfashion.api.use_cases;

public class RessourceNotFoundException extends Exception {
  public RessourceNotFoundException() {
    super();
  }

  public RessourceNotFoundException(String message) {
    super(message);
  }
}
