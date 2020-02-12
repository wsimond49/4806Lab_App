var AddButton = {
    id: 1,
    setup: function () {
        $('#buddy_table').remove();
        var table = $('<table id="buddy_table">' +
            '<tbody>' +
            '<tr>' +
            '<th>Name</th>' +
            '<th>Address</th>' +
            '<th>Birthday</th>' +
            '<th>Company</th>' +
            '<th>Phone Number</th>' +
            '</tr>' +
            '</tbody>' +
            '</table>');
        table.insertBefore('#add_form');
        AddButton.checkForPreFilledTable();
        $('#add_button').click(AddButton.addBuddy);
    },
    addBuddy: function () {
        // Make sure that all the fields are full
        var buddy = {
            id: AddButton.id,
            name: $('#name').val(),
            address: $('#address').val(),
            birthday: $('#birthday').val(),
            company: $('#company').val(),
            phoneNumber: $('#phone').val()
        };
        console.log(buddy);
        $.ajax({
            url: "buddy",
            type: "POST",
            contentType: 'application/json',
            data: JSON.stringify(buddy),
            success: AddButton.updateTable,
            error: function (xhr, status, error) {
                console.log(error);
            }
        });
        return false;
    },
    updateTable: function () {
        $('#buddy_table > tbody:last-child').append(AddButton.generateNewRow());
        AddButton.id++;
    },
    generateNewRow: function () {
        var toAdd = {}
        $.ajax({
            url: "buddy/" + AddButton.id,
            dataType: "json",
            type: "GET",
            success: function (data) {
                console.log(data);
                toAdd = data;
            },
            error: function (xhr, status, error) {
                console.log("ERROR");
                console.log(error);
            },
            async: false
        });
        return '<tr><td>' + toAdd.name + '</td><td>' + toAdd.address + '</td><td>' + toAdd.birthday + '</td><td>' +
            toAdd.company + '</td><td>' + toAdd.phoneNumber + '</td></tr>';
    },
    checkForPreFilledTable: function () {
        $.ajax({
            url: "buddy/count",
            dataType: "text",
            type: "GET",
            success: function (data) {
                var i;
                for (i = 0; i < parseInt(data); i++) {
                    AddButton.updateTable()
                }
            },
            error: function (xhr, status, error) {
                console.log("ERROR");
                console.log(error);
            },
        });
    }
};
$(AddButton.setup);