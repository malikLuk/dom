$( document ).ready(function () {
    console.warn(1);
    debugger;

    $.ajax({
        type: "POST",
        url: "http://localhost:8888/car_hiring/car",
        data: JSON.stringify({id: 1}),
        headers: {
            "content-type": "application/json",
            "token": "secret_token",
            "cache-control": "no-cache"
        },
        success: function() {
            console.warn(2);
        },
        error: function(a,b,c) {
            debugger;
        }
    })

});

// function () {

// }



/*
window.onload = start;

function start() {

    this.BASE_URL = "http://localhost:8888/";

}

function chooseLocation(params, method, url) {
    debugger;
    return this.createRequest(params, method, url)
}

function createRequest(params, method, url) {
    var me = this;
    var data = null;

    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4) {
            console.log(this.responseText);
        }
    });

    xhr.open(method, me.BASE_URL + url);
    xhr.setRequestHeader("cache-control", "no-cache");

    xhr.send(data);
}*/
