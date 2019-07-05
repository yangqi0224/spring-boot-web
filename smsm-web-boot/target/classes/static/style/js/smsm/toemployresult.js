function GetRequest() {
    var url = decodeURI(location.search); //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}
$(function () {
    var json = GetRequest();
    var state = json.state;
    $.ajax({
        url:"/personal/getToEmployResult",
        success:function (data) {
            if (data.state == 10){
                $(".delivery_tabs .reset li").removeClass("current")
                var list,n,htm = '';
                list = data.list;
                for (n = 0;n<list.length;n++) {
                    if (state == 0 || list[n].state == state) {
                        htm += "<li>\n" +
                            "                                    <div class=\"d_item\">\n" +
                            "                                        <h2 title=\"" + list[n].recruitment.jobName + "\">\n" +
                            "                                            <a target=\"_blank\" href=\"/company/findJob?createTime=" + list[n].recruitment.recruitmentId + "\">\n" +
                            "                                                <em>" + list[n].recruitment.jobName + "</em>\n" +
                            "                                                <span>（" + list[n].recruitment.jobSalary + "）</span>\n" +
                            "                                                <!--  -->\n" +
                            "                                            </a>\n" +
                            "                                        </h2>\n" +
                            "                                        <div class=\"clear\"></div>\n" +
                            "                                        <a title=\"公司名称\" class=\"d_jobname\" target=\"_blank\"\n" +
                            "                                           href=\"http://www.lagou.com/c/25927.html\">\n" +
                            "                                            公司名称 <span>[上海]</span>\n" +
                            "                                        </a>\n" +
                            "                                        <span class=\"d_time\">" + list[n].toEmployDate + "</span>\n" +
                            "                                        <div class=\"clear\"></div>\n" +
                            "                                        <div class=\"d_resume\">\n" +
                            "                                            使用简历：\n" +
                            "                                            <span>\n" +
                            "\t                                    \t                                        \t\t在线简历\n" +
                            "                                        \t\t                                    \t</span>\n" +
                            "                                        </div>\n";
                        if (list[n].state == 0) {
                            htm += "<a class=\"btn_showprogress\" href=\"javascript:;\">\n" +
                                "                                            投递成功\n" +
                                "                                            <i></i></a>\n" +
                                "                                    </div>\n" +
                                "                                    <div class=\"progress_status\tdn\">\n" +
                                "                                        <ul class=\"status_steps\">\n" +
                                "                                            <li class=\"status_done status_1\">1</li>\n" +
                                "                                            <li class=\"status_line status_line_done\"><span></span></li>\n" +
                                "                                            <li class=\"status_done\"><span>2</span></li>\n" +
                                "                                        </ul>\n" +
                                "                                        <ul class=\"status_text\">\n" +
                                "                                            <li>投递成功</li>\n" +
                                "                                            <li class=\"status_text_2\">简历被查看</li>\n" +
                                "                                        </ul>\n" +
                                "                                        <ul class=\"status_list\">\n" +
                                "                                            <li class=\"bottom\">\n" +
                                "                                                <div class=\"list_time\"><em></em>" + list[n].toEmployDate + "</div>\n" +
                                "                                                <div class=\"list_body\">\n" +
                                "                                                    " + list[n].recruitment.hrName + "已成功接收你的简历\n" +
                                "                                                </div>\n" +
                                "                                            </li>\n" +
                                "                                        </ul>\n" +
                                "                                        <a class=\"btn_closeprogress\" href=\"javascript:;\"></a>\n" +
                                "                                    </div>\n" +
                                "                                </li>";
                        } else if (list[n].state == 1) {
                            htm += "<a class=\"btn_showprogress\" href=\"javascript:;\">\n" +
                                "                                            通知面试\n" +
                                "                                            <i></i></a>\n" +
                                "                                    </div>\n" +
                                "                                    <div class=\"progress_status\tdn\">\n" +
                                "                                        <ul class=\"status_steps\">\n" +
                                "                                            <li class=\"status_done status_1\">1</li>\n" +
                                "                                            <li class=\"status_line status_line_done\"><span></span></li>\n" +
                                "                                            <li class=\"status_done\"><span>2</span></li>\n" +
                                "                                            <li class=\"status_line status_line_done\"><span></span></li>\n" +
                                "                                            <li class=\"status_done\"><span>3</span></li>\n" +
                                "                                            <li class=\"status_line status_line_done \"><span></span></li>\n" +
                                "                                            <li class=\"status_done\"><span>4</span></li>\n" +
                                "                                        </ul>\n" +
                                "                                        <ul class=\"status_text\">\n" +
                                "                                            <li>投递成功</li>\n" +
                                "                                            <li class=\"status_text_2\">简历被查看</li>\n" +
                                "                                            <li class=\"status_text_3\">通过初步筛选</li>\n" +
                                "                                            <li style=\"margin-left: 75px;*margin-left: 60px;\" class=\"status_text_4\">\n" +
                                "                                                面试\n" +
                                "                                            </li>\n" +
                                "                                        </ul>\n" +
                                "                                        <ul class=\"status_list\">\n" +
                                "                                            <li class=\"top\">\n" +
                                "                                                <div class=\"list_time\"><em></em>" + list[n].updateTime + "</div>\n" +
                                "                                                <div class=\"list_body\">\n" +
                                "                                                    简历被" + list[n].recruitment.hrName + "标记通知面试\n" +
                                "                                                    <div>您的简历已收到，经过领导和相关部门的审核，认为您非常适合我们的职位，请您于一周内到：" + list[n].recruitment.jobAddr + "，参加面试。</div>\n" +
                                "                                                </div>\n" +
                                "                                            </li>\n" +
                                "                                            <li class=\"top\">\n" +
                                "                                                <div class=\"list_time\"><em></em>" + list[n].updateTime + "</div>\n" +
                                "                                                <div class=\"list_body\">\n" +
                                "                                                    " + list[n].recruitment.hrName + "已查看你的简历\n" +
                                "                                                </div>\n" +
                                "                                            </li>" +
                                "                                            <li class=\"bottom\">\n" +
                                "                                                <div class=\"list_time\"><em></em>" + list[n].toEmployDate + "</div>\n" +
                                "                                                <div class=\"list_body\">\n" +
                                "                                                    " + list[n].recruitment.hrName + "已成功接收你的简历\n" +
                                "                                                </div>\n" +
                                "                                            </li>\n" +
                                "                                        </ul>\n" +
                                "                                        <a class=\"btn_closeprogress\" href=\"javascript:;\"></a>\n" +
                                "                                    </div>\n" +
                                "                                </li>";
                        } else {
                            htm += "<a class=\"btn_showprogress\" href=\"javascript:;\">\n" +
                                "                                            不合适\n" +
                                "                                            <i></i></a>\n" +
                                "                                    </div>\n" +
                                "                                    <div class=\"progress_status\tdn\">\n" +
                                "                                        <ul class=\"status_steps\">\n" +
                                "                                            <li class=\"status_done status_1\">1</li>\n" +
                                "                                            <li class=\"status_line status_line_done\"><span></span></li>\n" +
                                "                                            <li class=\"status_done\"><span>2</span></li>\n" +
                                "                                            <li class=\"status_line status_line_done\"><span></span></li>\n" +
                                "                                            <li class=\"status_done\"><span>3</span></li>\n" +
                                "                                            <li class=\"status_line status_line_done\"><span></span></li>\n" +
                                "                                            <li class=\"status_done\"><span>4</span></li>\n" +
                                "                                        </ul>\n" +
                                "                                        <ul class=\"status_text\">\n" +
                                "                                            <li>投递成功</li>\n" +
                                "                                            <li class=\"status_text_2\">简历被查看</li>\n" +
                                "                                            <li class=\"status_text_3\">通过初步筛选</li>\n" +
                                "                                            <li style=\"margin-left: 75px;*margin-left: 60px;\" class=\"status_text_4\">\n" +
                                "                                                不合适\n" +
                                "                                            </li>\n" +
                                "                                        </ul>\n" +
                                "                                        <ul class=\"status_list\">\n" +
                                "                                            <li class=\"top\">\n" +
                                "                                                <div class=\"list_time\"><em></em>" + list[n].updateTime + "</div>\n" +
                                "                                                <div class=\"list_body\">\n" +
                                "                                                    简历被" + list[n].recruitment.hrName + "标记为不合适\n" +
                                "                                                    <div>您的简历已收到，但目前您的工作经历与该职位不是很匹配，因此很抱歉地通知您无法进入面试。</div>\n" +
                                "                                                </div>\n" +
                                "                                            </li>\n" +
                                "                                            <li class=\"top\">\n" +
                                "                                                <div class=\"list_time\"><em></em>" + list[n].updateTime + "</div>\n" +
                                "                                                <div class=\"list_body\">\n" +
                                "                                                    " + list[n].recruitment.hrName + "已查看你的简历\n" +
                                "                                                </div>\n" +
                                "                                            </li>" +
                                "                                            <li class=\"bottom\">\n" +
                                "                                                <div class=\"list_time\"><em></em>" + list[n].toEmployDate + "</div>\n" +
                                "                                                <div class=\"list_body\">\n" +
                                "                                                    " + list[n].recruitment.hrName + "已成功接收你的简历\n" +
                                "                                                </div>\n" +
                                "                                            </li>\n" +
                                "                                        </ul>\n" +
                                "                                        <a class=\"btn_closeprogress\" href=\"javascript:;\"></a>\n" +
                                "                                    </div>\n" +
                                "                                </li>";
                        }
                    }
                }
                if (state == 0){
                    $("#send").parent().addClass("current")
                } else if (state == 1){
                    $("#view").parent().addClass("current")
                } else {
                    $("#improper").parent().addClass("current")
                }
                $(".my_delivery").html(htm)
            }
        }
    })
})