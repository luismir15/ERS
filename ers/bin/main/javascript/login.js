console.log("login");

window.onload = function () {

    document
        .getElementById('userSubmit')
        .addEventListener('click', loginUser);
}

function loginUser() {

    console.log("testing user login");
    let username = document.getElementById('usernameInput').value;
    let password = document.getElementById('passwordInput').value;

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (xhttp.readyState === 4 && xhttp.status === 201) {

            let responseObj = JSON.parse(xhttp.responseText);
            console.log(responseObj);
        }
    }

    xhttp.open("POST", `http://localhost:9001/api`);

    xhttp.setRequestHeader('content-type', 'application/json');

    let userLogin = {
        "username": username,
        "password": password
    }

    xhttp.send(JSON.stringify(userLogin));
}
