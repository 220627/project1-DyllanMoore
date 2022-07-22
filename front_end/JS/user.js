//Button consts
const userReimbursementOptionsButton = document.getElementById("user-reimbursement-options-button");
const createUserReimbursementButton = document.getElementById("create-user-reimbursement-button");
const getAllReimbursementsIdButton = document.getElementById("get-all-reimbursements-id-button");
const getPendingReimbursementsButton = document.getElementById("get-pending-reimbursements-button");

//Hidden Div Containers
const userReimbursementOptionsContainer = document.getElementById("user-reimbursement-options-container");
const userViewAllReimbursementsContainer = document.getElementById("user-view-all-reimbursements-container");
const allReimbursementsContainer = document.getElementById("all-reimbursements-container")
const userViewPendingReimbursementsContainer = document.getElementById("user-view-pending-reimbursements-container");
const pendingReimbursementsContainer = document.getElementById("pending-reimbursements-container");


//Appendage Consts 
const formWarningAppendage = document.createElement("form-warning-appendage");
const formAcceptedAppendage = document.createElement("form-accepted-appendage");


//Start Button/Form Functions
userReimbursementOptionsButton.addEventListener("click", function() {
    const userReimbursementOptions = document.getElementById("user-reimbursement-options");
    switch(userReimbursementOptions.value){
        case "0":
            formWarningAppendage.innerHTML = `You must make a selection.`;
            userReimbursementOptionsContainer.appendChild(formWarningAppendage);
            break;
        case "1":
            createUserReimbursementContainer.style.display = "block";
            userReimbursementOptionsContainer.style.display = "none";
            break;
        case "2": 
            userViewAllReimbursementsContainer.style.display = "block";
            userReimbursementOptionsContainer.style.display = "none";
            break;
        case "3": 
            userViewPendingReimbursementsContainer.style.display = "block";
            userReimbursementOptionsContainer.style.display = "none";
            break;
        case "4":
            userUpdateChoiceContainer.style.display = "block";
            userReimbursementOptionsContainer.style.display = "none";
            break;
    }
});

   
getAllReimbursementsIdButton.addEventListener("click", function() {
    const getAllReimbursementsId = document.getElementById("get-all-reimbursements-id").value;
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
    }
});

getPendingReimbursementsButton.addEventListener("click", function() {
    const getPendingReimbursementsId = document.getElementById("get-pending-reimbursements-id").value;
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
    }
});






//End Button/Form Functions