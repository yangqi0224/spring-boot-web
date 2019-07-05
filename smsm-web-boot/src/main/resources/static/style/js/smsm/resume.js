


function changeResume () {
    var resumeName = $("#resumeName").val()
    console.log(resumeName)
    $.ajax({
        type:"POST",
        data:{
            resumeName:resumeName
        },
        url:"/personal/updateResume",
        success:function (data) {//数据回显
            if(data.state==10){
                alert("更新简历成功")
                $("#mainResume").show()
                $("#resumeNameForm").hide()
                $("#dis").html(data.resume.resumeName)
                $("#dis").attr("title",data.resume.resumeName)
                $("#resumeNameForm.nameEdit").value(data.resume.resumeName)
            }else {
                alert(data.msg)
            }
        }
    })
}

function toSwitch () {
    $("#mainResume").hide()
    $("#resumeNameForm").show()
}

$(function () {//渲染页面

    $(window).unbind('beforeunload');
    window.onbeforeunload = null;

    $("#expectJob .btn_profile_cancel").click(function () {

        /*$("#select_expectCity").attr("value",$("#expectCityVal").val())
        $("#expectPosition").attr("value",$("#expectPositionVal").val())
        $("#select_expectSalary").attr("value",$("#expectSalaryVal").val())*/

        if ($(".exceptionJob").val()!=null){
            $(".expectShow").removeClass("dn")
            $("#expectJob .exp_edit").removeClass("dn")
            $(".expectAdd").addClass("dn")

        }
    })

    $("#workExperience .sm_edit").click(function () {
        $("#workExperience .experienceShow .wlist").addClass("dn")
    }),$(".experienceShow .btn_profile_cancel").click(function () {
        $("#workExperience .experienceShow .wlist").removeClass("dn")
    }),$("#workExperience .c_add").click(function () {
        $("#workExperience .experienceShow .wlist").addClass("dn")
    }),$(".experienceForm .btn_profile_cancel").click(function () {
        $("#workExperience .experienceShow .wlist").removeClass("dn")
    })

    /*$("#workExperience .sm_del").click(function () {
        var id = $(this).parent().attr("data-id")
        var flag
        console.log(id)
        $.ajax({
            type:"POST",
            url:"/personal/delWorkHis",
            data:{
                workHistoryId:id
            }
        }).done(function (data) {
            if (data.state == 10){
                alert("删除成功");
                $(this).parent().attr("class","dn");
            } else {
                alert(data.msg)
            }
        })
    })*/

    /*$("#projectExperience .sm_del").click(function () {
        var id = $(this).parent().parent().attr("data-id")
        var flag
        console.log(id)
        $.ajax({
            type:"POST",
            url:"/personal/delProExp",
            data:{
                projectExpId:id
            }
        }).done(function (data) {
            if (data.state == 10){
                $(this).parent().hide()
            } else {
                alert(data.msg)
            }
        })
    })*/

    $("#expectJob .exp_edit").click(function () {

        $(".expectEdit").removeClass("dn")
        $(".expectShow").addClass("dn")
        $(".exp_edit").addClass("dn")

        //$("#type").val(exceptionType)
        console.log($(".exceptionSalary").text())
        $("#select_expectSalary").val($(".exceptionSalary").text()).attr("style","color: rgb(51, 51, 51);")
        $("#expectPosition").attr("value",$(".exceptionJob").text())
        $("#select_expectCity").val($(".exceptionCity").text()).attr("style","color: rgb(51, 51, 51);")
    })

    $("#educationalBackground .c_edit").click(function () {
        $("#educationalBackground .c_edit").addClass("dn")
        $(".educationalShow").addClass("dn")
        $(".educationalEdit").removeClass("dn")

        //$(".schoolName").attr("value",$("#sn").val())
        $("#edu").attr("value",$("#ed").val())
        $("#eduSelect").attr("value",$("#ed").val()).attr("style","color: rgb(51, 51, 51);")
        $(".professionalName").attr("value",$("#mn").val())


    })

    $(".educationalForm .btn_profile_cancel").click(function () {
        console.log("zheshi"+$("#uni").text())
        if($("#uni").text() == undefined){
            $(".educationalAdd").removeClass("dn")
            $(".educationalEdit").addClass("dn")
            $(".educationalShow").addClass("dn")
        }else {

            $(".educationalShow").removeClass("dn")
            $(".educationalEdit").addClass("dn")
            $("#educationalBackground .educationalAdd").addClass("dn")
            $("#educationalBackground .c_edit").removeClass("dn")

        }
    })

    $.ajax({
        type:"POST",
        url:"/personal/getResume",
        success:function (data) {

            if(data.resume.university == null){
                console.log("设置隐藏")
                $(".educationalShow").addClass("dn")
                $(".educationalAdd").removeClass("dn")

            }
            //简历名称
            $("#dis").text(data.resume.resumeName)
            $("#resumeNameForm .nameEdit").attr("value",data.resume.resumeName)

            //个人基本信息
            //展示
            $(".userName").text(data.resume.name==null?"尚未完善":data.resume.name)

            if(data.resume.sex!=null){
                $(".userSex").text(data.resume.sex)
                if (data.resume.sex == '男')
                    $("#nan").attr("class","current")
                else
                    $("#nv").attr("class","current")
            }
            console.log(data.resume.imgName)
            if (data.resume.imgName != null){
                $(".m_portrait img").attr("src",data.resume.imgName)
            }
            $(".education").text(data.resume.education==null?"尚未完善":data.resume.education)
            $(".jobExp").text(data.resume.jobExp==null?"尚未完善":data.resume.jobExp)
            $(".userPhone").text(data.resume.phone==null?"尚未完善":data.resume.phone)
            $(".userEmail").text(data.resume.email==null?"尚未完善":data.resume.email)

            //form表单
            $("#nameVal").attr("value",data.resume.name)
            $("#topDegreeVal").attr("value",data.resume.education)
            $("#workyearVal").attr("value",data.resume.jobExp)
            $("#emailVal").attr("value",data.resume.email)
            $("#telVal").attr("value",data.resume.phone)

            //期望职位
            //展示
            if (data.resume.exceptionJob != null){
                //alert("laile")
                $(".expectAdd").addClass("dn")
                $(".expectEdit").addClass("dn")

                $(".expectShow").removeClass("dn")
                $("#expectJob .exp_edit").removeClass("dn")

                $(".exceptionJob").text(data.resume.exceptionJob)
                $(".exceptionCity").text(data.resume.exceptionCity)
                $(".exceptionType").text(data.resume.exceptionType)
                $(".exceptionSalary").text(data.resume.exceptionSalary)

                //form表单
                $("#expectCityVal").val(data.resume.exceptionCity)
                $("#expectPosition").attr("value",data.resume.exceptionJob)
                $("#type").attr("value",data.resume.exceptionType)
                $("#select_expectSalary").attr("value",data.resume.exceptionSalary)
            } else {
                $(".expectShow").addClass("dn")
            }

            //教育背景信息
            if(data.resume.university != null){
                $("#educationalBackground .c_edit").removeClass("dn")
                $("#sn").attr("value",data.resume.university)
                $("#ed").attr("value",data.resume.education)
                $("#mn").attr("value",data.resume.major)
                $("#st").attr("value",data.resume.startTime)
                $("#et").attr("value",data.resume.endTime)
                $(".schoolName").attr("value",data.resume.university)
                $(".schoolYearEnd").attr("value",data.resume.endTime)
                $(".schoolYearStart").attr("value",data.resume.startTime)
                $("#startTime").val(data.resume.startTime).attr("style","color: rgb(51, 51, 51);")
                $("#endTime").val(data.resume.endTime).attr("style","color: rgb(51, 51, 51);")
                $(".professionalName").val(data.resume.major)

            }

            //工作经历
            if(data.resume.workHistories.length != 0){
                $("#workExperience .experienceAdd").addClass("dn")
                $("#workExperience .c_add").removeClass("dn")
                $("#workExperience .wlist").addClass("clearfix")
                $("#workExperience .experienceShow").removeClass("dn")

                var d,e,f;
                var c = {
                    obj: $("#workExperience")
                };

                for (d = data.resume.workHistories, e = "", f = 0; f < data.resume.workHistories.length; f++)
                    e += 0==f%2? '<li data-id="' + d[f].workHistoryId + '" class="clear">' :
                        '<li data-id="' + d[f].workHistoryId + '">',
                        e += '<i class="sm_del dn"></i><i class="sm_edit dn"></i><span class="c9" data-startYear="'
                            + d[f].beginTimeYear + '" data-endYear="'
                            + d[f].endTimeYear
                            + '" data-startMonth = "'
                            + d[f].beginTimeMonth + '" data-endMonth = "'
                            + d[f].endTimeMonth + '">'
                            + d[f].startDate + "-"
                            + d[f].endDate + "</span>" + "<div>"
                            + '<img src="" width="56" height="56" alt="logo" />' + "<h3>"
                            + d[f].companyName + "</h3>" + "<h4>"
                            + d[f].jobName + "</h4>" + "</div>" + "</li>";
                c.obj.children(".c_add").removeClass("dn"),
                    c.obj.children(".experienceShow").children(".experienceForm").hide(),
                    c.obj.children(".experienceShow").children(".wlist").html(e).parent().removeClass("dn"),
                    c.obj.children(".experienceEdit").addClass("dn"),
                    $("#workExperience .experienceShow .wlist").removeClass("dn")
            }
            if (data.resume.projectExps.length != 0){
                $("#projectExperience .projectAdd").addClass("dn")
                $("#projectExperience .c_add").removeClass("dn")
                $("#projectExperience .wlist").addClass("clearfix")
                $("#projectExperience .experienceShow").removeClass("dn")

                var d,e,f;
                for (d = data.resume.projectExps,f = 0,e = "";f<d.length;f++){
                    e += '<li data-id="' + d[f].projectExpId + '">',
                        e += '<div class="projectList"><i class="sm_del dn"></i><i class="sm_edit dn"></i><div class="f16 mb10" data-proName="' +
                            d[f].projectExpName + '" data-posName="' + d[f].projectExpDuty + '" data-startY="'
                            + d[f].beginTimeYear + '" data-startM="' + d[f].beginTimeMonth + '" data-endY="'
                            + d[f].endTimeYear + '"' + 'data-endM="' + d[f].endTimeMonth + '">'
                            + d[f].projectExpName + '<span class="c9">（' + d[f].startDate + "-"
                            + d[f].endDate + "）</span></div>",
                    "" != d[f].dutyContent && (e += '<div class="dl1">'
                        + d[f].dutyContent + "</div>"), e += "</div></li>";
                }
                $(".projectShow .plist").html(e)
            }


        }
    })

    //教育背景信息更新
    $("#educationalBackground .btn_profile_save").click(function () {
        var university = $(".schoolName").val().trim()
        var major = $(".professionalName").val().trim()
        var startTime = $(".schoolYearStart").val()
        var endTime = $(".schoolYearEnd").val()
        var education = $("#edu").val()

        $.ajax({
            type:"POST",
            data:{
                university:university,
                major:major,
                education:education,
                startTime:startTime,
                endTime:endTime
            },
            url:"/personal/updateResume",
            success:function (data) {
                if(data.state == 10){
                    $("#sn").attr("value",university)
                    $("#ed").attr("value",education)
                    $("#mn").attr("value",major)
                    $("#st").attr("value",startTime)
                    $("#et").attr("value",endTime)

                    $("#uni").text(university)
                    $("#year").text(startTime+"-"+endTime)
                    $("#infoEdu").text(major+","+education)

                    $(".schoolName").attr("value",university)
                    $(".schoolYearEnd").attr("value",endTime)
                    $(".schoolYearStart").attr("value",startTime)
                    $("#startTime").val(startTime)
                    $("#endTime").val(endTime)
                }

                $(".educationalEdit").addClass("dn")
                $(".educationalShow").removeClass("dn")
                $("#educationalBackground .c_edit").removeClass("dn")

                $("#educationalBackground .btn_profile_save").val("保  存")
            }
        })
    })

    //个人信息更新
    $("#updateBaseInfo").click(function () {

        $("#updateBaseInfo").val("保存中...")

        var name = $("#name").val()
        var phone = $("#tel").val()
        var email = $("#email").val()
        var education = $("#topDegree").val()
        var sex = $("#sex .current input").val()
        var jobExp = $("#workyear").val()

        $.ajax({
            type:"POST",
            url:"/personal/updateResume",
            data:{
                name:name,
                phone:phone,
                email:email,
                education:education,
                jobExp:jobExp,
                sex:sex
            },
            success:function (data) {
                if (data.state == 10){
                    //alert("简历更新成功！")
                    $("#updateBaseInfo").val("保存")

                    //数据回显
                    //basicShow
                    $("#nameVal").attr("value",name)
                    $("#topDegreeVal").attr("value",education)
                    $("#workyearVal").attr("value",jobExp)
                    $("#emailVal").attr("value",email)
                    $("#telVal").attr("value",phone)

                    //basicForm
                    $(".userName").text(name)
                    $(".userSex").text(sex)
                    $(".education").text(education)
                    $(".jobExp").text(jobExp)
                    $(".userPhone").text(phone)
                    $(".userEmail").text(email)

                    $("#updateForm").addClass("dn")
                    $("#basicShow").removeClass("dn")
                    $("#basicInfo .c_edit").removeClass("dn")



                }
            }

        })
    })

    //期望工作更新
    $("#exceptButton").click(function () {

        $(".expectShow").removeClass("dn")
        $("#expectJob .c_edit").removeClass("dn")

        var exceptionCity = $("#select_expectCity").val()
        var exceptionType = $("#type .current input").val()
        var exceptionJob = $("#expectPosition").val()
        var exceptionSalary = $("#select_expectSalary").val()

        $.ajax({
            type:"POST",
            url:"/personal/updateResume",
            data:{
                exceptionCity:exceptionCity ,
                exceptionType:exceptionType ,
                exceptionJob:exceptionJob ,
                exceptionSalary:exceptionSalary
            },
            success:function (data) {
                if (data.state == 10){

                    $("#expectJob .expectShow").removeClass("dn")
                    $("#expectJob .expectEdit").addClass("dn")
                    $("#expectJob .exp_edit").removeClass("dn")

                    $(".exceptionJob").text(exceptionJob)
                    $(".exceptionCity").text(exceptionCity)
                    $(".exceptionType").text(exceptionType)
                    $(".exceptionSalary").text(exceptionSalary)

                    $("#typeVal").val(exceptionType)
                    $("#expectSalaryVal").val(exceptionSalary)
                    $("#expectPositionVal").val(exceptionJob)
                    $("#expectCityVal").val(exceptionCity)

                    //$("#type").val(exceptionType)
                    $("#select_expectSalary").val(exceptionSalary)
                    $("#expectPosition").attr("value",exceptionJob)
                    $("#select_expectCity").attr("value",exceptionCity)





                }

                //location.reload(true)
            }
        })
    })
})
