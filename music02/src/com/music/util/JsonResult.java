package com.music.util;
/*
 * 自定义响应数据结构
 *      本类可提供给 H5/ios/安卓/公众号/小程序 使用
 * 		前端接受此类数据（json object)后，可自行根据业务去实现相关功能
 *
 * 		200：表示成功
 * 		500：表示错误，错误信息在msg字段中
 * 		501：bean验证错误，不管多少个错误都以map形式返回
 * 		502：拦截器拦截到用户token出错
 * 		555：异常抛出信息
 * 		556: 用户qq校验异常
 */
public class JsonResult<T> {
    // 定义jackson对象
   // private static final ObjectMapper MAPPER = new ObjectMapper();
    // 响应业务状态
    private Integer status;
    // 响应消息
    private String msg;
    // 响应中的数据
    private T data;

    // 构造方法
    public JsonResult() {
    }
    public JsonResult(T data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }
    
    public JsonResult(String msg) {
    	this.status = 200;
		this.msg = msg;
	}
	public JsonResult(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    // ok ，空数据
    public static JsonResult ok() {
        return new JsonResult(null);
    }
    // ok ，有数据
    public static JsonResult ok(Object data) {
        return new JsonResult(data);
    }
    // ok ，带消息
    public static JsonResult ok(String msg) {
        return new JsonResult(msg);
    }

    public static JsonResult build(Integer status, String msg, Object data) {
        return new JsonResult(status, msg, data);
    }

    // 出错500， 有信息提示
    public static JsonResult notFoundDataMsg(String msg) {
        return new JsonResult(404, msg, null);
    }

    // 出错500， 有信息提示
    public static JsonResult errorMsg(String msg) {
        return new JsonResult(500, msg, null);
    }
    // 出错501，bean验证错误，不管多少个错误都以map形式返回
    public static JsonResult errorMap(Object data) {
        return new JsonResult(501, "error", data);
    }
    // 出错502，拦截器拦截到用户token出错
    public static JsonResult errorTokenMsg(String msg) {
        return new JsonResult(502, msg, null);
    }
    // 出错555，异常抛出信息
    public static JsonResult errorException(String msg) {
        return new JsonResult(555, msg, null);
    }
    // 出错556，用户qq校验异常
    public static JsonResult errorUserQQ(String msg) {
        return new JsonResult(556, msg, null);
    }
    // 是否正常
    public Boolean isOK() {
        return this.status == 200;
    }
    // 得到状态码
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
