console.log("testing xhttp post");

window.onload = function () {

    sendOurAjax();
}

function sendOurAjax() {

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (xhttp.readyState === 4 && xhttp.status === 200) {

            let responseObj = JSON.parse(xhttp.responseText);

            console.log(responseObj);
        }
    }

    xhttp.open("POST", `http://localhost:9001/api/users`);

    xhttp.setRequestHeader('content-type', 'application/json');

    let newUser = {
        "username": "pepito",
        "password": "password",
        "firstName": "Pepe",
        "lastName": "Ocasio",
        "email": "pepe@email.com",
        "roleType": "employee"
    }

    xhttp.send(JSON.stringify(newUser));
}