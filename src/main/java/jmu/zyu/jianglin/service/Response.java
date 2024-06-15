package jmu.zyu.jianglin.service;

public class Response<T> {

    private T data;
    private boolean success;
    private String errMsg;

    public static <K> Response<K> newSuccess(K data){
        Response<K> response = new Response<>();
        response.setData(data);
        response.setErrMsg("no err.");
        response.setSuccess(true);

        return response;
    }

    public static <K> Response<K> newFail(String errMsg) {
        Response<K> response = new Response<>();
        response.setData(null); // Here we can set null or any default value appropriate for your case
        response.setErrMsg(errMsg);
        response.setSuccess(false);

        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
