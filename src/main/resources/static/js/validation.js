function isNumber(evnt) {
    if (evnt.keyCode === 13) {
        evnt.preventDefault();
    }
    var charC = (evnt.which) ? evnt.which : evnt.keyCode;
    if (charC === 46) {
        if (evnt.target.value.indexOf('.') === -1) {
            return true;
        } else {
            return false;
        }
    } else {
        if (charC > 31 && (charC < 48 || charC > 57))
            return false;
    }

    return true;
}

function isIntNumber(evnt) {
    if (evnt.keyCode === 13) {
        evnt.preventDefault();
    }
    if (evnt.key.match(/^[0-9]$/i))
        return true;

    return false;
}

function isCharacter(evnt) {
    if (evnt.keyCode === 13) {
        evnt.preventDefault();
    }

    if (evnt.key.match(/^[A-za-z. ]$/i))
        return true;

    return false;
}

function isEmpty(val) {

    if (val === undefined)
        return true;

    if (typeof (val) == 'function' || typeof (val) == 'number' || typeof (val) == 'boolean' || Object.prototype.toString.call(val) === '[object Date]')
        return false;

    if (val == null || val.length === 0)        // null or 0 length array
        return true;

    if (typeof (val) == "object") {
        // empty object

        var r = true;

        for (var f in val)
            r = false;

        return r;
    }

    return false;
}

function isValidateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function firstCapitalLetter(e) {
    if (!isEmpty(e.target.value)) {

        var str = e.target.value.split(" ");
        for (var i = 0, x = str.length; i < x; i++) {
            if (!isEmpty(str[i])) {
                str[i] = str[i][0].toUpperCase() + str[i].substr(1).toLowerCase();
            }
        }

        e.target.value = str.join(" ");
    }
}

function isValidPhone(txtPhone) {
    var filter = /^((\+[1-9]{1,4}[ \-]*)|(\([0-9]{2,3}\)[ \-]*)|([0-9]{2,4})[ \-]*)*?[0-9]{3,4}?[ \-]*[0-9]{3,4}?$/;
    if (filter.test(txtPhone)) {
        return true;
    } else {
        return false;
    }
}

function isNIC(text) {
    var nicRegex = /^([0-9]{9}[V|v|x|X])|([0-9]{12})^/;
    var valNic = nicRegex.test(text);
    if (valNic) {
        return true;
    }
    return false;
}