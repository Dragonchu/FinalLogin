function login(){
    let username = document.getElementById("inputUsername").value;
    let password = document.getElementById("inputPassword").value;
    let user={
        "username":username,
        "password":password,
        "tel":"nothing"
    };

   let x=new XMLHttpRequest();
    x.onreadystatechange=function (){
        if(x.readyState==4){
            if(x.status==200){
                if(x.responseText==="success"){
                    window.location.href="success.jsp";
                }else{
                    document.getElementById("show").innerHTML=x.responseText;
                }
            }
        }
    }
    x.open("POST","login",false);
    x.send(JSON.stringify(user));
}

function sendMessage() {
    let phone = document.getElementById("inputUsername").value;
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
                    window.location.href="success.jsp";
                }else{
                    document.getElementById("show").innerHTML=toCheckCode.responseText;
                }
            }
        }
    }
    toCheckCode.open("POST","checkCode",true);
    toCheckCode.send(JSON.stringify(code));
}
