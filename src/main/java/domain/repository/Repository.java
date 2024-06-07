package domain.repository;

import base.Callback;
import base.EventCallback;

// паттерн репозиторий
public interface Repository<T, P, ID> {
    void create(P params, Callback callback);

    void get(ID id, EventCallback<T> eventCallback);

    void update(T newModel, Callback callback);

    void delete(ID id, Callback callback);
}
