alert("Welcome");

// 1
// int num = 1;
var num = 1;
num = 'abc';

let num2='1';

console.log(num == num2);
console.log(num == num2);

var count = 1;
for(var i = 0; i < 10; i++) {
    console.log(i);
    count = 1;
}

console.log('------------------------')
console.log(i);
console.log(count);
console.log('------------------------')

let ar = ['4', '1', '3', '2'];
console.log(ar[0]);
console.log(ar[1]);
console.log('---------------------------------------')
ar.push(5);
console.log(ar);
ar.unshift('9');
console.log(ar);


// for문에 let i 말고 var로 선언할 시 {} 밖에서도 사용 가능