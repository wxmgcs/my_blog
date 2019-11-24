package cn.diyai.my_blog.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Patrick
 * @create 2019-09-12 10:43
 */
@ApiModel("返回值实体")
public class JsonResult<T>  {

    @ApiModelProperty("业务返回值")
    private int code;
    @ApiModelProperty("说明")
    private String msg;
    @ApiModelProperty("数据实体")
    private T data;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
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

    @Override
    public String toString() {
        return "code=" + code + " message=" + msg + " data=" + data;
    }

    public static <T> JsonResult<T> fail() {
        JsonResult<T> ret = new JsonResult<T>();
        ret.setCode(201);
        ret.setMsg("失败");
        return ret;
    }

    public static <T> JsonResult<T> noData() {
        JsonResult<T> ret = new JsonResult<T>();
        ret.setCode(202);
        ret.setMsg("没有数据");
        return ret;
    }

    public static <T> JsonResult<T> fail(T data) {
        JsonResult<T> ret = JsonResult.fail();
        ret.setData(data);
        return ret;
    }

    public static <T> JsonResult<T> failMessage(String msg) {
        JsonResult<T> ret = JsonResult.fail();
        ret.setMsg(msg);
        return ret;
    }
    public static <T> JsonResult<T> successMessage(String msg) {
        JsonResult<T> ret = JsonResult.success();
        ret.setMsg(msg);
        return ret;
    }

    public static <T> JsonResult<T> success() {
        JsonResult<T> ret = new JsonResult<T>();
        ret.setCode(200);
        ret.setMsg("成功");
        return ret;
    }

    public static <T> JsonResult<T> success(T data) {
        JsonResult<T> ret = JsonResult.success();
        ret.setData(data);
        return ret;
    }

    public static <T> JsonResult<T> http404(T data) {
        JsonResult<T> ret = new JsonResult<T>();
        ret.setCode(404);
        ret.setMsg("接口不存在");
        ret.setData(data);
        return ret;
    }

    public static <T> JsonResult<T> http403(T data) {
        JsonResult<T> ret = new JsonResult<T>();
        ret.setCode(403);
        ret.setMsg("拒绝访问");
        ret.setData(data);
        return ret;
    }

}
