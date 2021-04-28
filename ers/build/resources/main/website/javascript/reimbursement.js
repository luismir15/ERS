/*
    the client will enter: amount, type and description

    the session will give the rest of the information needed
    to populate the table correctly.
 */
console.log("creating new reimbursement");

window.onload = function() {

    console.log("in window on load");
    //get the user info
    document
        .getElementById("userSubmit")
        .addEventListener('click', createReimbursement);
}

function createReimbursement(eve) {

    console.log("in create reimbursement");
    eve.preventDefault();
    getUser();
}

function getUser() {

    console.log("in getUser function");

    fetch(`http://localhost:9001/api`)
        .then(
            function (userResponse) {
                console.log("in first fetch function");
                const convertedUser = userResponse.json();
                console.log(convertedUser);
                return convertedUser;
            }
        ). then(
        function (secondUserResponse) {
            console.log("in second fetch function");
            console.log(secondUserResponse);
            submitReimbursementJSON(secondUserResponse);
        }
    )
}

function submitReimbursementJSON(objectJSON) {

    console.log("in submit function");

    let reimbursement = {

        "reimbursementAmount": document.getElementById("amountInput").value,
        "reimbursementSubmitted": Date.now(),
        "reimbursementDescription": document.getElementById("descriptionInput").value,
        "reimbursementAuthorId": objectJSON.userId,
        "reimbursementType": document.getElementById("typeInput").value
    }

    console.log(reimbursement);

    //step 1
    let xhttp = new XMLHttpRequest();

    //step 2
    xhttp.onreadystatechange = function () {

        if (xhttp.readyState === 4 && xhttp.status === 201) {

            let newUserJSON = JSON.parse(xhttp.responseText);
            console.log("response: " + newUserJSON);
            window.location.href = "/employee/employee-dashboard.html";
        }
    }

    //step 3
    xhttp.open("POST", `http://localhost:9001/api/users/reimbursements/create-reimbursement`);

    xhttp.setRequestHeader('Content-Type', 'application/json');

    //step 4
    xhttp.send(JSON.stringify(reimbursement));
}

