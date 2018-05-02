var _this = this;

$(document).ready(function () {

  /**
   * Выбор локации при клике на Choose...
   * preventDefault() нужен из-за Thymeleaf, он
   * предотвращает дефолтное поведени, когда каждый клик
   * на кнопке расценивался как изменение страницы и
   * следовательно - сигнал для ее обновления
   **/
  $("[id^=choose_location_]").on('click', function (event) {
    event.preventDefault();
    var currentLocationId = replaceId(event, 'choose_location_', '');
    $('#current_location').text($('#get_car_list_' + currentLocationId).parent().find('h3').text());
    _this.currentLocationId = currentLocationId;
    _this.currentLocationAddress = $('#get_car_list_' + currentLocationId).parent().find('h3').text();
  });

  /**
   * Навешиваем клики на кнопки в зависимости от локации
   * */
  $("[id^=get_car_list_]").on('click', function (event) {
    var locationId = replaceId(event, 'get_car_list_', '');
    getCarList(event, locationId);
  });

  /**
   * Показать машины, которые мы взяли в прокат
   * */
  $("#show_my_cars").on("click", function (event) {
    showMyCars(event);
  })

});

function showMyCars(event) {
  /**
   * Если функция инициирована кликом - то
   * предотвращаем дефолтное поведение, как
   * описано выше
   * */
  event ? event.preventDefault() : null;
  // заголовки предполагаются стандартные для реста
  var headers = getHeaders();
  $.ajax({
    type: "POST",
    url: "http://localhost:8888/car_hiring/car",
    data: JSON.stringify({status: 'IS_NOT_AVAILABLE'}),
    headers: headers,
    success: function (response) {
      var carList = $("#car_list");
      carList.empty();
      $('<div class="row text-center">')
          .append('<div class="col-md-3 col-sm-6 hero-feature" id="car_place">')
          .appendTo(carList);

      var carPlace = $('#car_place');
      response.forEach(function (value) {

        $('<div class="thumbnail" id="car_thumbnail_' + value.id + '">').append('<img src="/img/' + value.name + '.jpg" />').appendTo(carPlace);

        var carThumbnail = $('#car_thumbnail_' + value.id);
        carThumbnail.append('<div class="caption" id="car_caption_' + value.id + '">');

        var carCaption = $('#car_caption_' + value.id);
        // carCaption.append('<h3>' + value.name + '</h3>').append('<p>' + value.status + '</p>');

        $('<button class="myButton" id="my_btn_id_' + value.id + '">give back</button>').appendTo(carCaption);

      });

      $("[id^=my_btn_id_]").on('click', function (event) {
        giveBack(event);
      });
    },
    error: function () {
    }
  });
}

function getCarList(event, locationId) {
  _this.currentLocationId = locationId;
  // ищем имя текущего адреса по странице, чтобы не лезть в базу и показываем где-то наверху в h1
  _this.currentLocationAddress = $('#get_car_list_' + locationId).parent().find('h3').text();
  $('#current_location').text(_this.currentLocationAddress);
  event ? event.preventDefault() : null;
  var headers = getHeaders();
  $.ajax({
    type: "POST",
    url: "http://localhost:8888/car_hiring/car",
    data: JSON.stringify({currentLocationId: locationId}),
    headers: headers,
    success: function (response) {
      var carList = $("#car_list");
      carList.empty();
      $('<div class="row text-center">')
          .append('<div class="col-md-3 col-sm-6 hero-feature" id="car_place">')
          .appendTo(carList);

      var carPlace = $('#car_place');
      response.forEach(function (value) {

        $('<div class="thumbnail" id="car_thumbnail_' + value.id + '">').append('<img src="/img/' + value.name + '.jpg" />').appendTo(carPlace);

        var carThumbnail = $('#car_thumbnail_' + value.id);
        carThumbnail.append('<div class="caption" id="car_caption_' + value.id + '">');

        var carCaption = $('#car_caption_' + value.id);
        var status = value.status == "IS_AVAILABLE" ? "available to hire" : "unavailable";
        carCaption.append('<h3>' + value.name + '</h3>').append('<p>' + status + '</p>');

        $('<button class="myButton" id="my_btn_id_' + value.id + '">hire car</button>').appendTo(carCaption);
        $('#my_btn_id_' + value.id).prop('disabled', value.status != 'IS_AVAILABLE')

        $('<button class="myButton" id="show_history_id_' + value.id + '">show history</button>').appendTo(carCaption);

        $("#show_history_id_" + value.id).on('click', function (event) {
          showHistory(event, value.id);
        });

        $("#my_btn_id_" + value.id).on('click', function (event) {
          reserve(event);
        })

      });
    },
    error: function () {
    }
  });
}

function showHistory(event, carId) {
  event.preventDefault();
  var headers = getHeaders();
  $.ajax({
    type: "POST",
    url: "http://localhost:8888/car_hiring/filter",
    data: JSON.stringify({carId: carId}),
    headers: headers,
    success: function (response) {
      var message = "";
      if (response.length !== 0) {
        response.forEach(function (value, index) {
          if ((index & 1) == 0) { //битовое И быстрее работает
            message += "Hired: " + value.pickupDate + ", in " + value.locationAddress;
          } else {
            message += "Returned: " + value.returnDate + ", in " + value.locationAddress;
          }
          message += "\n";
        });
      } else {
        message += "No history";
      }
      alert(message);
    },
    error: function () {
    }
  });
}

function reserve(event) {
  event.preventDefault();
  var headers = getHeaders();
  var carId = replaceId(event, 'my_btn_id_', '');
  $.ajax({
    type: "POST",
    url: "http://localhost:8888/car_hiring/reserve",
    data: JSON.stringify({
      carId: carId,
      pickupLocationId: _this.currentLocationId,
      locationAddress: _this.currentLocationAddress
    }),
    headers: headers,
    success: function (response) {
      updateStatus({id: response.carId, status: "IS_NOT_AVAILABLE"}, "reserve");
    },
    error: function () {
    }
  });
}

function giveBack(event) {
  event.preventDefault();
  var headers = getHeaders();
  var carId = replaceId(event, 'my_btn_id_', '');
  if (_this.currentLocationId) {
    $.ajax({
      type: "POST",
      url: "http://localhost:8888/car_hiring/give_back",
      data: JSON.stringify({
        carId: carId,
        returnLocationId: _this.currentLocationId,
        locationAddress: _this.currentLocationAddress
      }),
      headers: headers,
      success: function (response) {
        updateStatus({
          id: response.carId,
          status: "IS_AVAILABLE",
          currentLocationId: response.returnLocationId
        }, "giveBack");
      },
      error: function () {
        alert("Please choose location");
      }
    });
  } else {
    alert("Please choose location");
  }
}

function updateStatus(data, action) {
  var headers = getHeaders();
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
        getCarList(null, response.currentLocationId);
      }
    },
    error: function () {
    }
  });
}

function getHeaders() {
  headers = {};
  /**
   * Базовый токен из коробки Spring Security
   * */
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
