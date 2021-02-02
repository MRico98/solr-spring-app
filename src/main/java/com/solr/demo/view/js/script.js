const urlSearch = "http://localhost:8080/api/search";
const urlSpellChecker = "http://localhost:8080/api/spellchecker"
const urlSuggestion = "http://localhost:8080/api/suggestion";
let jsonReponse;

$(document).ready(function(){
    $("#submitbutton").click(function(){
        console.log(urlSearch);
        var barraBusqueda = $("#searchbar");
        executeQuery(barraBusqueda.val(),urlSearch,'jsonresponse');
        executeQuery(barraBusqueda.val(),urlSpellChecker,'jsonspellchecker');
        executeQuery(barraBusqueda.val(),urlSuggestion,'jsonsuggestion');
        window.location = "pages/resultspage.html";
    });
});

async function executeQuery(query,url,storageVariable){
    $.ajax({
        url: setUrl(query,url),
        type: "GET",
        crossDomain: true,
        dataType: 'json',
        beforeSend: function(request) {
            request.setRequestHeader("Access-Control-Allow-Origin", "localhost");
        },
        async: false
    }).done(function (data, textStatus, jqXHR) {
        console.log(JSON.stringify(data));
        sessionStorage.setItem(storageVariable,JSON.stringify(data));
    }).fail(function (jqXHR, textStatus, errorThrown) {
        console.log(jqXHR);
        console.log(textStatus);
    });
}

function setUrl(query,urlQuery){
    if(query){
        urlQuery += "?query=" + query;
    }
    console.log(urlQuery);
    return urlQuery;
}



