// dom_8.js

const count = document.getElementById("count");
const btn = document.getElementById("btn");
const result = document.getElementById("result");
const c1 = document.getElementsByClassName("c1");
const d1 = document.getElementById("d1");
const d1_1 = document.getElementById("d1_1");
const d1_1_1 = document.getElementById("d1_1_1");
const naver = document.getElementById("naver");

naver.addEventListener("click", function(event){
    alert("Go NAVER");
    event.stopPropagation();
})

d1.addEventListener("click", function(event){
    console.log("d1 click");
    console.log(event);
    console.log(event.currentTarget);
    console.log(event.target);

    if(event.target.className == 'buttons') {
        alert("asdf");
        console.log("this: " + this);
        alert(event.target.innerHTML);
    }

}, false); 

////////////////////////////////////////////////////////////
result.addEventListener("click", function(event){
    if(event.target.className='c1') {
        alert(event.target.innerHTML);
    }
});

// <button class = "c1">CLICK</button>
btn.addEventListener("click", function(){
    for(let i = 0; i < count.value; i++) {
        let button = document.createElement("button"); // <button></button>
        let t = document.createTextNode("CLICK" + i);  // CLICK 추가

        button.appendChild(t);                        // <button> CLICK00 </button>

        let attr = document.createAttribute("class"); // <button class = ""> CLICK00 </button>
        attr.value = "c1";                            // c1 추가
        button.setAttributeNode(attr);               // <button class = "c1"> CLICK00 </button>

        result.append(button);                       // id = "result" 안에 버튼을 넣어라
    }

});

for(c of c1) {
    c.addEventListener("click", function(){
        alert(c.innerHTML);

    })
}