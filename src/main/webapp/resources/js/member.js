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

function joinCheck() {
    const joinForm = document.getElementById("joinForm");
    const joinButton = document.getElementById("joinButton");
    const id = document.getElementById("id");
    const pw = document.getElementById("pw");
    const pw2 = document.getElementById("pw2");
    const names = document.getElementById("names");
    const email = document.getElementById("email");
    const phone = document.getElementById("phone");

    id.addEventListener("blur", function(){
        let d = id.value;
        console.log(d.length);

        if(d.length < 2){
            document.getElementById("id_div").style.display="block";
        } else document.getElementById("id_div").style.display="none";
    });

    pw.addEventListener("blur", function() {
        let p = pw.value;
        
        if(p.value.length < 6) {
            document.getElementById("pw_div").style.display="block";
        } else document.getElementById("pw_div").style.display="none";
    });

    pw2.addEventListener("blur", function() {
        let p2 = pw2.value;
        let p = pw.value;
        
        if(p2 != p) {
            document.getElementById("pw2_div").style.display="block";
        } else document.getElementById("pw2_div").style.display="none";
    });

    names.addEventListener("blur", function(){
        let n = names.value;

        if(n.length < 1) {
            document.getElementById("names_div").style.display="block";
            
        } else document.getElementById("names_div").style.display="none";
    })

    email.addEventListener("blur", function(){
        let e = email.value;

        if(e.length < 1) {
            document.getElementById("email_div").style.display="block";
        } else document.getElementById("email_div").style.display="none";
    })

    phone.addEventListener("blur", function(){
        let ph = phone.value;

        if(ph.length < 1) {
            document.getElementById("phone_div").style.display="block";
        } else document.getElementById("phone_div").style.display="none";
    })

}