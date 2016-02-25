package apps.arusoft.com.followme.models;

/**
 * Created by jose.ramos on 25/02/2016.
 */
public class Response<T> {
    private boolean error;
    private T data;
    private String message;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
