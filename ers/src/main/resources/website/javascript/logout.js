

window.onload = function () {

    document.getElementById("logout").addEventListener('click', logoutUser)
}


function logout(eve){

    eve.preventDefault();
    logoutUser()
}

function logoutUser() {

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (xhttp.readyState === 4 && xhttp.status === 201) {

            let response = xhttp.responseText;

            if (response === "successfully logged out") {

                window.location.href = "index.html";
            }
        }
    }

    xhttp.open("POST", `http://localhost:9001/api/logout`);

    xhttp.send();
}