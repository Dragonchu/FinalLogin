function hide(){
    let nowType = document.getElementById("inputPassword");
    let eye = document.getElementById("eye")
    if(nowType.type==="password"){
        nowType.type="text";
    }else {
        nowType.type="password";
    }
}