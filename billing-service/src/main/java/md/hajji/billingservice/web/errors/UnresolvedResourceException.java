package md.hajji.billingservice.web.errors;

public class UnresolvedResourceException extends RuntimeException {

    public UnresolvedResourceException(String resourceName) {
        super(resourceName + " unresolved resource");
    }
}
