package nl.codefounders.weather.dto;

import java.util.List;

public class CitiesResult {

    private boolean error;
    private String msg;
    private List<String> data;

    public boolean isError() {
        return error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
