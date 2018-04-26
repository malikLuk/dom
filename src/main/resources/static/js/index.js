$( document ).ready(function () {
    $('#test_id').on('click', go);
});

function go() {
    debugger;
    var headers = {};
    var token = $("meta[name='_csrf']").attr("content");
    var tokenHeader = $("meta[name='_csrf_header']").attr("content");
    headers["content-type"] = "application/json";
    headers["cache-control"] = "no-cache";
    headers[tokenHeader] = token;

    $.ajax({
        type: "POST",
        url: "http://localhost:8888/car_hiring/car",
        data: JSON.stringify({id: 1}),
        headers: headers,
        success: function() {
        },
        error: function() {
        }
    });
}

