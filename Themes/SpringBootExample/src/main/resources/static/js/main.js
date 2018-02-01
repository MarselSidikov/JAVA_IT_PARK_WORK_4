function updateUser(name, lastName, birthDate) {
    $.ajax({
        type: "POST",
        url: "/profile/update",
        data: {
            name: name,
            lastName: lastName,
            birthDate: birthDate
        },
        statusCode: {
            404: function() {
                alert("Не найдена");
            },
            200: function () {
                alert("Все хорошо")
            }
        }
    })
}
function fileUpload(file) {
    var formData = new FormData();
    formData.append("file", file);
    $.ajax({
        type: "POST",
        url: "/files",
        data: formData,
        contentType: false,
        processData: false,
        success: function (data) {
            alert(data)
        }
    });

    /*
    var formData = new FormData();
    formData.append("file", file);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/files", true);
    xhr.send(formData);
     */
}