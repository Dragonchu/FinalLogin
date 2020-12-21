function checkUsername() {
    let username = document.getElementById("name").value;
    let password = "nothing";
    let user={
        "username":username,
        "password":password
    };

    let x=new XMLHttpRequest();
    x.onreadystatechange=function (){
        if(x.readyState==4){
            if(x.status==200){
                if(x.responseText==="success"){
                    document.getElementById("inputPhone").style.display="block";
                    document.getElementById("checkResult").innerHTML="该用户存在";
                }else{
                    document.getElementById("checkResult").innerHTML="该用户不存在";
                    document.getElementById("inputPhone").style.display="none";
                }
            }
        }
    }
    x.open("POST","checkName",false);
    x.send(JSON.stringify(user));
}

function checkPhone(){
    let username = document.getElementById("name").value;
    let password = document.getElementById("tel").value;
    let user={
        "username":username,
        "password":password
    };

    let x=new XMLHttpRequest();
    x.onreadystatechange=function (){
        if(x.readyState==4){
            if(x.status==200){
                if(x.responseText==="success"){
                    document.getElementById("getCode").style.display="block";
                    document.getElementById("checkPhone").innerHTML="手机号码正确";
                }else{
                    document.getElementById("checkPhone").innerHTML=x.responseText;
                    document.getElementById("getCode").style.display="none";
                }
            }
        }
    }
    x.open("POST","checkNamePhone",false);
    x.send(JSON.stringify(user));
}

function sendMessage() {
    let phone = document.getElementById("tel").value;
    let value = {
        "phone":phone
    }
    let smsXML =new XMLHttpRequest();
    smsXML.open("POST","sendSMS",true);
    smsXML.send(JSON.stringify(value));
}

function checkCode(){
    let inputCode = document.getElementById("inputPassword").value;
    let code = {
        "code":inputCode
    }
    let toCheckCode = new XMLHttpRequest();
    toCheckCode.onreadystatechange=function (){
        if(toCheckCode.readyState==4){
            if(toCheckCode.status==200){
                if(toCheckCode.responseText==="success"){
                    document.getElementById("show").innerHTML="验证码正确";
                    document.getElementById("verify").style.display="block";
                }else{
                    document.getElementById("show").innerHTML=toCheckCode.responseText;
                    document.getElementById("verify").style.display="none";
                }
            }
        }
    }
    toCheckCode.open("POST","checkCode",true);
    toCheckCode.send(JSON.stringify(code));
}

function updatePassWord(){
    let username = document.getElementById("name").value;
    let password = document.getElementById("newPassWord").value;
    let tel = document.getElementById("tel").value;
    let user={
        "username":username,
        "password":password,
        "tel":tel
    };

    let x=new XMLHttpRequest();
    x.onreadystatechange=function (){
        if(x.readyState==4){
            if(x.status==200){
                if(x.responseText==="success"){
                    document.getElementById("resOfUpdate").innerHTML=x.responseText;
                }else{
                    document.getElementById("resOfUpdate").innerHTML=x.responseText;
                }
            }
        }
    }
    x.open("POST","updatePassWord",false);
    x.send(JSON.stringify(user));
}
