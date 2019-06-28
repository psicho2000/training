function myFunc(callback, arg) {
    callback(arg);
}

function calledFunc(arg) {
    alert("callback: " + arg);
}

myFunc(calledFunc, "b");

myFunc(function (arg) {
    alert("spontaneous function " + arg)
}, "b");

myFunc((a) => alert("lambda call: " + a), "myArg")