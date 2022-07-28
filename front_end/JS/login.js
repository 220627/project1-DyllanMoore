//Button Consts
const loginButton = document.getElementById("login-button");
const forgotUsernameButton = document.getElementById("forgot-username-button");
const createAnAccountButton = document.getElementById("create-account-button");
const loginAdmin = document.getElementById("login-admin");

const loginFailedDiv = document.getElementById("login-failed-div");
let userIdLogin;

loginButton.addEventListener("click", function(){
    if(loginAdmin.value === "1"){
        fetch("http://localhost:3000/userlogin", {
            method: 'POST',
            body: JSON.stringify({"username": document.getElementById("login-username").value,
                                "password": document.getElementById("login-password").value
            })
        })
        .then(function(response) {
            if(response.status === 202){
                window.location.href = "http://127.0.0.1:5500/HTML/user.html";
            } else {
                const loginFailed = document.createElement("login-failed").innerHTML = "Username or Password Incorrect";
                loginFailedDiv.append(loginFailed);
            }
        })
    } else if(loginAdmin.value === "2"){
        fetch("http://localhost:3000/adminlogin", {
            method: 'POST',
            body: JSON.stringify({"username": document.getElementById("login-username").value,
                                "password": document.getElementById("login-password").value
            })
        })
        .then(function(response) {
            if(response.status === 202){
                window.location.href = "http://127.0.0.1:5500/HTML/admin.html";
            } else {
                const loginFailed = document.createElement("login-failed").innerHTML = "Username or Password Incorrect";
                loginFailedDiv.append(loginFailed);
            }
        })
        
    }
})