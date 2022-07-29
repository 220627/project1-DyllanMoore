//Button consts
const userReimbursementOptionsButton = document.getElementById("user-reimbursement-options-button");
const createUserReimbursementButton = document.getElementById("create-user-reimbursement-button");
const userUpdateChoiceButton = document.getElementById("user-update-choice-button");
const userUpdateNameChoiceButton = document.getElementById("user-update-name-choice-button");
const userUpdateFirstNameButton = document.getElementById("user-update-first-name-button");
const userUpdateLastNameButton = document.getElementById("user-update-last-name-button");
const userUpdateUsernameButton = document.getElementById("user-update-username-button");
const userUpdatePasswordButton = document.getElementById("user-update-password-button");
const userUpdateEmailButton = document.getElementById("user-update-email-button");
const userUpdateRoleButton = document.getElementById("user-update-role-button");
const headerRefresh = document.getElementById("header-refresh");

//Hidden Div Containers
const userReimbursementOptionsContainer = document.getElementById("user-reimbursement-options-container");
const createUserReimbursementContainer = document.getElementById("create-user-reimbursement-container");
const userUpdateChoiceContainer = document.getElementById("user-update-choice-container");
const userUpdateNameChoiceContainer = document.getElementById("user-update-name-choice-container")
const userUpdateFirstNameContainer = document.getElementById("user-update-first-name-container");
const userUpdateLastNameContainer = document.getElementById("user-update-last-name-container");
const userUpdateUsernameContainer = document.getElementById("user-update-username-container");
const userUpdatePasswordContainer = document.getElementById("user-update-password-container");
const userUpdateEmailContainer = document.getElementById("user-update-email-container");
const userUpdateRoleContainer = document.getElementById("user-update-role-container");
const userViewAllReimbursementsContainer = document.getElementById("user-view-all-reimbursements-container");
const userViewPendingReimbursementsContainer = document.getElementById("user-view-pending-reimbursements-container");

//Appendage Consts 
const formWarningAppendage = document.createElement("form-warning-appendage");
const formAcceptedAppendage = document.createElement("form-accepted-appendage");

//Refresh Page (home)
headerRefresh.addEventListener("click", function() {
    window.location.reload();
});

//Start Button/Form Functions
userReimbursementOptionsButton.addEventListener("click", function() {
    const userReimbursementOptions = document.getElementById("user-reimbursement-options");
    const optionsErrorDiv = document.getElementById("options-error-div")
    switch(userReimbursementOptions.value){
        case "0":
            formWarningAppendage.innerHTML = `You must make a selection.`;
            optionsErrorDiv.appendChild(formWarningAppendage);
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
    const newreimbursementErrorDiv = document.getElementById("new-reimbursement-error-div");
    const newreimbursementSuccessDiv = document.getElementById("new-reimbursement-success-div");
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
                "reimbursement_resolution_fk": 1
            })
        })
        .then(function(response) {
            if(response.status === 202) {
                formAcceptedAppendage.innerHTML = `A reimbursment for ${createReimbursementAmount} was submitted for approval.`;
                newreimbursementSuccessDiv.append(formAcceptedAppendage);
            } else {
                formWarningAppendage.innerHTML = `An error occurred, please try again or contact support.`;
                newreimbursementErrorDiv.append(formWarningAppendage);
            }
        });
        } else {
            formWarningAppendage.innerHTML = `You are missing one or more inputs in your form.`;
            newreimbursementErrorDiv.append(formWarningAppendage);
    }
});
   

userUpdateChoiceButton.addEventListener("click", function() {
    const userUpdateUserChoice = document.getElementById("user-update-user-choice");
    const updateChoiceErrorDiv = document.getElementById("update-choice-error-div");
    switch(userUpdateUserChoice.value){
        case "0":
            formWarningAppendage.innerHTML = `You must make a selection.`;
            updateChoiceErrorDiv.append(formWarningAppendage);
            break;
        case "1":
            userUpdateNameChoiceContainer.style.display = "block";
            userUpdateChoiceContainer.style.display = "none";
            break;
        case "2":
            userUpdateUsernameContainer.style.display = "block";
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
    const nameChoiceErrorDiv = document.getElementById("name-choice-error-div");
    switch(userUpdateNameChoice.value){
        case "0":
            formWarningAppendage.innerHTML = `You must make a selection.`;
            nameChoiceErrorDiv.append(formWarningAppendage);
            break;
        case "1":
            userUpdateFirstNameContainer.style.display = "block";
            userUpdateNameChoiceContainer.style.display = "none";
            break;
        case "2":
            userUpdateLastNameContainer.style.display = "block";
            userUpdateNameChoiceContainer.style.display = "none";
            break;
    }
});

userUpdateFirstNameButton.addEventListener("click", function() {
    const updateFirstNameOnly = document.getElementById("update-first-name-only").value;
    const updateFirstNameOnlyId = document.getElementById("employee-first-name-only-id").value;
    const firstNameErrorDiv = document.getElementById("first-name-error-div");
    const firstNameSuccessDiv = document.getElementById("first-name-success-div");
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
                firstNameSuccessDiv.innerHTML = `An error occurred, please try again or contact support.`;
                firstNameErrorDiv.append(formWarningAppendage);
            }
        });
    } else {
        formWarningAppendage.innerHTML = `New name can not be blank.`;
        firstNameErrorDiv.append(formWarningAppendage);
    }
});

userUpdateLastNameButton.addEventListener("click", function() {
    const updateLastNameOnly = document.getElementById("update-last-name-only").value;
    const updateLastNameOnlyId = document.getElementById("employee-last-name-only-id").value;
    const lastNameErrorDiv = document.getElementById("last-name-error-div");
    const lastNameSuccessDiv = document.getElementById("last-name-success-div");
    if(updateLastNameOnly.length != 0 && updateLastNameOnlyId.length != 0) {
        fetch("http://localhost:3000/firstname/"+ updateLastNameOnlyId, {
            method: 'PUT',
            body: JSON.stringify({
                updateLastNameOnly
            })
        })
        .then(function(response) {
            if(response.status === 202){
                formAcceptedAppendage.innerHTML = `Your last name was updated to ${updateLastNameOnly}.`;
                lastNameSuccessDiv.append(formAcceptedAppendage);
            } else {
                formWarningAppendage.innerHTML = `An error occurred, please try again or contact support.`;
                lastNameErrorDiv.append(formWarningAppendage);
            }
        });
    } else {
        formWarningAppendage.innerHTML = `New name can not be blank.`;
        lastNameErrorDiv.append(formWarningAppendage);
    }
});

userUpdateUsernameButton.addEventListener("click", function(){
    const updateUsername = document.getElementById("update-username");
    const updateUsernameId = document.getElementById("update-username-id");
    const usernameErrorDiv = document.getElementById("username-error-div");
    const usernameSuccessDiv = document.getElementById("username-success-div");
    if(updateUsername != 0 && updateUsernameId != 0){
        fetch("http://localhost:3000/username/" + updateUsernameId, {
                method: 'PUT',
                body: JSON.stringify({
                    updateUsername
                })
        })
        .then(function(response) {
            if(response.status === 202) {
                formAcceptedAppendage.innerHTML = `You username was updated to ${updateUsername}.`;
                usernameSuccessDiv.append(formAcceptedAppendage);
            }
        });
    } else {
        formWarningAppendage.innerHTML = `New username can not be blank.`;
        usernameErrorDiv.append(formWarningAppendage);
    }
});

userUpdatePasswordButton.addEventListener("click", function(){
    const updateOldPassword = document.getElementById("update-old-password");
    const updatePassword = document.getElementById("update-new-password");
    const updatePasswordConfirm = document.getElementById("confirm-new-password");
    const updatePasswordId = document.getElementById("update-password-id");
    const passwordErrorDiv = document.getElementById("password-error-div");
    const passwordSuccessDiv = document.getElementById("password-success-div");
    if(updatePassword != 0 && updatePasswordId != 0){
         if(updatePassword === updatePasswordConfirm && updatePassword != updateOldPassword){
             fetch("http://localhost:3000/password/" + updatePasswordId, {
                 method: 'PUT',
                 body: JSON.stringify({
                     updateUsername
                 })
             })
             .then(function(response) {
                 if(response.status === 202) {
                     formAcceptedAppendage.innerHTML = `You username was updated to ${updateUsername}.`;
                     passwordSuccessDiv.append(formAcceptedAppendage);
                 }
                  else {
                     formWarningAppendage.innerHTML = `New passwords must match and can not be the same as your old password.`;
                     passwordErrorDiv.append(formWarningAppendage);
        }});
    } else {
        formWarningAppendage.innerHTML = `New password can not be blank.`;
        passwordErrorDiv.append(formWarningAppendage);
    }
}});

userUpdateEmailButton.addEventListener("click", function() {
    const updateEmail = document.getElementById("update-email").value;
    const updateEmailId = document.getElementById("update-email-id").value;
    const emailErrorDiv = document.getElementById("email-error-div");
    const emailSuccessDiv = document.getElementById("email-success-div");
    if(updateEmail.length != 0 && updateEmailId.length != 0) {
        fetch("http://localhost:3000/useremail/"+ updateEmailId, {
            method: 'PUT',
            body: JSON.stringify({
                updateEmail
            })
        })
        .then(function(response) {
            if(response.status === 202){
                formAcceptedAppendage.innerHTML = `Your email was updated to ${updateEmail}.`;
                emailSuccessDiv.append(formAcceptedAppendage);
            } else {
                formWarningAppendage.innerHTML = `An error occurred, please try again or contact support.`;
                emailErrorDiv.append(formWarningAppendage);
            }
        });
    } else {
        formWarningAppendage.innerHTML = `New email can not be blank.`;
        emailErrorDiv.append(formWarningAppendage);
    }
});

userUpdateRoleButton.addEventListener("click", function() {
    const updateUserRole = document.getElementById("update-user-role").value;
    const updateUserRoleId = document.getElementById("update-user-role-id").value;
    const updateUserRoleInt = parseInt(document.getElementById("update-user-role").value);
    const roleErrorDiv = document.getElementById("role-error-div");
    const roleSuccessDiv = document.getElementById("role-success-div");
    let userRoleName;
    if(updateUserRole.length != 0 && updateUserRoleId.length != 0) {
        fetch("http://localhost:3000/role/"+ updateUserRoleId, {
            method: 'PUT',
            body: JSON.stringify(
                updateUserRoleInt
            )
        })
        .then(function(response) {
            if(response.status === 202){
                userRole = document.getElementById("update-user-role");
                switch(userRole.value) {
                    case "1":
                        userRoleName = "Scarer";
                        break;
                    case "2":
                        userRoleName = "Scarer Assistant";
                        break;
                    case "3":
                        userRoleName = "Secretary";
                        break;
                    case "4":
                        userRoleName = "Hazmat";
                        break;
                    case "5":
                        userRoleName = "Key Master";
                        break;
                }
                formAcceptedAppendage.innerHTML = `Your role was updated to ${userRoleName}.`;
                roleSuccessDiv.append(formAcceptedAppendage);
            } else {
                formWarningAppendage.innerHTML = `An error occurred, please try again or contact support.`;
                roleErrorDiv.append(formWarningAppendage);
            }
        });
    } else {
        formWarningAppendage.innerHTML = `New role can not be blank.`;
        roleErrorDiv.append(formWarningAppendage);
    }
});


//End Button/Form Functions