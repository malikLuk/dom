$(document).ready(function () {

    $("[id^=get_car_list_]").on('click', function (event) {
        var currentId = event.currentTarget.id.replace('get_car_list_', '');  //вырезаем из подстроки нр get_car_list_1 get_car_list_ и
        go(event, currentId);                                                 // оставляем только номер
    });

});

function go(event, currentId) {
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
        success: function (data) {
            var carList = $("#car_list");
            carList.empty();
            $('<div class="row text-center">')
                .append('<div class="col-md-3 col-sm-6 hero-feature" id="car_place">')
                .appendTo(carList);

            var carPlace = $('#car_place');
            data.forEach(function (value, index) {

                $('<div class="thumbnail" id="car_thumbnail_' + index + '">').append('<img src="/img/' + value.name + '.jpg" />').appendTo(carPlace);

                var carThumbnail = $('#car_thumbnail_' + index);
                carThumbnail.append('<div class="caption" id="car_caption_' + index + '">');

                var carCaption = $('#car_caption_' + index);
                carCaption.append('<h3>' + value.name + '</h3>').append('<p>' + value.status + '</p>')

                $('<button class="myButton" id="my_btn_id_' + index + '">hire</button>').appendTo(carCaption);

            });

            wildcardEvent("my_btn_id_", "click", function () {
                return hire()
            });

        },
        error: function () {
            debugger;
        }
    });
}

function hire() {

}

function wildcardEvent(idTemplate, eventType, func) {
    $("[id^=" + idTemplate + "]").on(eventType, function (event) {
        func();
    });
}