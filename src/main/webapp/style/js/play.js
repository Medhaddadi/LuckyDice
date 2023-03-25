let desNumber =parseInt( document.getElementById('desNumber').value) ;
console.log(desNumber);

function validate() {
    if (desNumber == '') {
        alert('All field must be filled');
        return false;
    }
    if (desNumber < 1 || desNumber >4)
    {
        alert('Number of des must be between 1 and 3');
        return false;
    }
}
