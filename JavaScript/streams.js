var myArray = ["this", 'is', 'sparta'];

let result1 = myArray.map(e => e + "1").reduce((p, c) => p + "; " + c);
let result2 = myArray.map(e => e + "1");

console.log(result1);
console.log(result2);