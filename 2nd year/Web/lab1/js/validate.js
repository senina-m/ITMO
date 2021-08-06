var form = document.querySelector('.formWithValidation')

form.addEventListener('submit', function (event) {
    event.preventDefault()
    if (validateForm()) {
        form.submit()
    }
})

var validateForm = function () {
    logValues()
    removeErrors()
    return checkValues()
}

var printError = function (errorName, errorClass, errorMessage, element) {
    console.log(errorName, element)
    var error = document.createElement('div')
    error.className = errorClass
    error.innerHTML = errorMessage
    element.parentElement.insertBefore(error, element)
}
var removeErrors = function () {
    var errors = form.querySelectorAll('.error')
    for (var i = 0; i < errors.length; i++) {
        errors[i].remove()
    }
}

var logValues = function () {
    console.log('clicked on validate')
    console.log('y: ', y.value)
    console.log('r: ', r.value)
}

var checkValues = function () {
    var fields = form.querySelectorAll('.field')
    let anyErrors = 0

    for (var i = 0; i < fields.length; i++) {
        if (!fields[i].value) {
            printError('field is blank', 'blankField error', 'Cannot be blank', fields[i])
            anyErrors++
        }
    }

    if (y.value == "" || y.value > 3 || y.value < -5 || isNaN(Number(y.value))) {
        printError('y is out of range', 'y error', 'Has to be number from -5 to 3', y)
        anyErrors++
    }
    if (r.value == "" || r.value > 5 || r.value < 2 || isNaN(Number(r.value))) {
        printError('r is out of range', 'r error', 'Has to be number from 2 to 5', r)
        anyErrors++
    }
    return anyErrors == 0
}
