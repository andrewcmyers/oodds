/** A handler for events of type T */
interface EventHandler<T> {
    /** Handle an event of type T. */
    void handle(T event);
}
