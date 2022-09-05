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

      //Check 결과
      let idCheck=false;
      let pwCheck=false;
      let pwEqualCheck=false;
      let nameCheck=false;
      let emailCheck=false;
      let phoneCheck=false;


    joinButton.addEventListener("click", function(){
        if(idCheck && pwCheck && pwEqualCheck) {
            alert("회원 가입이 완료되었습니다.");
            joinForm.submit();
        } else alert("필수 사항을 입력해 주세요.");
    });

    id.addEventListener("blur", function(){
        let d = id.value;
        console.log(d.length);

        idCheck = false;

        if(d.length < 2){
            document.getElementById("id_div").style.display="block";
        } else {
            document.getElementById("id_div").style.display="none";
            idCheck = true;
        }
    });

    pw.addEventListener("blur", function() {
        let p = pw.value;

        pwCheck = false;
        
        if(p.length < 6) {
            document.getElementById("pw_div").style.display="block";
        } else {
            document.getElementById("pw_div").style.display="none";
            pwCheck = true;
        }
    });

    pw2.addEventListener("blur", function() {
        let p2 = pw2.value;
        let p = pw.value;   

        pwEqualCheck = false;
        
        if(p2 != p) {
            document.getElementById("pw2_div").style.display="block";
        } else {
            document.getElementById("pw2_div").style.display="none";
            pwEqualCheck = true;
        }
    });

    names.addEventListener("blur", function(){
        let n = names.value;

        nameCheck = false;

        if(n.length < 1) {
            document.getElementById("names_div").style.display="block";
        } else {
            document.getElementById("names_div").style.display="none";
            nameCheck = true;
        }
    })

    email.addEventListener("blur", function(){
        let e = email.value;

        emailCheck = false;

        if(e.length < 1) {
            document.getElementById("email_div").style.display="block";
        } else {
            document.getElementById("email_div").style.display="none";
            emailCheck = true;
        }
    })

    phone.addEventListener("blur", function(){
        let ph = phone.value;

        phoneCheck = false;

        if(ph.length < 1) {
            document.getElementById("phone_div").style.display="block";
        } else {
            document.getElementById("phone_div").style.display="none";
            phoneCheck = true;
        }
    })

}