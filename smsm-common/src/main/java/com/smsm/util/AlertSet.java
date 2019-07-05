package com.smsm.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * alert提示框封装
 *
 */
public class AlertSet {

    /**
     *
     * @param flag：成功1，失败0标志
     * @param errorMsg：失败时提示的信息
     * @param rightMsg：成功时提示的信息
     * @param location：要去的页面或接口
     * @param response：响应对象
     * @throws IOException：io异常抛出
     */
    public static void alertSet(int flag,String errorMsg,String rightMsg,String location,
                                HttpServletResponse response) throws IOException{
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        //alert提示框
        PrintWriter out = null;
        out=response.getWriter();
        if(flag==1){
            out.print("<script>alert('"+rightMsg+"'); location.replace('"+location+"');</script>");
        }else{
            out.print("<script>alert('"+errorMsg+"');location.replace('"+location+"');</script>");
        }
    }
}
