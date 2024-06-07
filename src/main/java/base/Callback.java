package base;

public interface Callback {

    void onSuccess();

    void onError(Throwable e);
}
