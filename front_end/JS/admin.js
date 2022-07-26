//Button consts
const adminReimbursementOptionsButton = document.getElementById("admin-reimbursement-options-button");
const generateAllReimbursementsButton = document.getElementById("generate-all-reimbursements");
const generatePendingReimbursementsButton = document.getElementById("generate-pending-reimbursements");
const updateResolutionButton = document.getElementById("update-resolution-button");
//Hidden Div Containers
const adminAllReimbursementsContainer = document.getElementById("admin-all-reimbursements-container")
const adminPendingReimbursementsContainer = document.getElementById("admin-pending-reimbursements-container");
const adminUpdateResolutionContainer = document.getElementById("admin-update-resolution-container");

//Start Button/Form Functions
generateAllReimbursementsButton.addEventListener("click", function() {
        fetch("http://localhost:3000/reimbursement")
        .then(response => response.json()) 
        .then((data) => {
            const allReimbursementsTable = document.getElementById("admin-all-reimbursements-table");
            for(let i = 0; i < data.length; i++){
                let dataArray = Object.values(data[i]);
                let newReimbursementTableRow = allReimbursementsTable.insertRow(allReimbursementsTable.length);  
                for(let j = 0; j < 8; j++){
                    let newReimbursementTableData = newReimbursementTableRow.insertCell(j);
                    newReimbursementTableData.innerHTML = dataArray[j];
                }
            }
        });
        adminAllReimbursementsContainer.style.display = "block";
});

generatePendingReimbursementsButton.addEventListener("click", function() {
        fetch("http://localhost:3000/reimbursement")
        .then(response => response.json()) 
        .then((data) => {
            const pendingReimbursementsTable = document.getElementById("admin-pending-reimbursements-table");
            for(let i = 0; i < data.length; i++){
                let dataArray = Object.values(data[i]);
                let newReimbursementTableRow = pendingReimbursementsTable.insertRow(pendingReimbursementsTable.length);  
                if(dataArray[7] === 1){
                    for(let j = 0; j < 8; j++){
                        let newReimbursementTableData = newReimbursementTableRow.insertCell(j);
                        newReimbursementTableData.innerHTML = dataArray[j];
                    }
                }
            }
        });
        adminPendingReimbursementsContainer.style.display = "block";
    
});

updateResolutionButton.addEventListener("click", function() {
    const updatePendingId = document.getElementById("update-pending-id").value;
    const updatePendingResolution = document.getElementById("update-pending-resolution").value;
    const updatePendingResolutionInt = parseInt(document.getElementById("update-pending-resolution").value);
    const updateReimbursementErrorDiv = document.getElementById("update-reimbursement-error-div");
    const updateReimbursementSuccessDiv = document.getElementById("update-reimbursement-success-div");
    let resolution;
    if(updatePendingId.length != 0 && updatePendingResolution.length != 0){
        fetch("http://localhost:3000/updateresolution/" + updatePendingId, {
            method: 'PUT',
            body: updatePendingResolutionInt
        })
        .then (function(response) {
            if(response.status === 202){
                switch(updatePendingResolution){
                    case "2": 
                        resolution = "Approved";
                        break;
                    case "3":
                        resolution = "Denied";
                        break;
                }
                formAcceptedAppendage.innerHTML = `Reimbursement ID # ${updatePendingId} was ${resolution}.`;
                updateReimbursementSuccessDiv.append(formAcceptedAppendage);
            } else {
                formWarningAppendage.innerHTML = `An error occured, please try again or contact support.`;
                updateReimbursementErrorDiv.append(formWarningAppendage);
            }
        });
    } else {
        formWarningAppendage.innerHTML = `One or more inputs is blank.`;
        updateReimbursementErrorDiv.append(formWarningAppendage);
    }

});

//End Button/Form Functions