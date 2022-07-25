//Button consts
const getAllReimbursementsIdButton = document.getElementById("get-all-reimbursements-id-button");
const getPendingReimbursementsButton = document.getElementById("get-pending-reimbursements-button");

//Hidden Div Containers
const allReimbursementsContainer = document.getElementById("all-reimbursements-container")
const pendingReimbursementsContainer = document.getElementById("pending-reimbursements-container");

//Start Button/Form Functions
getAllReimbursementsIdButton.addEventListener("click", function() {
    const getAllReimbursementsId = document.getElementById("get-all-reimbursements-id").value;
    const viewReimbursementChoiceErrorDiv = document.getElementById("view-reimbursement-choice-error-div");
    if(getAllReimbursementsId != 0) {
        fetch("http://localhost:3000/reimbursement")
        .then(response => response.json()) 
        .then((data) => {
            const allReimbursementsTable = document.getElementById("all-reimbursements-table");
            for(let i = 0; i < data.length; i++){
                let dataArray = Object.values(data[i]);
                let newReimbursementTableRow = allReimbursementsTable.insertRow(allReimbursementsTable.length);  
                if (getAllReimbursementsId == dataArray[5]) {
                    for(let j = 0; j < 8; j++){
                        let newReimbursementTableData = newReimbursementTableRow.insertCell(j);
                        newReimbursementTableData.innerHTML = dataArray[j];
                    }
                }
            }
        });
        allReimbursementsContainer.style.display = "block";
    } else {
        formWarningAppendage.innerHTML = `You must choose your employee ID.`
        viewReimbursementChoiceErrorDiv.appendChild(formWarningAppendage);
    }
});

getPendingReimbursementsButton.addEventListener("click", function() {
    const getPendingReimbursementsId = document.getElementById("get-pending-reimbursements-id").value;
    const viewReimbursementIDErrorDiv = document.getElementById("view-reimbursement-id-error-div");
    if(getPendingReimbursementsId != 0) {
        fetch("http://localhost:3000/reimbursement")
        .then(response => response.json()) 
        .then((data) => {
            const pendingReimbursementsTable = document.getElementById("pending-reimbursements-table");
            for(let i = 0; i < data.length; i++){
                let dataArray = Object.values(data[i]);
                let newReimbursementTableRow = pendingReimbursementsTable.insertRow(pendingReimbursementsTable.length);  
                if (getPendingReimbursementsId == dataArray[5]) {
                    if(dataArray[7] === 1){
                        for(let j = 0; j < 8; j++){
                            let newReimbursementTableData = newReimbursementTableRow.insertCell(j);
                            newReimbursementTableData.innerHTML = dataArray[j];
                        }
                    }
                }
            }
        });
        pendingReimbursementsContainer.style.display = "block";
    }  else {
        formWarningAppendage.innerHTML = `You must choose your employee ID.`
        viewReimbursementIDErrorDiv.appendChild(formWarningAppendage);
    }
});






//End Button/Form Functions