//Button consts
const userReimbursementOptionsButton = document.getElementById("user-reimbursement-options-button");
const createUserReimbursementButton = document.getElementById("create-user-reimbursement-button");
const userUpdateChoiceButton = document.getElementById("user-update-choice-button");
const userUpdateNameChoiceButton = document.getElementById("user-update-name-choice-button");
const userUpdateFirstNameButton = document.getElementById("user-update-first-name-button");
const userUpdateLastNameButton = document.getElementById("user-update-last-name-button");
const userUpdateBothNamesButton = document.getElementById("user-update-both-names-button");
const userUpdateUsernameButton = document.getElementById("user-update-username-button");
const userUpdatePasswordButton = document.getElementById("user-update-password-button");
const userUpdateEmailButton = document.getElementById("user-update-email-button");
const userUpdateRoleButton = document.getElementById("user-update-role-button");

//Hidden Div Containers
const userReimbursementOptionsContainer = document.getElementById("user-reimbursement-options-container");
const createUserReimbursementContainer = document.getElementById("create-user-reimbursement-container");
const userViewAllReimbursementsContainer = document.getElementById("user-view-all-reimbursements-container");
const userViewPendingReimbursementsContainer = document.getElementById("user-view-pending-reimbursements-container");
const userUpdateChoiceContainer = document.getElementById("user-update-choice-container");
const userUpdateNameChoiceContainer = document.getElementById("user-update-name-choice-container")
const userUpdateFirstNameContainer = document.getElementById("user-update-first-name-container");
const userUpdateLastNameContainer = document.getElementById("user-update-last-name-container");
const userUpdateBothNamesContainer = document.getElementById("user-update-both-names-container");
const userUpdateUsernameContaienr = document.getElementById("user-update-username-container");
const userUpdatePasswordContainer = document.getElementById("user-update-password-container");
const userUpdateEmailContainer = document.getElementById("user-update-email-container");
const userUpdateRoleContainer = document.getElementById("user-update-role-container");

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

createUserReimbursementButton.addEventListener("click", function() {
    const createReimbursementEmployee = document.getElementById("create-reimbursement-employee").value;
    const createReimbursementAmount = document.getElementById("create-reimbursement-amount").value;
    const createReimbursementDescription = document.getElementById("create-reimbursement-description").value;
    const createReimbursementDate = document.getElementById("create-reimbursement-date").value;
    const createReimbursemntType = document.getElementById("create-reimbursement-type").value;
    if( createReimbursementEmployee.length != 0 && createReimbursementAmount.length != 0 && createReimbursementDescription.length != 0
        && createReimbursementDate.length != 0 && createReimbursemntType.length != 0) {
        fetch("http://localhost:3000/newreimbursement", {
            method: 'POST',
            body: JSON.stringify({
                "reimbursement_amount": createReimbursementAmount,
                "reimbursement_submitted": createReimbursementDate,
                "reimbursement_description": createReimbursementDescription,
                "reimbursement_type_fk": createReimbursemntType,
                "reimbursement_author_fk": createReimbursementEmployee,
                "reimbursement_resolver_fk": 6,
                "reimbursement_status_fk": 1
            })
        })
        .then(function(response) {
            if(response.status === 202) {
                formAcceptedAppendage.innerHTML = `A reimbursment for ${createReimbursementAmount} was submitted for approval.`;
                createUserReimbursementContainer.append(formAcceptedAppendage);
            } else {
                formWarningAppendage.innerHTML = `An error occurred, please try again or contact support.`;
                createUserReimbursementContainer.append(formWarningAppendage);
            }
        });
        } else {
            formWarningAppendage.innerHTML = `You are missing one or more inputs in your form.`;
            createUserReimbursementContainer.append(formWarningAppendage);
    }
});

// View Reimbursements Go Here===========================================================================================================





userUpdateChoiceButton.addEventListener("click", function() {
    const userUpdateUserChoice = document.getElementById("user-update-user-choice");
    switch(userUpdateUserChoice.value){
        case "0":
            formWarningAppendage.innerHTML = `You must make a selection.`;
            userUpdateChoiceContainer.append(formWarningAppendage);
            break;
        case "1":
            userUpdateNameChoiceContainer.style.display = "block";
            userUpdateChoiceContainer.style.display = "none";
            break;
        case "2":
            userUpdateUsernameContaienr.style.display = "block";
            userUpdateChoiceContainer.style.display = "none";
            break;
        case "3":
            userUpdatePasswordContainer.style.display = "block";
            userUpdateChoiceContainer.style.display = "none";
            break;
        case "4":
            userUpdateEmailContainer.style.display = "block";
            userUpdateChoiceContainer.style.display = "none";
            break;
        case "5":
            userUpdateRoleContainer.style.display = "block";
            userUpdateChoiceContainer.style.display = "none";
            break;
    }
});

userUpdateNameChoiceButton.addEventListener("click", function(){
    const userUpdateNameChoice = document.getElementById("user-update-name-choice");
    switch(userUpdateNameChoice.value){
        case "0":
            formWarningAppendage.innerHTML = `You must make a selection.`;
            userUpdateChoiceContainer.append(formWarningAppendage);
            break;
        case "1":
            userUpdateFirstNameContainer.style.display = "block";
            userUpdateNameChoiceContainer.style.display = "none";
            break;
        case "2":
            userUpdateLastNameContainer.style.display = "block";
            userUpdateNameChoiceContainer.style.display = "none";
            break;
        case "3":
            userUpdateBothNamesContainer.style.display = "block";
            userUpdateNameChoiceContainer.style.display = "none";
            break;
    }
});

userUpdateFirstNameButton.addEventListener("click", function() {
    const updateFirstNameOnly = document.getElementById("update-first-name-only").value;
    const updateFirstNameOnlyId = document.getElementById("employee-first-name-only-id").value;
    if(updateFirstNameOnly.length != 0 && updateFirstNameOnlyId != 0){
        fetch("http://localhost:3000/firstname/"+ updateFirstNameOnlyId, {
            method: 'PUT',
            body: JSON.stringify({
                updateFirstNameOnly
            })
        })
        .then(function(response) {
            if(response.status === 202){
                formAcceptedAppendage.innerHTML = `Your first name was updated to ${updateFirstNameOnly}.`;
                userUpdateFirstNameContainer.append(formAcceptedAppendage);
            } else {
                formWarningAppendage.innerHTML = `An error occurred, please try again or contact support.`;
                userUpdateFirstNameContainer.append(formWarningAppendage);
            }
        });
    } else {
        formWarningAppendage.innerHTML = `New name can not be blank.`;
        userUpdateFirstNameContainer.append(formWarningAppendage);
    }
});

































































//End Button/Form Functions