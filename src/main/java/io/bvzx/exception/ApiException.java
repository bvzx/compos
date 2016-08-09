package io.bvzx.exception;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年07月01日 14:08
 * @Copyright (c) 2015-2020 by caitu99
 */
public class ApiException  extends RuntimeException  {

    private static final long serialVersionUID = -3643000772356018114L;

    private int code;
    private String messge;
    private Object data;


    public ApiException(int code, String messge) {
        super(messge);
        this.code = code;
        this.messge = messge;
        this.data=null;
    }

    public ApiException(int code, String messge, Object data) {
        super(messge);
        this.code = code;
        this.messge = messge;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessge() {
        return messge;
    }

    public void setMessge(String messge) {
        this.messge = messge;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
