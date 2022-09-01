// dom_7.js

const remove1 = document.getElementById("remove1");
const remove2 = document.getElementById("remove2");

const d1 = document.getElementById("d1"); // div#d1
const d2 = document.getElementById("d2"); // div#d2

remove1.addEventListener("click", function(){
    // 부모 태그 삭제
    d1.remove();
});

// remove2.addEventListener("click", function(){
//     // 자식 태그 하나 삭제
//     d2.removeChild(d2_1);
// });

remove2.addEventListener("click", function(){
    const ch = document.getElementsByClassName("ch");
    const ar = [];

    // for(데이터타입 변수명 : 컬렉션변수명)
    for(let i = 0; ch < ch.length; i++) {
        ar.push(ch[i].id);
    }

    for(i of ar) {
        let d = document.getElementById(i);
        d2.removeChild(d);
    }
    // 자식 태그 다수 삭제


    // for(let i = 1; i < 5; i++) {

    //     const d2_1 = document.getElementById("d2_" + i) // h1#d2_1
    //     d2.removeChild(d2_1);
    // }
});
