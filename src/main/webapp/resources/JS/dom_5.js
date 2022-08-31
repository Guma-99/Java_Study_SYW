const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");
const d4 = document.getElementById("d4");
const d5 = document.getElementById("d5");

d2.addEventListener("focus", function(){
    console.log("입력 준비");
})

d2.addEventListener("blur", function(){
    console.log("blur 발생");
})

// d1입력하고 나왔을 때(blur) 글자의 길이가 3글자 이하라면 d1 강제로 입력 대기 상태
d1.addEventListener("blur", function(){
    let v = d1.value;
    if(v.lenght < 4){
        d1.focus();
    }

    // console.log("세글자 이하");
    // d1.addEventListener("focus", function(){
    //     console.log("test");
    // })
});

d3.addEventListener("change", function(){
    console.log("chaange Event 발생");
});

d5.addEventListener("change", function(){
    console.log("SELECT가 변경");

})

d4.addEventListener("keyup", function(){
    console.log("key up");
})