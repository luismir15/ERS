/*
    when the manager submits the id of the reimbursement
        showReimbursement(); show reimb from form
    get the necessary info to create an object
    when the manager hits approve/decline
        store the value
    the object ->
        "reimbursementId": from submit to showReimbursement()
       "reimbursementResolved": Date.now(),
       "reimbursementAuthor": userid (manager id),
       "reimbursementStatus": button value
 */

window.onload = function () {

    getUser();

    document
        .getElementById('userSearch')
        .addEventListener('click', getReimbFrom);

    document
        .getElementById('approveButton')
        .addEventListener('click', approveReimbForm);

    document
        .getElementById('declineButton')
        .addEventListener('click', declineReimbForm);
}

function getReimbFrom(eve) {

    eve.preventDefault();
    showReimbursement();
}

function approveReimbForm(eve) {

    eve.preventDefault();
    approveReimbursement();
}

function declineReimbForm(eve) {

    eve.preventDefault();
    declineReimbursement();
}

async function showReimbursement() {

    let id = document.getElementById("idInput").value;
    console.log(id);

    const reimbursementsResponse = await
        fetch(`http://localhost:9001/api/users/reimbursements/get-reimbursement/${id}`);

    let reimbursements = await reimbursementsResponse.json();

    console.log("status id: " + reimbursements.reimbursementStatusId);
    // approveReimbursement(reimbursements);
    // declineReimbursement(reimbursements);

    //table
    let reimbursementId = reimbursements.reimbursementId;
    let reimbursementAmount = reimbursements.reimbursementAmount;
    let reimbursementSubmitted = new Date(reimbursements.reimbursementSubmitted).toString().substring(0, 24);
    let reimbursementResolved = new Date(reimbursements.reimbursementResolved).toString().substr(0, 24);
    if (reimbursementResolved === "Wed Dec 31 1969 19:00:00") {

        reimbursementResolved = "pending";
    }
    console.log(reimbursementResolved);
    let reimbursementDescription = reimbursements.reimbursementDescription;
    let reimbursementAuthor = reimbursements.reimbursementAuthor;
    let reimbursementResolver = reimbursements.reimbursementResolver;
    let reimbursementStatus = reimbursements.reimbursementStatus;
    let reimbursementType = reimbursements.reimbursementType;

    let reimbursementTable = document.getElementById("userReimbursement");
    //add for loop to go over array object
    let newTableRow = reimbursementTable.insertRow();
    //define data from object
    let reimbursementIdColumn = newTableRow.insertCell(0);
    let reimbursementAmountColumn = newTableRow.insertCell(1);
    let reimbursementSubmittedColumn = newTableRow.insertCell(2);
    let reimbursementResolvedColumn = newTableRow.insertCell(3);
    let reimbursementDescriptionColumn = newTableRow.insertCell(4);
    let reimbursementAuthorColumn = newTableRow.insertCell(5);
    let reimbursementResolverColumn = newTableRow.insertCell(6);
    let reimbursementStatusColumn = newTableRow.insertCell(7);
    let reimbursementTypeColumn = newTableRow.insertCell(8);
    //add then dynamically
    reimbursementIdColumn.innerText = reimbursementId;
    reimbursementAmountColumn.innerText = reimbursementAmount;
    reimbursementSubmittedColumn.innerText = reimbursementSubmitted;
    reimbursementResolvedColumn.innerText = reimbursementResolved;
    reimbursementDescriptionColumn.innerText = reimbursementDescription;
    reimbursementAuthorColumn.innerText = reimbursementAuthor;
    reimbursementResolverColumn.innerText = reimbursementResolver;
    reimbursementStatusColumn.innerText = reimbursementStatus;
    reimbursementTypeColumn.innerText = reimbursementType;
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
            return secondUserResponse;
        }
    )
}

async function approveReimbursement() {

    console.log("approving reimbursement");

    let id = document.getElementById("idInput").value;

    const reimbursementsResponse = await
        fetch(`http://localhost:9001/api/users/reimbursements/get-reimbursement/${id}`);

    let reimbursements = await reimbursementsResponse.json();

    console.log("status id: " + reimbursements.reimbursementStatusId);

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (xhttp.readyState === 4 && xhttp.status === 200) {

            console.log("receiving response");

            window.location.href = "/manager/manager-dashboard.html";
        }
    }

    xhttp.open("POST", "http://localhost:9001/api/users/reimbursements/edit-reimbursement");

    xhttp.setRequestHeader('Content-Type', 'application/json');

    let reimbursementJSON = {

        "reimbursementStatus": document.getElementById('approveButton').value,
        "reimbursementStatusId": reimbursements.reimbursementStatusId,
        "reimbursementId": reimbursements.reimbursementId,
        "reimbursementResolved": Date.now()
    }

    console.log(reimbursementJSON);

    xhttp.send(JSON.stringify(reimbursementJSON));
}

async function declineReimbursement() {

    console.log("declining reimbursement");

    let id = document.getElementById("idInput").value;

    const reimbursementsResponse = await
        fetch(`http://localhost:9001/api/users/reimbursements/get-reimbursement/${id}`);

    let reimbursements = await reimbursementsResponse.json();

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (xhttp.readyState === 4 && xhttp.status === 200) {

            console.log("receiving response");

            window.location.href = "/manager/manager-dashboard.html";
        }
    }

    xhttp.open("POST", "http://localhost:9001/api/users/reimbursements/edit-reimbursement");

    xhttp.setRequestHeader('Content-Type', 'application/json');

    let reimbursementJSON = {

        "reimbursementStatus": document.getElementById('declineButton').value,
        "reimbursementStatusId": reimbursements.reimbursementStatusId,
        "reimbursementId": reimbursements.reimbursementId,
        "reimbursementResolved": Date.now()
    }

    console.log(reimbursementJSON);

    xhttp.send(JSON.stringify(reimbursementJSON));
}