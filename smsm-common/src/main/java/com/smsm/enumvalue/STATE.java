package com.smsm.enumvalue;

public class STATE {

    /**
     * 用户存在
     */
    public static final Integer USER_EXIT = 1;

    /**
     * 用户不存在
     */
    public static final Integer USER_NOT_EXIT = 0;

    /**
     * 密码错误
     */
    public static final Integer PWD_ERROR = 2;

    /**
     * 数据库异常
     */
    public static final Integer SQL_EXCEPTION = 3;

    /**
     * 数据库查询成功
     */
    public static final Integer SQL_SUCCESS = 4;

    /**
     * 成功标志
     */
    public static final Integer SUCCESS = 10;

    /**
     * sql失败标志
     */
    public static final Integer SQL_FAILURE = 20;

    /**
     * 失败标志
     */
    public static final Integer FAILURE  = 11;

    /**
     * 无数据
     */
    public static final Integer NO_DATA  = 12;
}
