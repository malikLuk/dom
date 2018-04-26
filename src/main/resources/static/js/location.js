$(document).ready(function () {

    $("[id^=get_car_list_]").on('click', function (event) {
        var currentId = event.currentTarget.id.replace('get_car_list_', '');
        go(event, currentId);
    });

    var a = $("#kek");
    a.append('<img th:src="@{\'/img/audi.jpg\'}"/>');

});

function go(event, currentId) {
    var me = this;
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
        success: function (data) {
            var carList = $("#car_list");
            carList.empty();

            $('<div class="row text-center">')
                .append('<div class="col-md-3 col-sm-6 hero-feature" id="car_place">')
                .appendTo(carList);
            var carPlace = $('#car_place');
            data.forEach(function (value) {
                $('<div class="thumbnail">').append('<img src="/img/' + value.name +'.jpg" />').appendTo(carPlace);
            });

        /*<div class="thumbnail">
                <img th:src="@{'/img/'+${car.name}+'.jpg'}" />
                <div class="caption">
                <h3 th:text="${car.name}"></h3>
                <p th:text="${car.status}"></p>
                <form th:action="@{/car_hiring/car}" method="post">
                <button class="myButton">Hire</button>
                </form>
                <!--<p th:text="${p.carPrice}+ ' EUR / day'"></p>-->

                </div>
                </div>*/

        },
        error: function () {
            debugger;
        }
    });
}

function clear(element) {
    element.innerHTML = "";
}