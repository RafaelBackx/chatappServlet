let websocket;

window.addEventListener('load',initPage,false);


function initPage(){
    console.log("at least this works");
    openSocket();
    let sendbuttons = Array.from(document.querySelectorAll('.comment'));
    sendbuttons.forEach(element => element.addEventListener("click",send,false));
}


function openSocket(){
    websocket = new WebSocket("ws://localhost:8080/forum");
    websocket.onopen = function(event){
        console.log(event);
        console.log('connection opened');
        // writeResponse('Connection opened');
    };
    websocket.onmessage = function(event) {
        writeResponse(event.data);
    };
    websocket.onclose = function(event) {
        console.log('connection closed')
        // writeResponse('Connection closed');
    };
}

function send(event){
    console.log("send");
    console.log(event);
    let message = {};
    message['data'] = event.target.parentNode.parentNode.querySelector("input[type='text']").value;
    message['rating'] = event.target.parentNode.parentNode.querySelector("input[type='number']").value;
    message['topic'] = event.target.parentNode.parentNode.id;
    console.log(message);
    websocket.send(JSON.stringify(message));
}


function writeResponse(text){
    text = JSON.parse(text);
    console.log(text);
    console.log(text['topic']);
    console.log(text['data']);

    let topic =document.getElementById(text['topic']);
    let p = document.createElement('p');
    p.innerText = text['data'] + " - " + text['rating'];
    topic.insertBefore(p,topic.querySelector('div'));
}