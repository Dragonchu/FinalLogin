function login(){
    let username = document.getElementById("inputUsername").value;
    let password = document.getElementById("inputPassword").value;
    let user={
        "username":username,
        "password":password
    };

    let x=new XMLHttpRequest();
    x.onreadystatechange=function (){
        if(x.readyState==4){
            if(x.status==200){
                if(x.responseText==="success"){
                    window.location.href="controlPlat.jsp";
                }else{
                    document.getElementById("show").innerHTML=x.responseText;
                }
            }
        }
    }
    x.open("POST","adminLogin",false);
    x.send(JSON.stringify(user));
}