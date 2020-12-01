$(document).ready(function () {

    initializeNIC("#nic", "#gender", "#dob");
    $('.only-letters').keypress(isCharacter);
    $('.first-capital').keyup(firstCapitalLetter);
    $('.contact').keydown(enforceFormat);
    $('.contact').keyup(formatToPhone);

    $('.field.ui.calendar').calendar({
        type: 'date'
    });

    $('.ui.dropdown').dropdown({selectOnKeydown: true});
    $('.ui.dropdown').search;
    var CURRENT_PAGE = 0;

    function paginate() {
        if (CURRENT_PAGE > 0) {
            $('.previous').removeClass('disabled');
        } else {
            $('.previous').addClass('disabled');
        }

        if (CURRENT_PAGE == 2) {
            $('.next').addClass('positive');
            $('.next').find('i').removeClass('left arrow');
            $('.next').find('i').addClass('check');
        } else {
            $('.next').removeClass('positive');
            $('.next').find('i').removeClass('check');
            $('.next').find('i').addClass('left arrow');
        }

        $('#step1').removeClass('active');
        $('#step2').removeClass('active');
        $('#step3').removeClass('active');

        if (CURRENT_PAGE === 0) {
            $('#step1').addClass('active');
        } else if (CURRENT_PAGE === 1) {
            $('#step2').addClass('active');
        }
        if (CURRENT_PAGE === 2) {
            $('#step3').addClass('active');
        }
    }

    function isValidPersonalDetails() {
        var statusFullname = true;
        var statusNameWIntial = true;
        var statusNIC = true;
        var statusDOB = true;

        if (!isEmpty($('#full_name').val())) {
            statusFullname = true;
        } else {
            statusFullname = false;
            if (!$('#full_name').next('div').hasClass('transition visible')) {
                $('#full_name').next('div').transition('fly right');
            }
        }

        if (!isEmpty($('#name_with_initial').val())) {
            statusNameWIntial = true;
        } else {
            statusNameWIntial = false;
            if (!$('#name_with_initial').next('div').hasClass('transition visible')) {
                $('#name_with_initial').next('div').transition('fly right');
            }
        }

        if (!isEmpty($('#nic').val())) {
            if (isNIC($('#nic').val())) {
                statusNIC = true;
            } else {
                statusNIC = false;
                $('#nic').next('div').find('div').text('Please enter valid National Identity Number.');
                if (!$('#nic').next('div').hasClass('transition visible')) {
                    $('#nic').next('div').transition('fly right');
                }
            }
        } else {
            statusNIC = false;
            $('#nic').next('div').find('div').text('Please enter National Identity Number.');
            if (!$('#nic').next('div').hasClass('transition visible')) {
                $('#nic').next('div').transition('fly right');
            }
        }

        if (!isEmpty($('#dob').val())) {
            if (Date.parse($('#dob').val())) {
                statusDOB = true;
            } else {
                statusDOB = false;
                $('#dob').next('div').find('div').text('Please select valid Date of Birth.');
                if (!$('#dob').next('div').hasClass('transition visible')) {
                    $('#dob').next('div').transition('fly right');
                }
            }
        } else {
            statusDOB = false;
            $('#dob').next('div').find('div').text('Please select Date of Birth.');
            if (!$('#dob').next('div').hasClass('transition visible')) {
                $('#dob').next('div').transition('fly right');
            }
        }

        if (statusFullname && $('#full_name').next('div').hasClass('transition visible')) {
            $('#full_name').next('div').transition('fly left');
        }

        if (statusNameWIntial && $('#name_with_initial').next('div').hasClass('transition visible')) {
            $('#name_with_initial').next('div').transition('fly left');
        }
        if (statusNIC && $('#nic').next('div').hasClass('transition visible')) {
            $('#nic').next('div').transition('fly left');
        }
        if (statusDOB && $('#dob').next('div').hasClass('transition visible')) {
            $('#dob').next('div').transition('fly left');
        }

        return statusFullname && statusNameWIntial && statusNIC && statusDOB;
    }

    function isValidContactDetails() {
        var statusContact = true;
        var statusAddress = true;
        var statusEmail = true;

        if (!isEmpty($('#mobile').val())) {
            if(isValidPhone($('#mobile').val())){
                statusContact = true;
            }else{
                statusContact = false;
                $('#mobile').next('div').find('div').text('Please enter valid Mobile Number.');
                if (!$('#mobile').next('div').hasClass('transition visible')) {
                    $('#mobile').next('div').transition('fly right');
                }
            }
        } else {
            statusContact = false;
            $('#mobile').next('div').find('div').text('Please enter Mobile Number.');
            if (!$('#mobile').next('div').hasClass('transition visible')) {
                $('#mobile').next('div').transition('fly right');
            }
        }

        if (!isEmpty($('#addressLine1').val())) {
            statusAddress = true;
        } else {
            statusAddress = false;
            if (!$('#addressLine1').next('div').hasClass('transition visible')) {
                $('#addressLine1').next('div').transition('fly right');
            }
        }

        if (!isEmpty($('#email').val())) {
            if (isValidateEmail($('#email').val())) {
                statusEmail = true;
            } else {
                statusEmail = false;
                $('#email').next('div').find('div').text('Please enter valid Email.');
                if (!$('#email').next('div').hasClass('transition visible')) {
                    $('#email').next('div').transition('fly right');
                }
            }
        } else {
            statusEmail = false;
            $('#email').next('div').find('div').text('Please enter Email.');
            if (!$('#email').next('div').hasClass('transition visible')) {
                $('#email').next('div').transition('fly right');
            }
        }

        if (statusContact && $('#mobile').next('div').hasClass('transition visible')) {
            $('#mobile').next('div').transition('fly left');
        }

        if (statusAddress && $('#addressLine1').next('div').hasClass('transition visible')) {
            $('#addressLine1').next('div').transition('fly left');
        }
        if (statusEmail && $('#email').next('div').hasClass('transition visible')) {
            $('#email').next('div').transition('fly left');
        }

        return statusContact && statusAddress && statusEmail;
    }

    function isValidExtraDetails() {
        var statusEpf = true;

        if (!isEmpty($('#epf_no').val())) {
            if($('#epf_no').val().length>=4){
                statusEpf = true;
            }else{
                statusEpf = false;
                $('#epf_no').next('div').find('div').text('Please enter valid EPF Number.');
                if (!$('#epf_no').next('div').hasClass('transition visible')) {
                    $('#epf_no').next('div').transition('fly right');
                }
            }
        } else {
            statusEpf = false;
            $('#epf_no').next('div').find('div').text('Please enter EPF Number.');
            if (!$('#epf_no').next('div').hasClass('transition visible')) {
                $('#epf_no').next('div').transition('fly right');
            }
        }

        if (statusEpf && $('#epf_no').next('div').hasClass('transition visible')) {
            $('#epf_no').next('div').transition('fly left');
        }

        return statusEpf;
    }

    $('.next').click(function (event) {
        event.preventDefault();
        if (CURRENT_PAGE === 0 && isValidPersonalDetails()) {
            $.ajax({
                type: 'GET',
                url: '/api/employee-findbynic/'+$('#nic').val(),
                data: '',
                dataType: "json",
                success: function (data) {
                    if(data.hasOwnProperty('nic') && data.nic===$('#nic').val()){
                        $('#nic').next('div').find('div').text('This nic already exists in the system.');
                        if (!$('#nic').next('div').hasClass('transition visible')) {
                            $('#nic').next('div').transition('fly right');
                        }
                    }else{
                        $('#personal-details').transition('fly left', function () {
                            $('#contact-details').transition('fly right');
                            CURRENT_PAGE++;
                            paginate();
                        });
                    }
                }
            });
        } else if (CURRENT_PAGE === 1 && isValidContactDetails()) {
            $.ajax({
                type: 'GET',
                url: '/api/employee-findbyemail/'+$('#email').val(),
                data: '',
                dataType: "json",
                success: function (data) {
                    if(data.hasOwnProperty('email') && data.email===$('#email').val()){
                        $('#email').next('div').find('div').text('This Email already exists in the system.');
                        if (!$('#email').next('div').hasClass('transition visible')) {
                            $('#email').next('div').transition('fly right');
                        }
                    }else{
                        $('#contact-details').transition('fly left', function () {
                            $('#extra-details').transition('fly right');
                            CURRENT_PAGE++;
                            paginate();
                        });
                    }
                }
            });

        } else if (CURRENT_PAGE === 2 && isValidExtraDetails()) {
            $("#employeeform").unbind('submit').submit();
        }
    });

    $('.previous').click(function () {
        if (CURRENT_PAGE === 1) {
            $('#contact-details').transition('fly right', function () {
                $('#personal-details').transition('fly left');
                CURRENT_PAGE--;
                paginate();
            });
        } else if (CURRENT_PAGE === 2) {
            $('#extra-details').transition('fly right', function () {
                $('#contact-details').transition('fly left');
                CURRENT_PAGE--;
                paginate();
            });
        }
    });
});