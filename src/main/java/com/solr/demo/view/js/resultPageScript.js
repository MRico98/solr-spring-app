const urlSearch = "http://localhost:8080/api/search";
const urlSpellChecker = "http://localhost:8080/api/spellchecker"
const urlSuggestion = "http://localhost:8080/api/suggestion";
let originalQuery;

$(document).ready(function(){
    setActualQuery(JSON.parse(sessionStorage.getItem('jsonresponse')));
    setResults(JSON.parse(sessionStorage.getItem('jsonresponse')));
    setFacetSearch(JSON.parse(sessionStorage.getItem('jsonresponse')).facet_counts.facet_fields.host);
    setCorrection(JSON.parse(sessionStorage.getItem('jsonspellchecker')).spellcheck);
    setSuggester(JSON.parse((sessionStorage.getItem('jsonsuggestion'))).suggest.mySuggester);
    console.log($("#page1").val());
    $("#searching + input").click(function() {
        var barraBusqueda = $("#searching");
        executeQuery(barraBusqueda.val(),urlSearch,'jsonresponse',"0");
        executeQuery(barraBusqueda.val(),urlSpellChecker,'jsonspellchecker',"0");
        executeQuery(barraBusqueda.val(),urlSuggestion,'jsonsuggestion',"0");
        window.location = "resultspage.html";
    });
    $("#page1").click(function(){
        var barraBusqueda = $("#searching");
        executeQuery(barraBusqueda.val(),urlSearch,'jsonresponse',"0");
        executeQuery(barraBusqueda.val(),urlSpellChecker,'jsonspellchecker',"0");
        executeQuery(barraBusqueda.val(),urlSuggestion,'jsonsuggestion',"0");
        window.location = "resultspage.html";
    });
    $("#page2").click(function(){
        var barraBusqueda = $("#searching");
        executeQuery(barraBusqueda.val(),urlSearch,'jsonresponse',"10");
        executeQuery(barraBusqueda.val(),urlSpellChecker,'jsonspellchecker',"10");
        executeQuery(barraBusqueda.val(),urlSuggestion,'jsonsuggestion',"10");
        window.location = "resultspage.html";
    });
    $("#page3").click(function(){
        var barraBusqueda = $("#searching");
        executeQuery(barraBusqueda.val(),urlSearch,'jsonresponse',"20");
        executeQuery(barraBusqueda.val(),urlSpellChecker,'jsonspellchecker',"20");
        executeQuery(barraBusqueda.val(),urlSuggestion,'jsonsuggestion',"20");
        window.location = "resultspage.html";
    })
    $("#page4").click(function(){
        var barraBusqueda = $("#searching");
        executeQuery(barraBusqueda.val(),urlSearch,'jsonresponse',"30");
        executeQuery(barraBusqueda.val(),urlSpellChecker,'jsonspellchecker',"30");
        executeQuery(barraBusqueda.val(),urlSuggestion,'jsonsuggestion',"30");
        window.location = "resultspage.html";
    });
    $("#page5").click(function(){
        var barraBusqueda = $("#searching");
        executeQuery(barraBusqueda.val(),urlSearch,'jsonresponse',"40");
        executeQuery(barraBusqueda.val(),urlSpellChecker,'jsonspellchecker',"40");
        executeQuery(barraBusqueda.val(),urlSuggestion,'jsonsuggestion',"40");
        window.location = "resultspage.html";
    });
    $("#page6").click(function(){
        var barraBusqueda = $("#searching");
        executeQuery(barraBusqueda.val(),urlSearch,'jsonresponse',"50");
        executeQuery(barraBusqueda.val(),urlSpellChecker,'jsonspellchecker',"50");
        executeQuery(barraBusqueda.val(),urlSuggestion,'jsonsuggestion',"50");
    });
    $("#page7").click(function(){
        var barraBusqueda = $("#searching");
        executeQuery(barraBusqueda.val(),urlSearch,'jsonresponse',"60");
        executeQuery(barraBusqueda.val(),urlSpellChecker,'jsonspellchecker',"60");
        executeQuery(barraBusqueda.val(),urlSuggestion,'jsonsuggestion',"60");
        window.location = "resultspage.html";
    });
    $("#page8").click(function(){
        var barraBusqueda = $("#searching");
        executeQuery(barraBusqueda.val(),urlSearch,'jsonresponse',"70");
        executeQuery(barraBusqueda.val(),urlSpellChecker,'jsonspellchecker',"70");
        executeQuery(barraBusqueda.val(),urlSuggestion,'jsonsuggestion',"70");
    })
    $("#page9").click(function(){
        var barraBusqueda = $("#searching");
        executeQuery(barraBusqueda.val(),urlSearch,'jsonresponse',"80");
        executeQuery(barraBusqueda.val(),urlSpellChecker,'jsonspellchecker',"80");
        executeQuery(barraBusqueda.val(),urlSuggestion,'jsonsuggestion',"80");
        window.location = "resultspage.html";
    });
    $("#page10").click(function(){
        var barraBusqueda = $("#searching");
        executeQuery(barraBusqueda.val(),urlSearch,'jsonresponse',"90");
        executeQuery(barraBusqueda.val(),urlSpellChecker,'jsonspellchecker',"90");
        executeQuery(barraBusqueda.val(),urlSuggestion,'jsonsuggestion',"90");
        window.location = "resultspage.html";
    });
});

async function executeQuery(query,url,storageVariable,pageSize){
    $.ajax({
        url: setUrl(query,url,pageSize),
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

function setUrl(query,urlQuery,pageSize){
    if(query){
        urlQuery += "?query=" + query + "&startElement="+pageSize;
    }
    console.log(urlQuery);
    return urlQuery;
}

function setActualQuery(response){
    $('#searchaside input:first-child').val(response.responseHeader.params.q)
}

function setResults(results) {
    let title,description,content,url;
    let highlighting = JSON.parse(JSON.stringify(results.highlighting));
    for(contador=0;contador<results.response.docs.length;contador++) {
        if(results.response.docs[contador].title !== null){
            title = results.response.docs[contador].title[0];
        }
        else{
            title = "";
        }
        if(results.response.docs[contador].description !== null){
            description = results.response.docs[contador].description[0];
        }
        else{
            description = "";
        }
        for(const [key,value] in Object.entries(highlighting)){
            if(Object.entries(highlighting)[key][0] === results.response.docs[contador].id){
                if(Object.entries(highlighting)[key][1].content != null){
                    content = Object.entries(highlighting)[key][1].content[0];
                }
                break;
            }
        }
        content = textEdition(content);
        $('#resultsection').append('<div class="box">\n' +
            '            <p class="title roboto fontsize24">'+ title +'</p>\n' +
            '            <p class="description montserrat regularfont fontsize18 fontweight200">' + description + '</p>\n' +
            '            <p class="content montserrat regularfont fontsize14 fontweight200">' + content + '</p>\n' +
            '            <p class="url roboto regularfont fontsize14"><a href="'+ results.response.docs[contador].id +'">' + results.response.docs[contador].id + '</a></p>\n' +
            '        </div >')

    }
}

function setCorrection(spellsugestions){
    var suggestions = spellsugestions.suggestions;
    console.log(suggestions);
    for(contador=0;contador<suggestions.length && contador < 6 ;contador = contador + 2){
        console.log(contador);
        $('#correctionsection article').append(
            '<p class="parrafo montserrat">' + suggestions[contador+1].suggestion[0] + '</p>'
        );
    }
}

function setFacetSearch(facedResult){
    $('#hostsection').append(
        '<p id="'+ facedResult[0] +'" class="parrafo montserrat" onclick="facetSearch(this.id)">' + facedResult[0] +'   (' + facedResult[1] + ')' + '</p>'+
        '<p id="'+ facedResult[2] +'" class="parrafo montserrat" onclick="facetSearch(this.id)">' + facedResult[2] +'   (' + facedResult[3] + ')' + '</p>' +
        '<p id="'+ facedResult[4] +'" class="parrafo montserrat" onclick="facetSearch(this.id)">' + facedResult[4] +'   (' + facedResult[5] + ')' + '</p>' +
        '<p id="'+ facedResult[6] +'" class="parrafo montserrat" onclick="facetSearch(this.id)">' + facedResult[6] +'   (' + facedResult[7] + ')' +'</p>' +
        '<p id="'+ facedResult[9] +'" class="parrafo montserrat" onclick="facetSearch(this.id)">' + facedResult[8] +'   (' + facedResult[9] + ')' + '</p>'
    );
}

function facetSearch(facetQuery){
    var barraBusqueda = $("#searching");
    executeQuery(barraBusqueda.val() + ' and host:' + facetQuery,urlSearch,'jsonresponse',"0");
    executeQuery(barraBusqueda.val() + ' and host:' + facetQuery,urlSpellChecker,'jsonspellchecker',"0");
    executeQuery(barraBusqueda.val() + ' and host:' + facetQuery,urlSuggestion,'jsonsuggestion',"0");
    window.location = "resultspage.html";
}

function setSuggester(suggestion){
    console.log(Object.entries(suggestion)[0][1].suggestions);
    if(Object.entries(suggestion)[0][1].suggestions.length !== 0){
        $('#searchsuggestion article').append(
            '<p class="parrafo montserrat">' + Object.entries(suggestion)[0][1].suggestions[0].term + '</p>' +
            '<p class="parrafo montserrat">' + Object.entries(suggestion)[0][1].suggestions[1].term + '</p>'
        );
    }
}

function textEdition(content){
    content = content.replaceAll("<em>","<b>");
    content = content.replaceAll("</em>","</b>");
    return content;
}