$(function () {
    $(".company_center_aside a").click(function () {
        console.log("点击a")
        $(".company_center_aside a").removeClass("current")
        this.addClass("current")
        var name = this.text()
        console.log(name)
        $(".company_center_content h1").text(name)
    })
})