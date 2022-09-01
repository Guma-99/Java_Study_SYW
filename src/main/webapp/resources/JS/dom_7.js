// dom_7.js

const remove1 = document.getElementById("remove1");
const remove2 = document.getElementById("remove2");

const d1 = document.getElementById("d1"); // div#d1
const d2 = document.getElementById("d2"); // div#d2
const d2_1 = document.getElementById("d2_1") // h1#d2_1

remove1.addEventListener("click", function(){
    // 부모 태그 삭제
    d1.remove();
});

// remove2.addEventListener("click", function(){
//     // 자식 태그 하나 삭제
//     d2.removeChild(d2_1);
// });

remove2.addEventListener("click", function(){
    // 자식 태그 다수 삭제
    d2.removeChild(d2_1);
    d2.removeChild(d2_2);
    d2.removeChild(d2_3);
    d2.removeChild(d2_4);
});
