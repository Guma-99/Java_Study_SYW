// Dom_4.js
const ch = document.getElementsByClassName("ch");
const cb = document.getElementsByClassName("cb")

for(let i = 0; i < ch.length; i++) {
    ch[i].addEventListener("click", function(){
        alert(ch[i].value);
    });
}

for(let i = 0; i < cb.length; i++) {
    cb[i].addEventListener("click", function(){
        alert(cb[i].value);
        
    });

}

// checked