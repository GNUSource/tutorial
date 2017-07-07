package spring.tutorial.web.base.vo;

import java.io.Serializable;

public class MessageVO implements Serializable {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
