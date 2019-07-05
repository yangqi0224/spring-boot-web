$(function(){

    var userType = "personal";
    var flag = false;
    $('.register_radio li input').click(function (e) {
        userType = $(this).val();
        $(this).parent('li').addClass('current').append('<em></em>').siblings().removeClass('current').find('em').remove();
    });
    /*$("li").click(function () {
        var userType = $(this).find("input:first").value;
    })*/

    $("form :input").blur(function () {

        var $parent = $(this).parent();

        if($(this).is("#email")){
            flag = true;
            $("#beError").hide();
            var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
            var userPhone = $("#email").val();
            if(!reg.test(userPhone)){
                flag = false;
                var ermsg = "请输入正确的手机号";

                $("#beError").text(ermsg).show();
            }
        }

        if($(this).is("#password")){
            flag = true;
            $("#beErrorPwd").hide();
            var reg = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z]).*$/

            var userPwd = $("#password").val();

            if(!reg.test(userPwd)){
                flag = false;
                var ermsg = "密码至少6位，包括至少1个大写字母，1个小写字母，1个数字";
                $("#beErrorPwd").text(ermsg).show();
            }
        }

        if($(this).is("#password2")){
            flag = true;
            $("#beErrorPwd2").hide();
            var userPwd = $("#password").val();
            var pwd = $("#password2").val();

            if(userPwd != pwd){
                flag = false;
                var ermsg = "密码不一致！";
                $("#beErrorPwd2").text(ermsg).show();
            }
        }
    });/*.keyup(function(){
        //triggerHandler 防止事件执行完后，浏览器自动为标签获得焦点
        //$(this).triggerHandler("blur");
    }).focus(function(){
        //$(this).triggerHandler("blur");
    });*/

    //$("form :input").blur = $("form :input").change;

    //点击重置按钮时，通过trigger()来触发文本框的失去焦点事件
    $("#submitLogin").click(function(){
        //trigger 事件执行完后，浏览器会为submit按钮获得焦点
        //var userType=$("#userType").val();

        var userPhone = $("#email").val();
        var userPwd = $("#password").val();
        var userPwd2 = $("#password2").val();
        var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
        if(!reg.test(userPhone)){
            flag = false;
            var ermsg = "请输入正确的手机号";
            $("#beError").text(ermsg).show();
        }
        console.log(userPhone);
        if(userPhone==""){
            $("#beError").text("请输入正确的手机号！").show();

            flag = false;
            //alert(flag);

        }
        if (userPwd==""){
            $("#beErrorPwd").text("请输入密码！").show();
            flag = false;
        }
        if (userPwd2==""){
            $("#beErrorPwd2").text("请确认密码！").show();
            flag = false;
        }
        $("form .required:input").trigger("blur");
        if(flag){

            $.ajax({
                type:"POST",
                url:"/login/register",
                data:{
                    userPhone:userPhone,
                    userPwd:userPwd,
                    userType:userType
                },
                success:function (result) {
                    console.log(result);
                    if(result.status == 10){
                        window.location.href = "/toCompany/toIndex";
                    }else {
                        $('#beError').text(result.msg).show();
                    }
                }
            })
        }
       return false;
    });
    //return false;
    
})
