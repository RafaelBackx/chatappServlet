$(document).ready(function () {
    $('#send').on('click',send);
    if ($('#h1')[0].innerText !== ""){
        getMessages();
    }
    $('#hidebutton').on("click",hide);
    $('#send').on('click',send)
    getMessages();
});

function send(e){
    console.log(e);
    let input = $('#input')[0].value;
    let url = "Controller?command=Chat&friend=" + $('#h1')[0].innerText + "&message="+input;
    console.log(url);
    $.ajax({
        type: 'POST',
        url: url,
        dataType: "json",
        success: showMessages
    });
    $('#input')[0].value = "";
}

function showMessages(json){
    $('.right').remove();
    $('.left').remove();
    for (let message in json){
        console.log(json[message].data);
        let m = $("<li></li>").text(json[message].data);
        m.addClass(json[message].position);
        $("#messages").append(m);
    }
    setTimeout(getMessages,5000);
}

function getMessages(){
    $.ajax({
        type:"GET",
        url:"Controller?command=GetMessages&friend="+$("#h1")[0].innerText,
        dataType: "json",
        success:showMessages
    });
}
function hide(){
    console.log("pls work");
    let options = {to:{width:200,height:60}};
    $('#friends').toggle('slide',options,500);
}