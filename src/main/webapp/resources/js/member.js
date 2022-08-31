// member.js
function loginCheck() {
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
}

function check() {
    const all = document.getElementById("all");
    const cb = document.getElementsByClassName("cb");
    const join = document.getElementById("join");
    const frm = document.getElementById("frm");
    const req = document.getElementsByClassName("req");

    join.addEventListener("click", function() {
        let result = true;
        for(let i = 0; i < req.length; i++) {
            if(!req[i].checked) {
                result = false;
                break;
            }
        }

        if(result) {
            frm.submit();
        } else {
            alert("필수 약관에 동의해야 합니다.")
        }
    })

    all.addEventListener("click", function(){
        for(let i = 0; i < cb.length; i++) {
            cb[i].checked = all.checked;
        }
    });

    for(let i = 0; i < cb.length; i++) {
        cb[i].addEventListener("click", function(){
            let result = true;
            for(let j = 0; j < cb.length; j++) {
                if(!cb[j].checked) {
                    result = false;
                    break;
                }
            }
            all.checked = result;
        });
    }
};