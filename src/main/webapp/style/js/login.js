let User = {
    login: document.getElementById('login'),
    pwd: document.getElementById('pwd')
}

function allFieldNotNull() {
    return !!User.login.value && !!User.pwd.value;
}

function validate() {
    if (!allFieldNotNull()) {
        alert('All field must be filled');
        return false;
    }
}