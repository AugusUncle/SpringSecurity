package com.cb.domain;


import com.cb.utils.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 操作消息提醒
 *
 * @author ruoyi
 */
public class Result<T>
{
    private static final long serialVersionUID = 1L;

    /** 状态码 */
    @Schema(name = "code", description = "状态码")
    public int code ;

    /** 返回内容 */
    @Schema(name = "msg", description = "返回消息")
    public  String msg;

    /** 数据对象 */
    @Schema(name = "data", description = "数据对象")
    public T data ;

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public Result()
    {
        this(200, "操作成功",null);
    }


    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     * @param data 数据对象
     */
    public Result(int code, String msg, T data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public Result( T data)
    {
        this(200, "操作成功", data);

    }


    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static Result success(int code)
    {
        return new Result<>(HttpStatus.SUCCESS);
    }

    public static Result success(int code,String msg, Object data)
    {
        return new Result<>(HttpStatus.SUCCESS, msg, data);
    }

    public static Result success(int code,String msg)
    {
        return new Result<>(HttpStatus.SUCCESS, msg ,null);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static Result error()
    {
        return Result.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static Result error(String msg)
    {
        return Result.error(msg, null);
    }

    public static Result error(int code,String msg)
    {
        return new Result<>(code, msg, null);
    }


    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static Result error(String msg, Object data)
    {
        return new Result(HttpStatus.ERROR, msg, data);
    }


}
