interface Person {
    firstName: string | undefined;
    lastName: string | undefined;
}

class Student {
    fullName: string;
    constructor(public firstName: string, public middleInitial: string, public lastName: string) {
        this.fullName = firstName + " " + middleInitial + " " + lastName;
    }
}

class MyStudent implements Person {
    firstName: string | undefined;
    lastName: string | undefined;
    middleName: string | undefined;
}

class YoungStudent extends Student {
    age: number | undefined;
}

function greetPerson(person: Person) {
    return "Hello, " + person.firstName + " " + person.lastName;
}

function printString(person: string) {
    return "Hello, " + person;
}

let userString = "Jane User";
let userPerson = {"firstName": "Markus", lastName: "Meier"};
let userStudent = new Student("This", "I.", "Sparta");

let myStudent = new MyStudent();
let youngStudent = new YoungStudent("a", "b", "c");

document.body.textContent = printString(userString);
document.body.textContent += greetPerson(userPerson);
document.body.textContent += greetPerson(userStudent);
document.body.textContent += greetPerson(myStudent);
document.body.textContent += greetPerson(youngStudent);