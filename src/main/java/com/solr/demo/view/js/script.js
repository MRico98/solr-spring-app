const url = "http://localhost:8080/api/search";

$(document).ready(function(){
    $("#submitbutton").click(function(){
        executeQuery($("#searchbar").val())
    });
});

function executeQuery(query){
    $.ajax({
        url: setUrl(query),
        type: "GET",
        crossDomain: true,
        dataType: 'json',
        beforeSend: function(request) {
            request.setRequestHeader("Access-Control-Allow-Origin", "localhost");
        },
    }).done(function (data, textStatus, jqXHR) {
        console.log(data);
    }).fail(function (jqXHR, textStatus, errorThrown) {
        console.log(jqXHR);
        console.log(textStatus);
    });
}

function setUrl(query){
    let urlQuery = url;
    if(query){
        urlQuery += "?query=" + query;
    }
    console.log(urlQuery);
    return urlQuery;
}

