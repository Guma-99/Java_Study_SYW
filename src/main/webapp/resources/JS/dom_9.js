// dom_9.js

const d1 = document.querySelector("#d1");
const d1_2_1_2 = document.querySelector("d1_2_1_2");
const btn = document.querySelector("#btn")

console.log(d1_2_1_2.previousSibling.previousSibling);
console.log(d1_2_1_2.nextSibling)

console.log("============================================");
// parent
console.log(d1_2_1_2.parentNode.parentNode.parentNode);

btn.addEventListener("click", function () {
    d1_2_1_2.parentNode.parentNode.remove();
});
console.log(d1_2_1_2.parentNode.parentNode.parentNode);

console.log("============================================")

// child
console.log(d1.childNodes);
console.log(d1.children);
console.log(d1.childNodes[3].childNodes[1].childNodes[1].innerHTML);
console.log(d1.children[1].children[0].children[0].innerHTML);

d1.addEventListener("click", function () {
    // li 모두 삭제
    d1.children[1].children[0].children[0].remove();

});