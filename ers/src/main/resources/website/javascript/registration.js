console.log("testing registration");

window.onload = function () {

    document
        .getElementById('userSubmit')
        .addEventListener('click', userInput);
}

function userInput(eve) {

    console.log("event has fired");
    eve.preventDefault();
    getInformaiton();
}

function getInformaiton() {

    console.log("in getinfo method");

    let createNewUser = {
        "username": document.getElementById("usernameInput").value,
        "password": document.getElementById("passwordInput").value,
        "firstName": document.getElementById("firstNameInput").value,
        "lastName": document.getElementById("lastNameInput").value,
        "email": document.getElementById("emailNameInput").value,
        "roleType": document.getElementById("employee").value
    }
    console.log(createNewUser);

    //step 1
    let xhttp = new XMLHttpRequest();

    //step 2
    xhttp.onreadystatechange = function () {

        if (xhttp.readyState === 4 && xhttp.status === 201) {

            let newUserJSON = JSON.parse(xhttp.responseText);
            console.log("response: " + newUserJSON);
            window.location.href = "/index.html";
        }
    }

    //step 3
    xhttp.open("POST", `http://localhost:9001/api/registration`);

    xhttp.setRequestHeader('Content-Type', 'application/json');

    //step 4
    xhttp.send(JSON.stringify(createNewUser));
}