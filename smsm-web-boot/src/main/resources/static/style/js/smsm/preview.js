//获取导航栏的参数
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

    var resumeId = json.resumeId;
    $.ajax({
        type:"post",
        url:"/personal/viewResume",
        data:{
            resumeId:resumeId
        },
        success:function (data) {
            if (data.state == 10){
                var resume,proExp,htm = "",workHis,n;
                resume = data.resume,proExp = data.resume.projectExps,workHis = resume.workHistories;

                htm+="<div class=\"preview_header\">\n" +
                    "        <h1 title=\""+resume.resumeName+"\">"+resume.resumeName+"</h1>\n" +
                    "    </div><!--end .preview_header-->\n" +
                    "\n" +
                    "    <div class=\"preview_content\">\n" +
                    "        <div class=\"profile_box\" id=\"basicInfo\">\n" +
                    "            <h2>基本信息</h2>\n" +
                    "            <div class=\"basicShow\">\n" +
                    "                   <span>"+resume.name+" | \n" +
                    "                    "+resume.sex+" |                     "+resume.education+" |                                       \t\t"+resume.jobExp+"<br>\n" +
                    "            \t\t\t            \t\t\t\t"+resume.major+" | "+resume.education+" · "+resume.university+"<br>\n" +
                    "            \t\t\t            \t\t\t"+resume.phone+" | "+resume.email+"<br>\n" +
                    "            \t\t\t\n" +
                    "            \t\t</span>\n" +
                    "                <div class=\"m_portrait\">\n" +
                    "                    <div></div>\n" +
                    "                    <img width=\"120\" height=\"120\" alt=\"jason\" src=\""+resume.imgName+"\">\n" +
                    "                </div>\n" +
                    "            </div><!--end .basicShow-->\n" +
                    "        </div><!--end #basicInfo-->\n" +
                    "\n" +
                    "        <div class=\"profile_box\" id=\"expectJob\">\n" +
                    "            <h2>期望工作</h2>\n" +
                    "            <div class=\"expectShow\">\n" +
                    "                "+resume.exceptionCity+"，"+resume.exceptionType+"，月薪"+resume.exceptionSalary+"，"+resume.exceptionJob+"\n" +
                    "            </div><!--end .expectShow-->\n" +
                    "        </div><!--end #expectJob-->";

                console.log(workHis)
                for (n = 0; n<workHis.length;n++){

                    if (n==0)
                        htm+="<div class=\"profile_box\" id=\"workExperience\">\n" +
                            "            <h2>工作经历</h2>\n" +
                            "            <div class=\"experienceShow\">\n";

                    htm+="                <ul class=\"wlist clearfix\">\n" +
                        "                    <li class=\"clear\">\n" +
                        "                        <span class=\"c9\">"+workHis[n].startDate+"~"+workHis[n].endDate+"</span>\n" +
                        "                        <div>\n" +
                        "                            <img width=\"56\" height=\"56\" alt=\""+workHis[n].companyName+"\" src=\"../style/images/logo_default.png\">\n" +
                        "                            <h3>"+workHis[n].jobName+" </h3>\n" +
                        "                            <h4>"+workHis[n].companyName+"</h4>\n" +
                        "                        </div>\n" +
                        "                    </li>\n" +
                        "                </ul>\n";

                    if (n==workHis.length-1)
                        htm+="            </div><!--end .experienceShow-->\n" +
                            "        </div><!--end #workExperience-->"
                }

                for (n = 0; n<proExp.length;n++){

                    if (n==0)
                        htm+="<div class=\"profile_box\" id=\"projectExperience\">\n" +
                        "            <h2>项目经验</h2>\n" +
                        "            <div class=\"projectShow\">\n";

                    htm+="                <ul class=\"plist clearfix\">\n" +
                        "                    <li class=\"noborder\">\n" +
                        "                        <div class=\"projectList\">\n" +
                        "                            <div class=\"f16 mb10\">"+proExp[n].projectExpName+"，"+proExp[n].projectExpDuty+"\n" +
                        "                                <span class=\"c9\">\n" +
                        "\t\t            \t\t\t\t\t\t\t\t\t            \t\t\t\t\t\t\t\t（"+proExp[n].startDate+"~"+proExp[n].endDate+"）\n" +
                        "\t\t            \t\t\t\t\t\t\t\t\t            \t\t\t\t\t\t</span>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"dl1\"></div>\n" +
                        "                        </div>\n" +
                        "                    </li>\n" +
                        "                </ul>\n";

                    if (n == proExp.length-1)
                        htm+="            </div><!--end .projectShow-->\n" +
                            "        </div><!--end #projectExperience-->"
                }

                htm+="<div class=\"profile_box\" id=\"educationalBackground\">\n" +
                    "            <h2>教育背景</h2>\n" +
                    "            <div class=\"educationalShow\">\n" +
                    "                <ul class=\"elist clearfix\">\n" +
                    "                    <li class=\"clear\">\n" +
                    "                        <span class=\"c9\">"+resume.startTime+"~"+resume.endTime+"</span>\n" +
                    "                        <div>\n" +
                    "                            <h3>"+resume.university+"</h3>\n" +
                    "                            <h4>"+resume.major+"，"+resume.education+"</h4>\n" +
                    "                        </div>\n" +
                    "                    </li>\n" +
                    "                </ul>\n" +
                    "            </div><!--end .educationalShow-->\n" +
                    "        </div><!--end #educationalBackground-->";

                $("#previewWrapper").html(htm)

            }
        }
    })
})
