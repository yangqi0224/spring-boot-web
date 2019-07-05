package com.smsm.util;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:ChaoZhang
 * Date:2019/4/23
 * Time:16:42
 */
public class Upload {

    /**
     * 图片上传请求
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public static Map<String, Object> uploadImg(HttpServletRequest request,
                                                HttpServletResponse response) throws Exception {
        String userID = request.getParameter("userID");


        // 转型为MultipartHttpRequest(重点的所在)这个就是上面ajax中提到如果直接访问此接口而不加"/"，此转型就会报错
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        //MultipartFile file = multipartRequest.getFiles("errPic");//获取文件集合  对应  jquery $("#imageFile").get(0).files
        // 获得第1张图片（根据前台的name名称得到上传的文件）
        MultipartFile file = multipartRequest.getFile("headPic"); //对应  jquery $("#imageFile").get(0).files[index]
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != file && !file.isEmpty()) {
            try {
                map = uploadFile(request, file);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * 图片上传
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static Map<String, Object> uploadFile(HttpServletRequest request, MultipartFile file)
            throws IOException {


        String realPath = request.getServletContext().getRealPath("/");  //服务器路径
        String filePath = "D:\\Users\\demo\\Workspaces\\idea\\springbootsmsm\\smsm-web-boot\\src\\main\\resources\\static\\style\\images\\upload";    //项目路径
        long maxFileSize = (Integer.valueOf(15)) * 1024 * 1024;     //上传图片小于3M
        String suffix = file.getOriginalFilename().substring(
                file.getOriginalFilename().lastIndexOf("."));
        long fileSize = file.getSize();
        Map<String, Object> map = new HashMap<String, Object>();
        if (suffix.equals(".png") || suffix.equals(".jpg")) {
            if (fileSize < maxFileSize) {
                String fileName = file.getOriginalFilename();
                map.put("fileName",fileName);
                fileName = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
                File tempFile = new File(filePath, fileName);

                //复制一份tempFile文件去服务器对应地址
                File tempFile1 = new File(realPath, fileName);
                InputStream input = null ;
                OutputStream output  = null ;
                try {

                    //项目地址
                    if (!tempFile.getParentFile().exists()) {
                        tempFile.getParentFile().mkdirs();//如果是多级文件使用mkdirs();如果就一层级的话，可以使用mkdir()
                    }
                    if (!tempFile.exists()) {
                        tempFile.createNewFile();
                    }
                    file.transferTo(tempFile);

                } catch (Exception e) {
                    e.printStackTrace();
                }


                //将图片全路径改为相对路径存入数据库
                int index = filePath.lastIndexOf("web")+3;
                String str = '.' + filePath.substring(index) + tempFile.getName();
                map.put("data", str.replaceAll("\\\\", "/"));

            } else {
                map.put("data", "Image too big");
            }

        } else {
            map.put("data", "Image format error");
        }
        return map;
    }
}