// 播放器的动画
function playMusic(url) {
    $(".play-box").fadeIn();
    $("#play2").toggleClass("play-music")
    $("#play1").toggleClass("music-go")
    $("#music_info").attr("src", url)[0].play();
}

var eventTester = function(e) {
    $("#music_info")[0].addEventListener(e, function() {
        if (e == "pause" || e == "ended") {
            $("#play2").removeClass("play-music");
            $("#play1").removeClass("music-go");
            $(".play-box").fadeOut();
        } else if (e == "play") {
            $("#play2").addClass("play-music");
            $("#play1").addClass("music-go");
            $(".play-box").fadeIn();
        }
    }, false)
}
eventTester("pause");
eventTester("play")
eventTester("ended")