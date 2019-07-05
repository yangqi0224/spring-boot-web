$(function () {

    var click = $("#submitLogin").click(function () {


        $("#loginForm").validate({
            rules: {
                userPhone: {
                    required: true,
                    rangelength: [11, 12]
                },

                userPwd: {
                    required: true
                }
            },
            messages: {
                userPhone: {
                    required: "请输入手机号！",
                    rangelength: $.validator.format("请输入正确的手机号!")
                },
                userPwd: {
                    required: "请输入密码！"
                }
            },
            submitHandler: function () {
                var userPhone = $("#email").val().trim();
                var userPwd = $("#password").val().trim();

                if ($("#remember").prop("#checked")) {
                    $("#remember").val(1);
                } else {
                    $("#remember").val(null);
                }

                $.ajax({
                    type: "POST",
                    data: {
                        userPhone: userPhone,
                        userPwd: userPwd
                    },
                    url: "/login/login",
                    success: function (result) {
                        if (result.state == 10) {
                            console.log("登录成功")
                        } else {
                            $('#beError').text(result.msg).show();
                        }
                    }
                })
            }
        })


    });

})