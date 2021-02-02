$(document).ready(function(){
    setActualQuery(JSON.parse(sessionStorage.getItem('jsonresponse')));
    setResults(JSON.parse(sessionStorage.getItem('jsonresponse')));
    setFacetSearch(JSON.parse(sessionStorage.getItem('jsonresponse')).facet_counts.facet_fields.host);
    setCorrection(JSON.parse(sessionStorage.getItem('jsonspellchecker')).spellcheck);
    setSuggester(JSON.parse((sessionStorage.getItem('jsonsuggestion'))).suggest.mySuggester);
});

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
            '<p class="parrafo montserrat">' + suggestions[contador] + '</p>'+
            '<p class="parrafo montserrat">' + suggestions[contador+1].suggestion[0] + '</p>'
        );
    }
}

function setFacetSearch(facedResult){
    $('#hostsection').append(
        '<p class="parrafo montserrat">' + facedResult[0] +'   (' + facedResult[1] + ')' + '</p>'+
        '<p class="parrafo montserrat">' + facedResult[2] +'   (' + facedResult[3] + ')' + '</p>' +
        '<p class="parrafo montserrat">' + facedResult[4] +'   (' + facedResult[5] + ')' + '</p>' +
        '<p class="parrafo montserrat">' + facedResult[6] +'   (' + facedResult[7] + ')' +'</p>' +
        '<p class="parrafo montserrat">' + facedResult[8] +'   (' + facedResult[9] + ')' + '</p>'
    );
}

function setSuggester(suggestion){
    console.log(suggestion);
    console.log(Object.entries(suggestion)[0][1].suggestions[0].term);
    $('#searchsuggestion article').append(
        '<p class="parrafo montserrat">' + Object.entries(suggestion)[0][1].suggestions[0].term + '</p>' +
        '<p class="parrafo montserrat">' + Object.entries(suggestion)[0][1].suggestions[1].term + '</p>'
    );
}

function textEdition(content){
    content = content.replaceAll("<em>","<b>");
    content = content.replaceAll("</em>","</b>");
    return content;
}