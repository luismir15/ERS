console.log("in employee page");

window.onload = function () {

    getReimbursementInfo(getUser());
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
                displayUserInformation(secondUserResponse);
            }
        )
}

function displayUserInformation(objectJSON) {
    console.log("setting up dom manipulation")
    document.getElementById("username").innerText = objectJSON.username;
    return objectJSON.username;

}

function getReimbursementInfo(username) {

    console.log("testing reimb info for: " + username);

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        console.log("receiving reimb response");

        if (xhttp.readyState === 4 && xhttp.status === 200) {

            let reimbInfoJSON = JSON.parse(xhttp.responseText);
            console.log(reimbInfoJSON);

            for (let i = 0; i < reimbInfoJSON.length; i++) {

                displayReimbInfo(reimbInfoJSON, i);
            }
        }
    }

    xhttp.open("GET", `http://localhost:9001/api/users/reimbursements/${username}`);

    xhttp.send();
}

function displayReimbInfo(userObjectJSON, index) {

    //break down object
    //let index = 0;
    let reimbursementId = userObjectJSON[index].reimbursementId;
    let reimbursementAmount = userObjectJSON[index].reimbursementAmount;
    let reimbursementSubmitted = new Date(userObjectJSON[index].reimbursementSubmitted).toString();
    let reimbursementResolved = new Date(userObjectJSON[index].reimbursementResolved).toString();
    if (reimbursementResolved === "Wed Dec 31 1969 19:00:00") {

        reimbursementResolved = "pending";
    }
    let reimbursementDescription = userObjectJSON[index].reimbursementDescription;
    let reimbursementAuthor = userObjectJSON[index].reimbursementAuthor;
    let reimbursementResolver = userObjectJSON[index].reimbursementResolver;
    let reimbursementStatus = userObjectJSON[index].reimbursementStatus;
    let reimbursementType = userObjectJSON[index].reimbursementType;

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
    reimbursementSubmittedColumn.innerText = reimbursementSubmitted.substring(0, 24);
    reimbursementResolvedColumn.innerText = reimbursementResolved.substr(0, 24);
    reimbursementDescriptionColumn.innerText = reimbursementDescription;
    reimbursementAuthorColumn.innerText = reimbursementAuthor;
    reimbursementResolverColumn.innerText = reimbursementResolver;
    reimbursementStatusColumn.innerText = reimbursementStatus;
    reimbursementTypeColumn.innerText = reimbursementType;
}

// console.log(userObjectJSON[0].reimbursementId);
// console.log(userObjectJSON[0].reimbursementAmount);
// let timeSubmitted = new Date(userObjectJSON[0].reimbursementSubmitted);
// console.log(timeSubmitted);
// let timeResolved = new Date(userObjectJSON[0].reimbursementResolved).toString();
// console.log(timeResolved);
// document.getElementById("resolved").innerText = timeResolved;

// document.getElementById("reimbursement-id").innerText = userObjectJSON[0].reimbursementId;
// document.getElementById("amount").innerText = userObjectJSON[0].reimbursementAmount;
// document.getElementById("submitted").innerText = userObjectJSON[0].reimbursementSubmitted;
// document.getElementById("resolved").innerText = userObjectJSON[0].reimbursemenResolved;
// document.getElementById("description").innerText = userObjectJSON[0].reimbursementDescription;
// document.getElementById("author").innerText = userObjectJSON[0].reimbursementResolveAuthorId;
// document.getElementById("resolver").innerText = userObjectJSON[0].reimbursementResolverId;
// document.getElementById("status").innerText = userObjectJSON[0].reimbursementStatusId;
// document.getElementById("type").innerText = userObjectJSON[0].reimbursementIdTypeId;

// function getReimbursementInfo(username) {
//
//     console.log("in get reimb info");
//
//     fetch(`http://localhost:9001/api/users/reimbursements/${username}`)
//         .then(
//             function (reimbResponse) {
//                 console.log("in first fetch function");
//                 const convertedUser = reimbResponse.json();
//                 return convertedUser;
//             }
//         ). then(
//         function (secondReimbResponse) {
//             console.log("in second fetch function");
//             console.log(secondReimbResponse);
//             console.log(typeof secondReimbResponse);
//             displayReimbInfo(secondReimbResponse);
//         }
//     )
// }