// member.js
const btn = document.getElementById("btn");
const frm = document.getElementById("frm");
const userId = document.getElementById("userId");
const password = document.getElementById("password");
const empty_userId = document.getElementById("userId");
const empty_password = document.getElementById("password");

btn.addEventListener("click", function(){
    let u = userId.value;
    let p = password.value;

    if (u.length == 0) {
        empty_userId;

        return;
    }

    if (p.length == 0) {
        empty_password;

        return;
    }

    frm.submit();
});
