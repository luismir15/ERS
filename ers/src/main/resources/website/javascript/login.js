console.log("login");

window.onload = function () {

    document
        .getElementById('userSubmit')
        .addEventListener('click', login);
}

function login(eve) {

    console.log("login event has fired")
    eve.preventDefault();
    loginUser()
}

function loginUser() {

    console.log("testing user login");
    let username = document.getElementById('usernameInput').value;
    let password = document.getElementById('passwordInput').value;
    console.log("user input: " + username + " " + password);

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (xhttp.readyState === 4 && xhttp.status === 200) {

                console.log("receiving response");

                //let loginInfo = JSON.parse(xhttp.responseText);
                //console.log(loginInfo)

                if (xhttp.responseText === "employee") {

                     window.location.href = "/employee/employee-dashboard.html";
                }

                else {

                    window.location.href = "/manager/manager-dashboard.html";
                }
        }
    }

    xhttp.open("POST", "http://localhost:9001/api");

    xhttp.setRequestHeader('Content-Type', 'application/json');

    let userLogin = {
        "username": username,
        "password": password
    }

    xhttp.send(JSON.stringify(userLogin));
}

function domManipulation(ourObjectFromJSON) {
    //add this script also to the redirect page when the
    //user successfully logged in?!?!?
    document.getElementById("currentUser").innerText = ourObjectFromJSON.username;
}

