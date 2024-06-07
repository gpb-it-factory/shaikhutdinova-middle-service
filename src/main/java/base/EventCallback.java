package base;

public interface EventCallback<T> {
    void onNewEvent(T event);

    void onError(Throwable throwable);
}
