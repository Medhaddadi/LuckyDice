let btnRegister = document.getElementById('btnRegister');
let error = document.getElementById('error');
let User = {
    nom: document.getElementById('nom'),
    prenom: document.getElementById('prenom'),
    login: document.getElementById('login'),
    pwd: document.getElementById('pwd'),
    pwdConf: document.getElementById('pwdConf')
}
//add event of validation when user type
User.nom.addEventListener('keyup', function () {
    if (User.nom.value == '') {
        User.nom.style.border = '1px solid red';
        error.innerHTML = "Nom is required";
    } else {
        User.nom.style.border = '1px solid #ccc';
        error.innerHTML = "";
    }
});
User.prenom.addEventListener('keyup', function () {
    if (User.prenom.value == '') {
        User.prenom.style.border = '1px solid red';
        error.innerHTML = "Prenom is required";
    } else {
        User.prenom.style.border = '1px solid #ccc';
        error.innerHTML = "";
    }
});

User.login.addEventListener('keyup', function () {
    if (User.login.value == '') {
        User.login.style.border = '1px solid red';
        error.innerHTML = "Login is required";
    } else {
        User.login.style.border = '1px solid #ccc';
        error.innerHTML = "";
    }
});

User.pwd.addEventListener('keyup', function () {
    if (User.pwd.value == '') {
        User.pwd.style.border = '1px solid red';
        error.innerHTML = "Password is required";
    } else {
        User.pwd.style.border = '1px solid #ccc';
        error.innerHTML = "";
    }
});

User.pwdConf.addEventListener('keyup', function () {

    if (User.pwdConf.value == '') {
        User.pwdConf.style.border = '1px solid red';
        error.innerHTML = "Password is required";
    } else if (!pwdMatch()) {
        User.pwdConf.style.border = '1px solid red';
        error.innerHTML = "Password not match";
        error.style.color = 'red';
    } else {
        error.innerHTML = "";
        User.pwdConf.style.border = '1px solid #ccc';
    }
});

function pwdMatch() {
    return User.pwd.value == User.pwdConf.value;
}
