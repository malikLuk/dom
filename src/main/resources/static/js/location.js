var _this = this;

$(document).ready(function () {
  var me = this;

  $("[id^=choose_location_]").on('click', function (event) {
    event.preventDefault();
    var currentLocationId = replaceId(event, 'choose_location_', '');
    $('#current_location').text($('#get_car_list_'+ currentLocationId).parent().find('h3').text());
    _this.currentLocationId = currentLocationId;
  });

  $("[id^=get_car_list_]").on('click', function (event) {
    var currentId = replaceId(event, 'get_car_list_', '');
    getCarList(event, currentId);
  });

  $("#show_my_cars").on("click", function (event) {
    showMyCars(event);
  })

});

function showMyCars(event) {
  event ? event.preventDefault() : null;
  var headers = getHeaders();
  $.ajax({
    type: "POST",
    url: "http://localhost:8888/car_hiring/car",
    data: JSON.stringify({status: 'IS_NOT_AVAILABLE'}),
    headers: headers,
    success: function (data) {
      console.warn(data);
      var carList = $("#car_list");
      carList.empty();
      $('<div class="row text-center">')
          .append('<div class="col-md-3 col-sm-6 hero-feature" id="car_place">')
          .appendTo(carList);

      var carPlace = $('#car_place');
      data.forEach(function (value) {

        $('<div class="thumbnail" id="car_thumbnail_' + value.id + '">').append('<img src="/img/' + value.name + '.jpg" />').appendTo(carPlace);

        var carThumbnail = $('#car_thumbnail_' + value.id);
        carThumbnail.append('<div class="caption" id="car_caption_' + value.id + '">');

        var carCaption = $('#car_caption_' + value.id);
        carCaption.append('<h3>' + value.name + '</h3>').append('<p>' + value.status + '</p>');

        $('<button class="myButton" id="my_btn_id_' + value.id + '">give back</button>').appendTo(carCaption);

      });

      $("[id^=my_btn_id_]").on('click', function (event) {
        giveBack(event);
      });
    },
    error: function () {
      debugger;
    }
  });
}

function getCarList(event, currentId) {
  this.currentLocationId = currentId;
  // ищем имя текущего адреса по странице, чтобы не лезть в базу и показываем где-то наверху в h1
  $('#current_location').text($('#get_car_list_'+currentId).parent().find('h3').text());
  event ? event.preventDefault() : null;
  var headers = getHeaders();
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
        debugger;

        $('<div class="thumbnail" id="car_thumbnail_' + value.id + '">').append('<img src="/img/' + value.name + '.jpg" />').appendTo(carPlace);

        var carThumbnail = $('#car_thumbnail_' + value.id);
        carThumbnail.append('<div class="caption" id="car_caption_' + value.id + '">');

        var carCaption = $('#car_caption_' + value.id);
        carCaption.append('<h3>' + value.name + '</h3>').append('<p>' + value.status + '</p>');

        $('<button class="myButton" id="my_btn_id_' + value.id + '">hire car</button>').appendTo(carCaption);
        $('#my_btn_id_' + value.id).prop('disabled', value.status != 'IS_AVAILABLE')

      });

      $("[id^=my_btn_id_]").on('click', function (event) {
        reserve(event);
      });

    },
    error: function () {
      debugger;
    }
  });
}

function reserve(event) {
  event.preventDefault();
  var headers = getHeaders();
  var carId = replaceId(event, 'my_btn_id_', '');
  debugger;
  $.ajax({
    type: "POST",
    url: "http://localhost:8888/car_hiring/reserve",
    data: JSON.stringify({carId: carId, pickupLocationId: this.currentLocationId}),
    headers: headers,
    success: function (response) {
      updateStatus({id: response.carId, status: "IS_NOT_AVAILABLE"}, "reserve");
    },
    error: function () {
      debugger;
    }
  });
}

function giveBack(event) {
  event.preventDefault();
  debugger;
  var me = this;
  var headers = getHeaders();
  var carId = replaceId(event, 'my_btn_id_', '');
  $.ajax({
    type: "POST",
    url: "http://localhost:8888/car_hiring/give_back",
    data: JSON.stringify({carId: carId, returnLocationId: _this.currentLocationId}),
    headers: headers,
    success: function (response) {
      updateStatus({id: response.carId, status: "IS_AVAILABLE", currentLocationId: response.returnLocationId}, "giveBack");
    },
    error: function () {
      debugger;
    }
  });
}

function updateStatus(data, action) {
  var headers = getHeaders();
  debugger;
  $.ajax({
    type: "POST",
    url: "http://localhost:8888/car_hiring/car/update_status",
    data: JSON.stringify(data),
    headers: headers,
    success: function (response) {
      if (action == "giveBack") {
        showMyCars(null);
      }
      if (action == "reserve") {
        debugger;
        getCarList(null, response.currentLocationId);
      }
    },
    error: function () {
      debugger;
    }
  });
}

function getHeaders() {
  headers = {};
  var token = $("meta[name='_csrf']").attr("content");
  var tokenHeader = $("meta[name='_csrf_header']").attr("content");
  headers["content-type"] = "application/json";
  headers["cache-control"] = "no-cache";
  headers[tokenHeader] = token;
  return headers;
}

function replaceId(event, templateFrom, templateTo) {
  // вырезаем из подстроки нр get_car_list_1 get_car_list_ и
  // оставляем только номер
  return event.currentTarget.id.replace(templateFrom, templateTo);
}