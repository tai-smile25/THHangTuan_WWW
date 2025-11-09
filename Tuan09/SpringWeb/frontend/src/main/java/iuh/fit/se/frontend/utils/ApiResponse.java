package iuh.fit.se.frontend.utils;

import java.util.Map;

public class ApiResponse {
    private Object data;
    private Map<String, String> errors;
    private String message;

    public ApiResponse() {}

    public ApiResponse(Object data, Map<String, String> errors, String message) {
        this.data = data;
        this.errors = errors;
        this.message = message;
    }

    public static ApiResponse success(Object data) {
        return new ApiResponse(data, null, "Success");
    }

    public static ApiResponse error(String message) {
        return new ApiResponse(null, null, message);
    }

    public static ApiResponse error(Map<String, String> errors) {
        return new ApiResponse(null, errors, "Validation failed");
    }

    public static ApiResponse noContent() {
        return new ApiResponse(null, null, "No content");
    }

    // Getters and Setters
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}