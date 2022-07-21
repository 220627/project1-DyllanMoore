//Button Consts
const loginButton = document.getElementById("login-button");
const forgotUsernameButton = document.getElementById("forgot-username-button");
const createAnAccountButton = document.getElementById("create-account-button");

const loginFailedDiv = document.getElementById("login-failed-div");
let userIdLogin;

loginButton.addEventListener("click", function(){
    fetch("", {
        method: 'POST',
        body: JSON.stringify({"username": document.getElementById("login-username").value,
                            "password": document.getElementById("login-username")
        })
        .then(function(response) {
            if(response.status === 202){
                window.location.href = "http://http://127.0.0.1:5500/HTML/user.html";
            } else {
                loginFailed = document.createElement("login-failed").innerHTML = "Username or Password Incorrect";
                loginFailedDiv.append(loginFailed);
            }
        })
    })
})