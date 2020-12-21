function alter(alterBtn) {
    var tr = alterBtn.parentNode.parentNode;
    var inputs = tr.querySelectorAll("input");
    inputs[0].removeAttribute("readonly");
    inputs[1].removeAttribute("readonly");
    inputs[2].removeAttribute("readonly");

    var username = inputs[0].value;
    var password = inputs[1].value;
    var tel = inputs[2].value;

    let userWithPhone={
        "username":username,
        "password":password,
        "tel":tel
    };

    let x=new XMLHttpRequest();
    x.open("POST","deleteInfo",false);
    x.send(JSON.stringify(userWithPhone));
}

function deleteInfo(deleteBtn) {
    var tr = deleteBtn.parentNode.parentNode;
    var inputs = tr.querySelectorAll("input");
    var username = inputs[0].value;
    var password = inputs[1].value;
    var tel = inputs[2].value;

    let userWithPhone={
        "username":username,
        "password":password,
        "tel":tel
    };

    let x=new XMLHttpRequest();
    x.open("POST","deleteInfo",false);
    x.send(JSON.stringify(userWithPhone));

   //删除改行
    var table = tr.parentNode;
    table.removeChild(tr);

}

function submitToDB(submitBtn) {
    var tr = submitBtn.parentNode.parentNode;
    var inputs = tr.querySelectorAll("input");
    inputs[0].setAttribute("readonly","readonly");
    inputs[1].setAttribute("readonly","readonly");
    inputs[2].setAttribute("readonly","readonly");

    var username = inputs[0].value;
    var password = inputs[1].value;
    var tel = inputs[2].value;

    let userWithPhone={
        "username":username,
        "password":password,
        "tel":tel
    };

    let x=new XMLHttpRequest();
    x.open("POST","addNewInfo",false);
    x.send(JSON.stringify(userWithPhone));
}

function addInfo(addBtn) {
    var tr = addBtn.parentNode.parentNode;
    var table = tr.parentNode;
    var length = table.rows.length;
    var newRow = table.insertRow(length-1);
    var one = newRow.insertCell(0);
    var two = newRow.insertCell(1);
    var three = newRow.insertCell(2);
    one.innerHTML="<input placeholder='请输入账号'>";
    two.innerHTML="<input placeholder='请输入密码'>"
    three.innerHTML="<input placeholder='请输入手机号码'>"
    var colAlter = newRow.insertCell(3);
    colAlter.innerHTML="<button id=\"alter\" onclick=\"alter(this)\">修改</button>";
    var colDelete = newRow.insertCell(4);
    colDelete.innerHTML="<button id=\"delete\" onclick=\"deleteInfo(this)\">删除</button>";
    var colSubmit = newRow.insertCell(5);
    colSubmit.innerHTML="<button onclick=\"submitToDB(this)\">确认</button>";
}