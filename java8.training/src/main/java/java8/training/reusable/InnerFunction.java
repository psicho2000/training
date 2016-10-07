package java8.training.reusable;

@FunctionalInterface
public interface InnerFunction {
    public abstract DomainObject calc(DomainObject source);
}