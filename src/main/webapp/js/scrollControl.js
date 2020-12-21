var index = 0;
function showON(){
    var dots = document.querySelector(".buttons").getElementsByTagName("span");
    for(var i = 0, len = dots.length; i < len; i++){
        dots[i].className = "";
    }
    dots[index].className = "on";
}
function next_pic(){
    var wrap = document.querySelector(".wrap");
    var newLeft = (parseInt(wrap.style.left)-238)%(-1190);
    wrap.style.left = newLeft+"px";
    index++;
    if(index > 4){
        index = 0;
    }
   showON();
}
function prev_pic(){
    var wrap = document.querySelector(".wrap");
    var newLeft = parseInt(wrap.style.left)+238;
    if(newLeft===238){
        newLeft=-952;
    }
    wrap.style.left = newLeft+"px";
    index--;
    if(index < 0){
        index = 4;
    }
    showON();
}

function autoPlay(){
    var timer = null;
    timer = setInterval(function (){
        next_pic();
    },1000);
    var container = document.querySelector(".container");
    container.onmouseover = function () {
        clearInterval(timer);
    }
    container.onmouseout = function () {
        timer = setInterval(function (){
            next_pic();
        },1000);
    }

}

window.onload=function () {
    autoPlay();
}

