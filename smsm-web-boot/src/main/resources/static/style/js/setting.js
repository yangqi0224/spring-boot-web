$(function () {
    //修改密码页面
    $('#oldpassword').focus(function () {
        $('#updatePwd_beError').hide();
    })
    $('#updatePswForm').validate({
        /*onkeyup: false,
        focusCleanup:false,*/
        rules: {
            oldpassword: {
                required: true
            },
            newpassword: {
                required: true,
                rangelength: [6, 16]
            },
            comfirmpassword: {
                required: true,
                equalTo: "#newpassword"
            }
        },
        messages: {
            oldpassword: {
                required: "请输入当前密码"
            },
            newpassword: {
                required: "请输入新密码",
                rangelength: "请输入6-16位密码，字母区分大小写"
            },
            comfirmpassword: {
                required: "请再次输入新密码",
                equalTo: "两次输入的密码不一致，请重新输入"
            }
        },
        submitHandler: function (form) {
            var oldpassword = $('#oldpassword').val();
            var newpassword = $('#newpassword').val();
            var comfirmpassword = $('#comfirmpassword').val();
            $.ajax({
                url: '/login/updatePwd',
                type: 'POST',
                data: {
                    newPwd: newpassword,
                    oldPwd: oldpassword
                },
                dataType: 'json'
            }).done(function (result) {
                if (result.state == 10) {
                    $.colorbox({inline: true, href: $("#updatePassword"), title: "修改密码成功"});
                    setCountdown(4, 'updatePassword h4 span', "/htmls/login.html");	//调用倒计时
                } else {
                    console.log(result.msg);
                    $('#updatePwd_beError').html(result.msg).show();
                }
            });
        }
    });
});

function setCountdown(time, id, url) {
    var count = setTimeout(function () {
        $("#" + id).html(time);
        setCountdown(time - 1, id, url)
    }, 1000);
    if (time == 0) {
        clearTimeout(count);
        top.location.href = url;
    }
}