$(function () {

    // 这里是鼠标划过登录框显示的部分
    $("#login-box").hover(function () {
        $(this).addClass('to-big stop on-backimg');
        $("form").show();
    })
    
    // 请求登录接口部分
    $("form button").click(function () {
        $.ajax({
            url: "http://localhost:8080/music02/Login",
            type: "post",
            data: $("form").serialize(),
            dataType: "json",
            success: function (result) {
                if (result.msg == "登录成功") {
                    location.href = "main.html";
                    //设置保持登录一天
                    setCookie("loginName", $("#username").val(), 1)
                } else {
                    $("#msg").addClass("in");
                    $('#msg p').html(result.msg)
                }
            }
        })
    })

    // 警告框的部分
    $("#msg button").click(function(){
        $("#msg").toggleClass("in")
    })

})
