$(function () {

    $(".menu_box a").each(function () {
        $(this).attr("href","/toPersonal/toList?jobName="+this.innerHTML)
    })


    $.ajax({
        type:"post",
        url:"/personal/findHostJob",
        success:function (data) {
            var h="",n,i;
            var c="hot_pos_l";
            for (i = data.list,n = 0;n<i.length;n++)
            {
                if (n%2 == 0) {
                    h+="<li class=\"old clearfix\">\n" +
                        "                        <div class=\"hot_pos_l\">\n" +
                        "                            <div class=\"mb10\">\n" +
                        "                                <a href=\"/company/findJob?createTime="+i[n].recruitmentId+"\" >"+i[n].jobName+"</a>\n" +
                        "                                &nbsp;\n" +
                        "                                <span class=\"c9\">["+i[n].jobCity+"]</span>\n" +
                        "                            </div>\n" +
                        "                            <span><em class=\"c7\">月薪： </em>"+i[n].jobSalary+"</span>\n" +
                        "                            <span><em class=\"c7\">经验：</em>"+i[n].jobYear+"</span>\n" +
                        "                            <span><em class=\"c7\">最低学历： </em>"+i[n].exceptionEducation+"</span>\n" +
                        "                            <br/>\n" +
                        "                            <span><em class=\"c7\">职位诱惑：</em>"+i[n].jobTempt+"</span>\n" +
                        "                            <br/>\n" +
                        "                        </div>"
                }else {
                    h+="                        <div class=\"hot_pos_r\">\n" +
                        "                            <div class=\"mb10\">\n" +
                        "                                <a href=\"/company/findJob?createTime="+i[n].recruitmentId+"\">"+i[n].jobName+"</a>\n" +
                        "                                &nbsp;\n" +
                        "                                <span class=\"c9\">["+i[n].jobCity+"]</span>\n" +
                        "                            </div>\n" +
                        "                            <span><em class=\"c7\">月薪： </em>"+i[n].jobSalary+"</span>\n" +
                        "                            <span><em class=\"c7\">经验：</em>"+i[n].jobYear+"</span>\n" +
                        "                            <span><em class=\"c7\">最低学历： </em>"+i[n].exceptionEducation+"</span>\n" +
                        "                            <br/>\n" +
                        "                            <span><em class=\"c7\">职位诱惑：</em>"+i[n].jobTempt+"</span>\n" +
                        "                            <br/>\n" +
                        "                    </li>"
                }

            }
            $(".hot_pos").html(h)

        }
    });

    $.ajax({
        type:"post",
        url:"/personal/findRec",
        success:function (data) {
            var h="",n,i;
            var c="hot_pos_l";
            for (i = data.list,n = 0;n<i.length;n++)
            {
                if (n%2 == 0) {
                    h+="<li class=\"old clearfix\">\n" +
                        "                        <div class=\"hot_pos_l\">\n" +
                        "                            <div class=\"mb10\">\n" +
                        "                                <a href=\"/company/findJob?createTime="+i[n].recruitmentId+"\" >"+i[n].jobName+"</a>\n" +
                        "                                &nbsp;\n" +
                        "                                <span class=\"c9\">["+i[n].jobCity+"]</span>\n" +
                        "                            </div>\n" +
                        "                            <span><em class=\"c7\">月薪： </em>"+i[n].jobSalary+"</span>\n" +
                        "                            <span><em class=\"c7\">经验：</em>"+i[n].jobYear+"</span>\n" +
                        "                            <span><em class=\"c7\">最低学历： </em>"+i[n].exceptionEducation+"</span>\n" +
                        "                            <br/>\n" +
                        "                            <span><em class=\"c7\">职位诱惑：</em>"+i[n].jobTempt+"</span>\n" +
                        "                            <br/>\n" +
                        "                        </div>"
                }else {
                    h+="                        <div class=\"hot_pos_r\">\n" +
                        "                            <div class=\"mb10\">\n" +
                        "                                <a href=\"/company/findJob?createTime="+i[n].recruitmentId+"\">"+i[n].jobName+"</a>\n" +
                        "                                &nbsp;\n" +
                        "                                <span class=\"c9\">["+i[n].jobCity+"]</span>\n" +
                        "                            </div>\n" +
                        "                            <span><em class=\"c7\">月薪： </em>"+i[n].jobSalary+"</span>\n" +
                        "                            <span><em class=\"c7\">经验：</em>"+i[n].jobYear+"</span>\n" +
                        "                            <span><em class=\"c7\">最低学历： </em>"+i[n].exceptionEducation+"</span>\n" +
                        "                            <br/>\n" +
                        "                            <span><em class=\"c7\">职位诱惑：</em>"+i[n].jobTempt+"</span>\n" +
                        "                            <br/>\n" +
                        "                    </li>"
                }

            }
            $(".hot_posHotPosition").html(h)

        }
    });
})