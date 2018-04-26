$( document ).ready(function () {

    $("[id^=test_id_]").on('click', function(event) {
        var currentId = event.currentTarget.id.replace('test_id_', '');
        go(event, currentId);
    });
    /*$('#test_id_1').on('click', function(event) {
        go(event, 1488)
    });*/
});

function go(event, currentId) {
    debugger;
    event.preventDefault();
    var headers = {};
    var token = $("meta[name='_csrf']").attr("content");
    var tokenHeader = $("meta[name='_csrf_header']").attr("content");
    headers["content-type"] = "application/json";
    headers["cache-control"] = "no-cache";
    headers[tokenHeader] = token;

    $.ajax({
        type: "POST",
        url: "http://localhost:8888/car_hiring/car",
        data: JSON.stringify({currentLocationId: currentId}),
        headers: headers,
        success: function() {
            debugger;
        },
        error: function() {
            debugger;
        }
    });
}