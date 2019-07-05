var lengths,lit,pageNum;
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
    var jobName = json.jobName,pn = json.pn;
    if (typeof (pn)=="undefined") {
        pn=1;
    }
    $("#search_input").val(jobName)
    $.ajax({
        type:"post",
        async:false,
        data:{
            jobName:jobName,
            jobCity:json.jobCity==''?"全国":json.jobCity,
            jobSalary:json.jobSalary==''?null:json.jobSalary,
            jobPro:json.jobPro==''?null:json.jobPro,
            jobYear:json.jobYear==''?null:json.jobYear,
            exceptionEducation:json.exceptionEducation==''?null:json.exceptionEducation
        },
        url:"/personal/findRec",
        success:function (data) {
            if (data.state == 10){
                lengths = data.list.length;
                lit = data.list;
                pageNum = lengths%5==0?lengths/5:lengths/5+1;
                var list,n,htm,i;
                list = data.list,htm = "";

                for(n = 5*(pn-1),i=0;n<list.length&&i<5;n++,i++){
                    htm+="<li class=\"odd clearfix\">\n" +
                        "                    <div class=\"hot_pos_l\">\n" +
                        "                        <div class=\"mb10\">\n" +
                        "                            <a href=\"/company/findJob?createTime="+list[n].recruitmentId+"\" title=\""+list[n].jobName+"\" >"+list[n].jobName+"</a>\n" +
                        "                            &nbsp;\n" +
                        "                            <span class=\"c9\">["+list[n].jobCity+"]</span>\n" +
                        "                        </div>\n" +
                        "                        <span><em class=\"c7\">月薪：</em>"+list[n].jobSalary+"</span>\n" +
                        "                        <span><em class=\"c7\">经验：</em> "+list[n].jobYear+"</span>\n" +
                        "                        <span><em class=\"c7\">最低学历： </em>"+list[n].exceptionEducation+"</span>\n" +
                        "                        <br/>\n" +
                        "                        <span><em class=\"c7\">职位诱惑：</em>"+list[n].jobTempt+"</span>\n" +
                        "                        <br/>\n" +
                        "                        <span>"+list[n].createTime+"发布</span>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"hot_pos_r\">\n" +
                        "                        <div class=\"apply\">\n" +
                        "                            <a href=\"/company/findJob?createTime="+list[n].recruitmentId+"\" target=\"_blank\">投个简历</a>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"mb10\"><a href=\"/company/findJob?createTime="+list[n].recruitmentId+"\" title=\"紫色医疗\" target=\"_blank\">"+list[n].company.companyName+"</a></div>\n" +
                        "                        <br/>\n" +
                        "                        <span><em class=\"c7\">规模： </em>"+list[n].company.companySize+"</span>\n" +
                        "                        <ul class=\"companyTags reset\">\n" +
                        "                            <li>五险一金</li>\n" +
                        "                            <li>股票期权</li>\n" +
                        "                            <li>年度旅游</li>\n" +
                        "                        </ul>\n" +
                        "                    </div>\n" +
                        "                </li>"
                }
                $(".hot_pos").html(htm)
                $("#gjInput").val(json.jobYear),$("#xlInput").val(json.exceptionEducation),$("#yxInput").val(json.jobSalary),
                    $("#gxInput").val(json.jobPro),$("#cityInput").val(json.jobCity)
            }
        }
    });

    console.log(lengths)

    /***************************
     * 分页
     */
    $('.Pagination').pager({
        currPage: pn,
        pageNOName: "pn",
        form: "searchForm",
        pageCount: lengths%5==0?lengths/5:lengths/5+1,
        pageSize: 5
    });

    $(".workplace dd").not('.more').children('a').click(function () {
        editForm("cityInput", $(this).html());
    });

    $("#box_expectCity dd span").click(function () {

        editForm("cityInput", $(this).html());
    });

    $('#options dd div').click(function () {
        var firstName = $(this).parents('dl').children('dt').text();
        var fn = $.trim(firstName);
        if (fn == "月薪范围") {
            editForm("yxInput", $(this).html());
        }
        else if (fn == "工作经验") {
            editForm("gjInput", $(this).html());
        }
        else if (fn == "最低学历") {
            editForm("xlInput", $(this).html());
        }
        else if (fn == "工作性质") {
            editForm("gxInput", $(this).html());
        }
        else if (fn == "发布时间") {
            editForm("stInput", $(this).html());
        }
    });

    $('#selected ul').delegate('li span.select_remove', 'click', function (event) {
        var firstName = $(this).parent('li').find('strong').text();
        var fn = $.trim(firstName);
        if (fn == "月薪范围")
            editForm("yxInput","");
        else if (fn == "工作经验")
            editForm("gjInput","" );
        else if (fn == "最低学历")
            editForm("xlInput", "");
        else if (fn == "工作性质")
            editForm("gxInput", "");
        else if (fn == "发布时间")
            editForm("stInput", "");
    });

    /* search结果飘绿	*/
    (function ($) {
        var searchVal = $('#search_input').val();
        var reg = /\s/g;
        searchVal = searchVal.replace(reg, "").split("");

        var resultL = '';
        var resultR = '';
        $('.hot_pos li').each(function () {
            resultL = $('.hot_pos_l a', this).text().split("");
            $.each(resultL, function (i, v) {
                if ($.inArray(v.toLowerCase(), searchVal) != -1 || $.inArray(v.toUpperCase(), searchVal) != -1) {
                    resultL[i] = '<span>' + v + '</span>';
                }
            });
            $('.hot_pos_l a', this).html(resultL.join(''));

            resultR = $('.hot_pos_r .mb10 a', this).text().split("");
            $.each(resultR, function (i, v) {
                if ($.inArray(v.toLowerCase(), searchVal) != -1 || $.inArray(v.toUpperCase(), searchVal) != -1) {
                    resultR[i] = '<span>' + v + '</span>';
                }
            });
            $('.hot_pos_r .mb10 a', this).html(resultR.join(''));
        });

    })(jQuery);

    //didi tip
    if ($.cookie('didiTip') != 1 && false) {
        $('#tip_didi').show();
    }
    $('#tip_didi a').click(function () {
        $(this).parent().remove();
        $.cookie('didiTip', 1, {expires: 30, path: '/'});
    });
});

function editForm(inputId, inputValue) {
    $("#" + inputId).attr("value",inputValue);
    var keyword = $.trim($('#search_input').val());
    var reg = /[`~!@\$%\^\&\*\(\)_<>\?:"\{\},\\\/;'\[\]]/ig;
    var re = /#/g;
    var r = /\./g;
    var kw = keyword.replace(reg, " ");

    if (kw == '') {
        $('#searchForm').attr('action', 'toList').submit();
    } else {
        kw = kw.replace(re, '井');
        kw = kw.replace(r, '。');
        $('#searchForm').attr('action', 'toList').submit();
    }
    //$("#searchForm").submit();
}