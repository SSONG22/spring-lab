package songi.lab.spring.handlerMethodArgResolver.model;

public class ApiResult<T> {
    private boolean success;
    private T data;

    public ApiResult(T data) {
        this.success = true;
        this.data = data;
    }

}
