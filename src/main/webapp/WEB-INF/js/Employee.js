function validateEmployee(){

    var firstName   = $('#firstName').val();
    var lastName    = $('#lastName').val();
    var nic         = $('#nic').val();
    var mobile      = $('#mobile').val();
    var home        = $('#home').val();
    var dob         = $('#dob').val();
    var addressLine1 = $('#addressLine1').val();
    var city        = $('#city').val();

    if(firstName.length < 3){

        $('#firstName').after("<Span>Please enter a valid name from jquery</Span>");

    }

    if(lastName.length < 3){

        $('#lastName').after("<Span>Please enter a valid name from jquery</Span>");

    }


    if(nic.length > 0){

        var nicRegex = /^([0-9]{9}[V|v|x|X])|([0-9]{12})^/
        var valNic = nicRegex.test(nic);
        if(!valNic) {
            $('#nic').after("<Span>Please enter a valid nic from jquery</Span>");
        }
    }

}
