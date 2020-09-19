$(document).ready( function () {
    var table = $('#employeesTable').DataTable({
        "sAjaxSource": "/employee",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "id"},
            { "mData": "first_name" },
            { "mData": "last_name" },
            { "mData": "nic" },
            { "mData": "mobile" },
            { "mData": "city" }
        ]
    })
});
