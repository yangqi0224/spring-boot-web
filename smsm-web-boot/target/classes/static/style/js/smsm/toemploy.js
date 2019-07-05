$(function () {

    var jobdesc = $("#jobDesc").val();
    $("#jj").html(jobdesc);

    $("#toEmploy").click(function () {

        var recruitmentId = $("#recruitmentId").val()

        $.ajax({
            type:"post",
            url:"/personal/toEmploy",
            data:{
                recruitmentId:recruitmentId
            },
            success:function (data) {
                if (data.state == 10){
                    alert("投递成功")
                }else {
                    alert(data.msg)
                }
            }
        })
    })
})