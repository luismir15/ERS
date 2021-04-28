/*
    functionality for a manager
        >view all reimbursement
        >edit only 'pending' reimbursements
    resolve: Wed Dec 31 1969 19:00:00 -> issue
 */

console.log("in manager page");

window.onload = function () {

    getAllUsers();
}

async function getAllUsers() {

    console.log("in getAllUser async function");

    const reimbursementsResponse = await fetch(`http://localhost:9001/api/users/reimbursements`);

    let reimbursementsList = await reimbursementsResponse.json();
    console.log(reimbursementsList);

    //populate table
    for (let i = 0; i < reimbursementsList.length; i++) {

        displayReimbInfo(reimbursementsList, i);
    }
}

function displayReimbInfo(userObjectJSON, index) {

    //break down object
    //let index = 0;
    let reimbursementId = userObjectJSON[index].reimbursementId;
    let reimbursementAmount = userObjectJSON[index].reimbursementAmount;
    let reimbursementSubmitted = new Date(userObjectJSON[index].reimbursementSubmitted).toString().substring(0, 24);
    let reimbursementResolved = new Date(userObjectJSON[index].reimbursementResolved).toString().substr(0, 24);
    if (reimbursementResolved === "Wed Dec 31 1969 19:00:00") {

        reimbursementResolved = "pending";
    }
    console.log(reimbursementResolved);
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
    reimbursementSubmittedColumn.innerText = reimbursementSubmitted;
    reimbursementResolvedColumn.innerText = reimbursementResolved;
    reimbursementDescriptionColumn.innerText = reimbursementDescription;
    reimbursementAuthorColumn.innerText = reimbursementAuthor;
    reimbursementResolverColumn.innerText = reimbursementResolver;
    reimbursementStatusColumn.innerText = reimbursementStatus;
    reimbursementTypeColumn.innerText = reimbursementType;
}