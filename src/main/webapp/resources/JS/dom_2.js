
// 1. 선택자
const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");
const year = document.getElementById("year");
const month = document.getElementById("month");
const date = document.getElementById("date");



console.log(d1.value);
alert(d1.getAttribute("value"));
/////////////////////////////////////////////////
d2.type = "button";
d2.setAttribute("type", "button");
////////////////////////////////////////////////
let count = window.prompt("숫자를 입력하세요");
let t = "";

for(let i = 0; i < count; i++) {
    t = t + '<input type = "text">';
}

d3.innerHTML = t;
//////////////////////////////////////////////
for(i = 1900; i < 2022; i++){
   year.innerHTML += '<option>' + i + '</option>'
}

for(i = 1; i < 13; i++){
    month.innerHTML += '<option>' + i + '</option>'
}

for(i = 1; i < 32; i++){
    date.innerHTML += '<option>' + i + '</option>'
}
//////////////////////////////////////////////////////////
let r = prompt("ROW의 갯수 입력"); //3
let c = prompt("columt의 갯수 입력"); //2

