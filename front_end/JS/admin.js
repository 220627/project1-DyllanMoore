//admin-reimbursement-options-container
//admin-view-all-reimbursements-container
//admin-all-reimbursements-container
//admin-all-reimbursements-table
//admin-view-pending-reimbursements-container
//admin-pending-reimbursements-table
//edit pending

//Button consts
const adminReimbursementOptionsButton = document.getElementById("admin-reimbursement-options-button");
const generateAllReimbursementsButton = document.getElementById("generate-all-reimbursements");
const generatePendingReimbursementsButton = document.getElementById("generate-pending-reimbursements");
//Hidden Div Containers
const adminReimbursementOptionsContainer = document.getElementById("admin-reimbursement-options-container");
const adminViewAllReimbursementsContainer = document.getElementById("admin-view-all-reimbursements-container");
const adminAllReimbursementsContainer = document.getElementById("admin-all-reimbursements-container")
const adminViewPendingReimbursementsContainer = document.getElementById("admin-view-pending-reimbursements-container");
const adminPendingReimbursementsContainer = document.getElementById("admin-pending-reimbursements-container");


//Appendage Consts 


//Start Button/Form Functions
generateAllReimbursementsButton.addEventListener("click", function() {
        fetch("http://localhost:3000/reimbursement")
        .then(response => response.json()) 
        .then((data) => {
            const allReimbursementsTable = document.getElementById("admin-all-reimbursements-table");
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
    
});

generatePendingReimbursementsButton.addEventListener("click", function() {
        fetch("http://localhost:3000/reimbursement")
        .then(response => response.json()) 
        .then((data) => {
            const pendingReimbursementsTable = document.getElementById("admin-pending-reimbursements-table");
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
    
});






//End Button/Form Functions