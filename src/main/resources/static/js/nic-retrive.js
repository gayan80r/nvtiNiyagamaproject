var NIC_FILED = null;
var GENDER_SELECTOR = null;
var DOB_FIELD = null;

function initializeNIC(nic, genderSelecter, dob) {
    NIC_FILED = nic;
    GENDER_SELECTOR = genderSelecter;
    DOB_FIELD = dob;
    $(NIC_FILED).keyup(reteriveNIC);
    $(NIC_FILED).keypress(NICValidation);
}

function NICValidation(evnt) {
    if (evnt.keyCode === 13) {
        evnt.preventDefault();
    }
    var charC = (evnt.which) ? evnt.which : evnt.keyCode;
    if(evnt.target.value.length===12){
        return false;
    }
    if (evnt.target.value.length === 9 && (charC === 86 || 118)) {
        if (!evnt.target.value.includes("v") || !evnt.target.value.includes("V")) {
            return true;
        }
    }

    if (charC > 31 && (charC < 48 || charC > 57))
        return false;
    return true;
}

function reteriveNIC(event) {
    var NICNo = $(NIC_FILED).val();
    var dayText = 0;
    var year = "";
    var month = "";
    var day = "";
    var gender = "";
    $(DOB_FIELD).val("");
    if (NICNo.length == 12 || (NICNo.length == 10 && NICNo.toUpperCase().endsWith('V') && $.isNumeric(NICNo.substr(0, 9)))) {
        // Year
        if (NICNo.length == 10) {
            year = "19" + NICNo.substr(0, 2);
            dayText = parseInt(NICNo.substr(2, 3));
        } else {
            year = NICNo.substr(0, 4);
            dayText = parseInt(NICNo.substr(4, 3));
        }

        // Gender
        if (dayText > 500) {
            gender = "Female";
            dayText = dayText - 500;
        } else {
            gender = "Male";
        }

        // Day Digit Validation
        if (dayText < 1 && dayText > 366) {
            $(DOB_FIELD).next().html("Invalid NIC NO");
        } else {

            //Month
            if (dayText > 335) {
                day = dayText - 335;
                month = "December";
            } else if (dayText > 305) {
                day = dayText - 305;
                month = "November";
            } else if (dayText > 274) {
                day = dayText - 274;
                month = "October";
            } else if (dayText > 244) {
                day = dayText - 244;
                month = "September";
            } else if (dayText > 213) {
                day = dayText - 213;
                month = "August";
            } else if (dayText > 182) {
                day = dayText - 182;
                month = "July";
            } else if (dayText > 152) {
                day = dayText - 152;
                month = "June";
            } else if (dayText > 121) {
                day = dayText - 121;
                month = "May";
            } else if (dayText > 91) {
                day = dayText - 91;
                month = "April";
            } else if (dayText > 60) {
                day = dayText - 60;
                month = "March";
            } else if (dayText < 32) {
                month = "January";
                day = dayText;
            } else if (dayText > 31) {
                day = dayText - 31;
                month = "February";
            }

            // Show Details
            // if((day+"").length===1){
            //     day="0"+day;
            // }
            $(GENDER_SELECTOR+" > option").each(function() {
                if(this.text.toUpperCase()===gender.toUpperCase()){
                    $(GENDER_SELECTOR).dropdown('set selected',this.value);
                }
            });

            $(DOB_FIELD).val(month + " " + day + ", " + year);
        }
    }
}